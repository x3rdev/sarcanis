package com.github.x3rdev.sarcanis.common.worldgen;

import com.github.x3rdev.sarcanis.Sarcanis;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SarcanisPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ICHOR_TREE_KEY = registerKey("ichor_tree");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(ICHOR_TREE_KEY, new PlacedFeature(configuredFeatures.getOrThrow(SarcanisConfiguredFeatures.ICHOR_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.5F, 1))));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Sarcanis.MOD_ID, name));
    }
}
