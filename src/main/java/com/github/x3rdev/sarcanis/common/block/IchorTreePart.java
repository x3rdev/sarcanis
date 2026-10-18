package com.github.x3rdev.sarcanis.common.block;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.blockentity.IchorTreePartBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class IchorTreePart extends Block implements EntityBlock {
    private final ResourceLocation texture;

    public IchorTreePart(Properties properties, String texture) {
        super(properties);
        this.texture = ResourceLocation.fromNamespaceAndPath(Sarcanis.MOD_ID, texture);
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new IchorTreePartBlockEntity(pos, state);
    }
}
