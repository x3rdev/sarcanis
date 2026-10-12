package com.github.x3rdev.sarcanis.common.item;

import com.github.x3rdev.sarcanis.common.entity.DaggerEntity;
import com.github.x3rdev.sarcanis.common.network.DaggerTargetEntity;
import com.github.x3rdev.sarcanis.common.utility.ObjIntMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;

public class Dagger extends Item {
    public final int totalCharges;
    public int charges;
    public double dashRange;
    public double dashCooldown;
    private boolean isPlayingParticles = false;
    private int modTick;
    private int binaryRandom;

    public Dagger(Properties properties, int totalCharges, double dashRange, double dashCooldown) {
        super(properties);
        this.totalCharges = totalCharges;
        this.charges = totalCharges;
        this.dashRange = dashRange;
        // cooldown in seconds
        this.dashCooldown = dashCooldown;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        if (!level.isClientSide() || hand != InteractionHand.MAIN_HAND) return InteractionResultHolder.pass(item);

        Minecraft instance = Minecraft.getInstance();
        float delta = instance.getTimer().getGameTimeDeltaTicks();
        HitResult hitResult = unboundedRayCast(instance.player, delta, instance.getCameraEntity(), this.dashRange);
        if (hitResult instanceof EntityHitResult result) {
            Entity entity = result.getEntity();
            if (isValidTarget(entity)) {
                String entityUUID = entity.getUUID().toString();
                PacketDistributor.sendToServer(new DaggerTargetEntity(entityUUID));
                return InteractionResultHolder.success(item);
            }

        }
        else {
            // don't currently know how to make this depend on user keybinds
            if (instance.mouseHandler.isLeftPressed()) {

            }
        }
        return InteractionResultHolder.pass(item);
    }

    private static boolean isValidTarget(Entity entity) {
        return entity instanceof LivingEntity || entity instanceof DaggerEntity;
    }

    private static HitResult unboundedRayCast(LocalPlayer player, float partialTicks, Entity cameraEntity, double castRange) {
        // leaving this method here in case we want separate logic for dashing to certain blocks
        return pick(cameraEntity, player.blockInteractionRange(), castRange, partialTicks);
    }

    // copied from GameRenderer class
    private static HitResult pick(Entity entity, double blockInteractionRange, double entityInteractionRange, float partialTick) {
        double d0 = Math.max(blockInteractionRange, entityInteractionRange);
        double d1 = Mth.square(d0);
        Vec3 vec3 = entity.getEyePosition(partialTick);
        HitResult hitresult = entity.pick(d0, partialTick, false);
        double d2 = hitresult.getLocation().distanceToSqr(vec3);
        if (hitresult.getType() != HitResult.Type.MISS) {
            d1 = d2;
            d0 = Math.sqrt(d2);
        }

        Vec3 vec31 = entity.getViewVector(partialTick);
        Vec3 vec32 = vec3.add(vec31.x * d0, vec31.y * d0, vec31.z * d0);
        AABB aabb = entity.getBoundingBox().expandTowards(vec31.scale(d0)).inflate(1.0, 1.0, 1.0);
        EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(
                entity, vec3, vec32, aabb, p_234237_ -> !p_234237_.isSpectator() && p_234237_.isPickable(), d1
        );
        return entityhitresult != null && entityhitresult.getLocation().distanceToSqr(vec3) < d2
                ? filterHitResult(entityhitresult, vec3, entityInteractionRange)
                : filterHitResult(hitresult, vec3, blockInteractionRange);
    }

    private static HitResult filterHitResult(HitResult hitResult, Vec3 from, double maxRange) {
        Vec3 hitLocation = hitResult.getLocation();
        if (!hitLocation.closerThan(from, maxRange)) {
            Vec3 location = hitResult.getLocation();
            Direction direction = Direction.getNearest(location.x - from.x, location.y - from.y, location.z - from.z);
            return BlockHitResult.miss(location, direction, BlockPos.containing(location));
        }
        else return hitResult;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (!level.isClientSide()) return;
        if (!isSelected) return;
        if (entity instanceof Player player) {
            if (player.getCooldowns().isOnCooldown(stack.getItem())) return;
            Minecraft instance = Minecraft.getInstance();
            long tick = instance.player.tickCount;
            float delta = instance.getTimer().getGameTimeDeltaTicks();
            HitResult hitResult = unboundedRayCast(instance.player, delta, instance.getCameraEntity(), this.dashRange);
            if (hitResult instanceof EntityHitResult result && result.getEntity() instanceof LivingEntity livingEntity) {
                // number of particles in the ring
                int iMax = 20;
                if (!isPlayingParticles) {
                    this.modTick = (int) (tick % iMax);
                    this.binaryRandom = Math.random() + 0.5 > 1 ? 1 : -1;
                    this.isPlayingParticles = true;
                }
                Vec3 entityPos = livingEntity.position();

                List<ObjIntMap<Vec3>> particleLocations = new ArrayList<>();
                for (int i = 0; i < iMax; i++) {
                    double entitySizeX = livingEntity.getBoundingBox().getXsize();
                    double entitySizeZ = livingEntity.getBoundingBox().getZsize();
                    double entitySize = Math.sqrt(entitySizeX * entitySizeX + entitySizeZ * entitySizeZ);
                    double lookAngle = player.getXRot() * Math.PI/180;
                    double iAngle = this.binaryRandom * 2 * Math.PI * i/iMax;
                    double scaleFactor = entitySize * Math.sqrt(0.5);
                    ObjIntMap<Vec3> particleLocation1 = new ObjIntMap<>(
                            new Vec3(
                                    Math.sin(lookAngle + iAngle),
                                    entity.getBoundingBox().getYsize() * 0.5,
                                    Math.cos(lookAngle + iAngle)
                            ).multiply(scaleFactor, 1, scaleFactor).add(entityPos),
                            i % (iMax>>1)
                    );
                    particleLocations.add(particleLocation1);
                }
                particleLocations.forEach(particleLocationMap -> {
                    if (particleLocationMap.value() == (int) ((tick - this.modTick) % (iMax>>1))) {
                        Vec3 particleLocation = particleLocationMap.object();
                        // flame particle placeholder
                        level.addParticle(ParticleTypes.FLAME, particleLocation.x, particleLocation.y, particleLocation.z, 0, 0, 0);
                    }
                });
            }
            else isPlayingParticles = false;
        }
    }
}
