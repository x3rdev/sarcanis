package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockItemRegistry {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(Registries.ITEM, Sarcanis.MODID);

    public static final DeferredHolder<Item, BlockItem> FLESH_BLOCK = BLOCK_ITEMS.register("flesh_block",
            () -> new BlockItem(BlockRegistry.FLESH_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MEMBRANE_BLOCK = BLOCK_ITEMS.register("membrane_block",
            () -> new BlockItem(BlockRegistry.MEMBRANE_BLOCK.get(), new Item.Properties()));
}
