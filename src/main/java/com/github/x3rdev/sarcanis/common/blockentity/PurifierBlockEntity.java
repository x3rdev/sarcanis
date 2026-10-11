package com.github.x3rdev.sarcanis.common.blockentity;

import com.github.x3rdev.sarcanis.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PurifierBlockEntity extends BlockEntity {
    private int ichorFluidQuantity = 0;
    private int brothFluidQuantity = 0;
    private int fuelReserved = 0;

    public PurifierBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.PURIFIER_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.ichorFluidQuantity = tag.getInt("ichorFluidQuantity");
        this.brothFluidQuantity = tag.getInt("brothFluidQuantity");
        this.fuelReserved = tag.getInt("fuelReserved");
    }

    @Override
    public void saveAdditional(CompoundTag tag,  HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("ichorFluidQuantity", this.ichorFluidQuantity);
        tag.putInt("brothFluidQuantity", this.brothFluidQuantity);
        tag.putInt("fuelReserved", this.fuelReserved);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PurifierBlockEntity blockEntity) {
        // do stuff
    }
}
