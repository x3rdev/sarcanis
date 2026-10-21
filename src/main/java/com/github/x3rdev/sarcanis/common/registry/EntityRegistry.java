package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.entity.Biophage;
import com.github.x3rdev.sarcanis.common.entity.DaggerEntity;
import com.github.x3rdev.sarcanis.common.entity.Mosquito;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Sarcanis.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<Mosquito>> MOSQUITO = ENTITY_TYPES.register("mosquito",
            () -> EntityType.Builder.of(Mosquito::new, MobCategory.MONSTER)
                            .sized(3, 3)
                            .build("mosquito")
            );

    public static final DeferredHolder<EntityType<?>, EntityType<Biophage>> BIOPHAGE = ENTITY_TYPES.register("biophage",
            () -> EntityType.Builder.of(Biophage::new, MobCategory.MONSTER)
                    .sized(2, 5)
                    .build("biophage")
    );

    public static final DeferredHolder<EntityType<?>, EntityType<DaggerEntity>> DAGGER_ENTITY = ENTITY_TYPES.register("dagger_entity",
            () -> EntityType.Builder.<DaggerEntity>of(DaggerEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("dagger_entity")
    );
}
