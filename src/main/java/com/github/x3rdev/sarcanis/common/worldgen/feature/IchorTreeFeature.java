package com.github.x3rdev.sarcanis.common.worldgen.feature;

import com.github.x3rdev.sarcanis.common.block.IchorTreeBranch;
import com.github.x3rdev.sarcanis.common.registry.BlockRegistry;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.List;

public class IchorTreeFeature extends Feature<IchorTreeFeature.Config> {

    public IchorTreeFeature() {
        super(Config.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<IchorTreeFeature.Config> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        if(!level.getBlockState(origin.below()).isSolid()) {
            return false;
        }

        setBlock(level, origin, BlockRegistry.ICHOR_TREE_TRUNK_BOTTOM.get().defaultBlockState());
        setBlock(level, origin.above(), BlockRegistry.ICHOR_TREE_TRUNK_MIDDLE.get().defaultBlockState());
        setBlock(level, origin.above(2), BlockRegistry.ICHOR_TREE_TRUNK_TOP.get().defaultBlockState());
        setBlock(level, origin.above(3), BlockRegistry.ICHOR_TREE_RECEPTACLE.get().defaultBlockState());
        setBlock(level, origin.above(4), BlockRegistry.ICHOR_TREE_BULB.get().defaultBlockState());

        for(Direction dir : Direction.allShuffled(context.random())) {
            if(dir.getAxis().isHorizontal()) {
                generateBranch(context, origin.above(3), dir);
            }
        }
        return true;
    }

    private void generateBranch(FeaturePlaceContext<IchorTreeFeature.Config> context, BlockPos receptaclePos, Direction dir) {
        int branchLength = context.random().nextInt(0, 2);
        for(int i = 0; i < branchLength; i++) {
            BlockState branchState = BlockRegistry.ICHOR_TREE_OVERGROWN_BRANCH.get().defaultBlockState().setValue(IchorTreeBranch.FACING, dir);
            safeSetBlock(context.level(), receptaclePos.relative(dir, i+1), branchState, BlockBehaviour.BlockStateBase::isAir);
        }
        List<BlockState> endStates = List.of(
                Blocks.AIR.defaultBlockState(),
                BlockRegistry.ICHOR_TREE_OVERGROWN_FERTILE_BRANCH.get().defaultBlockState().setValue(IchorTreeBranch.FACING, dir),
                BlockRegistry.ICHOR_TREE_EMPTY_PRODUCER.get().defaultBlockState().setValue(IchorTreeBranch.FACING, dir),
                BlockRegistry.ICHOR_TREE_FERTILE_BRANCH.get().defaultBlockState().setValue(IchorTreeBranch.FACING, dir)
        );
        BlockState endState = endStates.get(context.random().nextInt(endStates.size()));
        safeSetBlock(context.level(), receptaclePos.relative(dir, branchLength+1), endState, BlockBehaviour.BlockStateBase::isAir);
    }


    public record Config(float fertility) implements FeatureConfiguration {
        public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.floatRange(0, 1).fieldOf("fertility").forGetter(Config::fertility)
        ).apply(instance, Config::new));
    }
}
