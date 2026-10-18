package com.github.x3rdev.sarcanis.common.worldgen;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class SarcanisBiomes {
    public static final ResourceKey<Biome> FLESHLANDS = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(Sarcanis.MOD_ID, "fleshlands"));

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(FLESHLANDS, fleshlands(context));
    }

    private static Biome fleshlands(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.MOSQUITO.get(), 20, 1, 3));
        spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.BIOPHAGE.get(), 10, 1, 2));

        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generation);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generation);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generation);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generation);
        BiomeDefaultFeatures.addDefaultSprings(generation);
        BiomeDefaultFeatures.addSurfaceFreezing(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SarcanisPlacedFeatures.ICHOR_TREE_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(0x9E6A6A)
                        .fogColor(0x8A4A4A)
                        .waterColor(0x6B1E1E)
                        .waterFogColor(0x2A0A0A)
                        .grassColorOverride(0x8C3B3B)
                        .foliageColorOverride(0x7A2E2E)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();
    }
}
