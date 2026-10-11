package com.github.x3rdev.sarcanis.client.renderer;

import com.github.x3rdev.sarcanis.common.entity.Mosquito;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MosquitoRenderer extends GeoEntityRenderer<Mosquito> {

    public MosquitoRenderer(EntityRendererProvider.Context context) {
        super(context, EntityRegistry.MOSQUITO.get());
    }

    @Override
    public void render(Mosquito entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0, 1.5, 0);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    @Override
    public @Nullable RenderType getRenderType(Mosquito animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
