package com.github.x3rdev.sarcanis.common.worldgen;

import com.github.x3rdev.sarcanis.common.registry.BlockRegistry;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class SarcanisSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.RuleSource flesh = SurfaceRules.state(BlockRegistry.FLESH_BLOCK.get().defaultBlockState());

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(SarcanisBiomes.FLESHLANDS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, flesh))
        );
    }
}
