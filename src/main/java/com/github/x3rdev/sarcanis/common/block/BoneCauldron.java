package com.github.x3rdev.sarcanis.common.block;

import com.github.x3rdev.sarcanis.common.blockentity.BoneCauldronBlockEntity;
import com.github.x3rdev.sarcanis.common.blockentity.PurifierBlockEntity;
import com.github.x3rdev.sarcanis.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BoneCauldron extends Block implements EntityBlock {
    public BoneCauldron(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BoneCauldronBlockEntity(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return BlockEntityRegistry.createTicker(type, BlockEntityRegistry.BONE_CAULDRON_BLOCK_ENTITY.get(), BoneCauldronBlockEntity::tick);
    }
}
