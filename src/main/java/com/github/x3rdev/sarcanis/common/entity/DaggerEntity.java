package com.github.x3rdev.sarcanis.common.entity;

import com.github.x3rdev.sarcanis.common.item.Dagger;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DaggerEntity extends Entity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final int tick;
    private int life = 0;
    private Entity target;
    private ItemStack source;
    private Dagger dagger;

    public DaggerEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.tick = level.getServer().getTickCount();
    }

    public DaggerEntity(Level level, ItemStack source) {
        this(EntityRegistry.DAGGER_ENTITY.get(), level);
        this.source = source;
        if (source.getItem() instanceof Dagger) {
            this.dagger =  (Dagger) source.getItem();
            this.dagger.thrownDaggers.add(this);
        }
    }

    /*
    TODO:
        1. make it so that the dagger sticks to blocks like arrows
        2. make the dagger disappear upon hitting entities, unlike arrows
        3. these entities will play some kind of particle (likely the crit particle) to indicate they are marked
        4. animate the daggers so that the tip always points in the direction of motion, like arrows
     */

    @Override
    public void tick() {
        super.tick();
        if (this.life > 600) {
            this.dagger.thrownDaggers.remove(this);
            this.dagger.charges++;
            this.discard();
        }
        this.life++;
    }

    private void hitEntity(Entity target) {
        this.dagger.thrownDaggers.remove(this);
        this.dagger.targetedEntities.add(target);
        this.damageEntity(target);
        this.discard();
    }

    private void damageEntity(Entity target){
        if (target instanceof LivingEntity entity) {
            //DamageSource source = entity.damageSources().playerAttack();
            //entity.hurt(source, this.dagger.damage);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // deal with animations later
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
