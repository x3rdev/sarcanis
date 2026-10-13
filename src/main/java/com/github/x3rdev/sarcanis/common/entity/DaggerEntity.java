package com.github.x3rdev.sarcanis.common.entity;

import com.github.x3rdev.sarcanis.common.item.Dagger;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DaggerEntity extends Entity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int tick;
    private Entity target;
    private Dagger source;

    public DaggerEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.tick = level.getServer().getTickCount();
    }

    public static DaggerEntity registerDaggerEntity(EntityType<?> entityType, Level level) {
        return new DaggerEntity(entityType, level);
    }

    public DaggerEntity(Level level, Dagger source) {
        this(EntityRegistry.DAGGER_ENTITY.get(), level);
        this.source = source;
        source.thrownDaggers.add(this);
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
        if (this.tick > 600) {
            this.source.thrownDaggers.remove(this);
            this.source.charges++;
            if (this.target != null) {
                this.source.targetedEntities.remove(this.target);
            }
            this.discard();
        }
        this.tick++;
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
