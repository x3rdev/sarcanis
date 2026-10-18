package com.github.x3rdev.sarcanis.common.worldgen;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.registry.FeatureRegistry;
import com.github.x3rdev.sarcanis.common.worldgen.feature.IchorTreeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class SarcanisConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ICHOR_TREE_KEY = registerKey("ichor_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(ICHOR_TREE_KEY, new ConfiguredFeature<>(
                FeatureRegistry.ICHOR_TREE.get(), new IchorTreeFeature.Config(0.6F))
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Sarcanis.MOD_ID, name));
    }
}
