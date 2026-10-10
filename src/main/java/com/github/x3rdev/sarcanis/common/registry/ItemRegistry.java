package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Sarcanis.MODID);

    public static final DeferredHolder<Item, Item> BONE_NEEDLE = ITEMS.register("bone_needle",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> BONE_SHARD = ITEMS.register("bone_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> INFECTED_FLESH = ITEMS.register("infected_flesh",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> TWISTED_BONE = ITEMS.register("twisted_bone",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SINEW_STRAND = ITEMS.register("sinew_strand",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> MUCOUS_MEMBRANE = ITEMS.register("mucous_membrane",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SHARP_BONE = ITEMS.register("sharp_bone",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> GLIAL_MASS = ITEMS.register("glial_mass",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SYMBIOTIC_TUMOR = ITEMS.register("symbiotic_tumor",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> TWITCHING_LEG = ITEMS.register("twitching_leg",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> AMORPHOUS_FLESH = ITEMS.register("amorphous_flesh",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build())));
    public static final DeferredHolder<Item, Item> COOKED_AMORPHOUS_FLESH = ITEMS.register("cooked_amorphous_flesh",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build())));

    public static class ModItemTab {

        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Sarcanis.MODID);

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SARCANIS_ITEM_TAB = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
                .icon(ItemRegistry.INFECTED_FLESH.get()::getDefaultInstance)
                .title(Component.translatable("itemGroup." + Sarcanis.MODID))
                .displayItems((displayParameters, output) -> {
                    ItemRegistry.ITEMS.getEntries().forEach(itemRegistryObject -> output.accept(itemRegistryObject.get()));
                    BlockItemRegistry.BLOCK_ITEMS.getEntries().forEach(itemRegistryObject -> output.accept(itemRegistryObject.get()));
                })
                .build());
    }
}
