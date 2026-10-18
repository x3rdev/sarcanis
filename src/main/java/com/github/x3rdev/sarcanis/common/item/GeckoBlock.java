package com.github.x3rdev.sarcanis.common.item;

import com.github.x3rdev.sarcanis.client.model.DefaultedBlockItemGeoModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class GeckoBlock extends BlockItem implements GeoItem {

    private BlockEntityWithoutLevelRenderer renderer;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final @Nullable ResourceLocation altTexture;

    public GeckoBlock(Block block, Properties properties) {
        this(block, properties, null);
    }

    public GeckoBlock(Block block, Properties properties, @Nullable ResourceLocation altTexture) {
        super(block, properties);
        this.altTexture = altTexture;
        GeckoLibUtil.getSyncedSingletonAnimatableId(this);
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            @Override
            public @NotNull BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (renderer == null) {
                    DefaultedBlockItemGeoModel<GeckoBlock> model = new DefaultedBlockItemGeoModel<>(BuiltInRegistries.ITEM.getKey(GeckoBlock.this));
                    if (altTexture != null) {
                        model.withAltTexture(altTexture);
                    }
                    renderer = new GeoItemRenderer<>(model);
                }
                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
