package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.block.IchorTreePart;
import com.github.x3rdev.sarcanis.common.item.GeckoBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockItemRegistry {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(Registries.ITEM, Sarcanis.MOD_ID);

    public static final DeferredHolder<Item, BlockItem> FLESH_BLOCK = BLOCK_ITEMS.register("flesh_block",
            () -> new BlockItem(BlockRegistry.FLESH_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MEMBRANE_BLOCK = BLOCK_ITEMS.register("membrane_block",
            () -> new BlockItem(BlockRegistry.MEMBRANE_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_TRUNK_BOTTOM = ichorTreePart(BlockRegistry.ICHOR_TREE_TRUNK_BOTTOM);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_TRUNK_MIDDLE = ichorTreePart(BlockRegistry.ICHOR_TREE_TRUNK_MIDDLE);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_TRUNK_TOP = ichorTreePart(BlockRegistry.ICHOR_TREE_TRUNK_TOP);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_RECEPTACLE = ichorTreePart(BlockRegistry.ICHOR_TREE_RECEPTACLE);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_EMPTY_PRODUCER = ichorTreePart(BlockRegistry.ICHOR_TREE_EMPTY_PRODUCER);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_FERTILE_BRANCH = ichorTreePart(BlockRegistry.ICHOR_TREE_FERTILE_BRANCH);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_OVERGROWN_BRANCH = ichorTreePart(BlockRegistry.ICHOR_TREE_OVERGROWN_BRANCH);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_OVERGROWN_FERTILE_BRANCH = ichorTreePart(BlockRegistry.ICHOR_TREE_OVERGROWN_FERTILE_BRANCH);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_BULB = ichorTreePart(BlockRegistry.ICHOR_TREE_BULB);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_FRUIT = ichorTreePart(BlockRegistry.ICHOR_TREE_FRUIT);
    public static final DeferredHolder<Item, GeckoBlock> ICHOR_TREE_VINE = ichorTreePart(BlockRegistry.ICHOR_TREE_VINE);

    private static DeferredHolder<Item, GeckoBlock> ichorTreePart(DeferredHolder<Block, ? extends IchorTreePart> block) {
        return BLOCK_ITEMS.register(block.getId().getPath(), () -> new GeckoBlock(block.get(), new Item.Properties(), block.get().getTexture()));
    }
}
