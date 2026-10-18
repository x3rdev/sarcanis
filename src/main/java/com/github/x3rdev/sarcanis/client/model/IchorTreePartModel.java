package com.github.x3rdev.sarcanis.client.model;

import com.github.x3rdev.sarcanis.common.block.IchorTreePart;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

import java.util.function.Function;

public class IchorTreePartModel<T extends GeoAnimatable> extends GeoModel<T> {
    private final Function<T, IchorTreePart> part;

    public IchorTreePartModel(Function<T, IchorTreePart> part) {
        this.part = part;
    }

    private ResourceLocation id(T animatable) {
        return BuiltInRegistries.BLOCK.getKey(part.apply(animatable));
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return id(animatable).withPath(path -> "geo/block/" + path + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return part.apply(animatable).getTexture().withPath(path -> "textures/block/" + path + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return id(animatable).withPath(path -> "animations/block/" + path + ".animation.json");
    }
}
