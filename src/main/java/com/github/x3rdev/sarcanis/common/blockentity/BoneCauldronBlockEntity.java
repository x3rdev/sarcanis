package com.github.x3rdev.sarcanis.common.blockentity;

import com.github.x3rdev.sarcanis.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BoneCauldronBlockEntity extends BlockEntity {
    private int waterLevel = 0;
    private int ichorLevel = 0;
    private int infectedFleshCount = 0;

    public BoneCauldronBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.BONE_CAULDRON_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        tag.getInt("waterLevel");
        tag.getInt("ichorLevel");
        tag.getInt("infectedFleshCount");
    }

    @Override
    public void saveAdditional(CompoundTag tag,  HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("waterLevel", waterLevel);
        tag.putInt("ichorLevel", ichorLevel);
        tag.putInt("infectedFleshCount", infectedFleshCount);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BoneCauldronBlockEntity blockEntity) {
        // do stuff
    }
}
