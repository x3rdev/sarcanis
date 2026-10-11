package com.github.x3rdev.sarcanis.common.item;

import com.github.x3rdev.sarcanis.common.network.DaggerTargetEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

public class Dagger extends Item {
    public final int totalCharges;
    public int charges;
    public double dashRange;
    public double dashCooldown;

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
        if (hitResult instanceof EntityHitResult result && result.getEntity() instanceof LivingEntity entity) {
            String entityUUID = entity.getUUID().toString();
            PacketDistributor.sendToServer(new DaggerTargetEntity(entityUUID));
            return InteractionResultHolder.success(item);
        }
        else {
            // dagger throw logic
        }
        return InteractionResultHolder.pass(item);
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
        float f = 1.0F;
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
        } else {
            return hitResult;
        }
    }
}
