package com.github.x3rdev.sarcanis.common.network;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.item.Dagger;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

public record DaggerTargetEntity(String targetUUID) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<DaggerTargetEntity> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Sarcanis.MOD_ID, "target_entity_uuid"));

    public static final StreamCodec<ByteBuf, DaggerTargetEntity> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            DaggerTargetEntity::targetUUID,
            DaggerTargetEntity::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServerBoundPacket(final DaggerTargetEntity targetEntity, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            ServerLevel world = player.getServer().getLevel(player.level().dimension());
            Entity entity = world.getEntity(UUID.fromString(targetEntity.targetUUID));
            Vec3 entityPos = entity.position();
            Vec3 target = entityPos.add(player.getLookAngle().normalize().scale(-1));
            double distance = Vec3.ZERO.distanceTo(entityPos.subtract(player.position()));
            double reach = 0;
            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (stack.getItem() instanceof Dagger dagger) {
                reach = dagger.dashRange;
                // if we add multiple dagger-type weapons, make the cooldown apply to all of them so the player cannot switch between daggers to bypass cooldowns
                player.getCooldowns().addCooldown(player.getItemInHand(InteractionHand.MAIN_HAND).getItem(), (int) (dagger.dashCooldown * 20));
            }
            double xsize, ysize;
            if (entity instanceof LivingEntity livingEntity) {
                xsize = livingEntity.getHitbox().getXsize();
                ysize = livingEntity.getHitbox().getYsize();
            }
            else {
                xsize = entity.getBoundingBox().getXsize();
                ysize = entity.getBoundingBox().getYsize();
            }
            // simple serverside validation for whether the dash can reasonably happen
            double entityDiagonal = Math.sqrt(xsize * xsize + ysize * ysize);
            if (distance >= reach + entityDiagonal) return;
            /* future attack pattern for dagger when thrown dagger entities are implemented

            if (entity instanceof DaggerEntity dagger) {
                ServerLevel level = player.level().getServer().getLevel(player.level().dimension());
                List<LivingEntity> entities = player.level().getEntitiesOfClass(LivingEntity.class, player.getHitbox().inflate(1));
                entities.forEach(targetEntity -> {
                    targetEntity.hurtServer(
                            level,
                            new DamageSource(
                                    player.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.PLAYER_ATTACK),
                                    targetEntity,
                                    player,
                                    dagger.position()
                            ),
                            dagger.rawDamage
                    );
                });
                dagger.kill(level);
                // summon particles to indicate damage radius
            } */
            context.player().teleportTo(target.x(), target.y(), target.z());
        });
    }
}
