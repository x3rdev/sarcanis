package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.worldgen.feature.IchorTreeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Sarcanis.MOD_ID);

    public static final DeferredHolder<Feature<?>, IchorTreeFeature> ICHOR_TREE = FEATURES.register("ichor_tree", IchorTreeFeature::new);
}
