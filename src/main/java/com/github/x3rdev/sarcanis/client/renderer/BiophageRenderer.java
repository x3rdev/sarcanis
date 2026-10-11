package com.github.x3rdev.sarcanis.client.renderer;

import com.github.x3rdev.sarcanis.common.entity.Biophage;
import com.github.x3rdev.sarcanis.common.entity.Mosquito;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BiophageRenderer extends GeoEntityRenderer<Biophage> {

    public BiophageRenderer(EntityRendererProvider.Context context) {
        super(context, EntityRegistry.BIOPHAGE.get());
    }

    @Override
    public @Nullable RenderType getRenderType(Biophage animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
