package com.github.x3rdev.sarcanis.common.worldgen;

import com.github.x3rdev.sarcanis.Sarcanis;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class SarcanisTreeGrowers {
    public static final TreeGrower ICHOR_TREE = new TreeGrower(Sarcanis.MOD_ID + ":ichor_tree",
            Optional.empty(), Optional.of(SarcanisConfiguredFeatures.ICHOR_TREE_KEY), Optional.empty());
}
