package com.github.x3rdev.sarcanis.client.renderer;

import com.github.x3rdev.sarcanis.client.model.IchorTreePartModel;
import com.github.x3rdev.sarcanis.common.block.IchorTreePart;
import com.github.x3rdev.sarcanis.common.blockentity.IchorTreePartBlockEntity;
import com.github.x3rdev.sarcanis.common.registry.BlockRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class IchorTreePartRenderer extends GeoBlockRenderer<IchorTreePartBlockEntity> {

    public IchorTreePartRenderer(BlockEntityRendererProvider.Context context) {
        super(new IchorTreePartModel<>(blockEntity -> (IchorTreePart) blockEntity.getBlockState().getBlock()));
    }

    @Override
    public void render(IchorTreePartBlockEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        if (animatable.getBlockState().is(BlockRegistry.ICHOR_TREE_BULB)) {
            poseStack.translate(0, 0.01F, 0);
        }
        super.render(animatable, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
        poseStack.popPose();
    }

    @Override
    public RenderType getRenderType(IchorTreePartBlockEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        if (animatable.getBlockState().is(BlockRegistry.ICHOR_TREE_BULB)) {
            return RenderType.entityTranslucent(texture);
        }
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

    @Override
    public int getViewDistance() {
        return 92;
    }

    @Override
    public AABB getRenderBoundingBox(IchorTreePartBlockEntity blockEntity) {
        return new AABB(blockEntity.getBlockPos()).inflate(2);
    }
}
