package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.blockentity.BoneCauldronBlockEntity;
import com.github.x3rdev.sarcanis.common.blockentity.IchorTreePartBlockEntity;
import com.github.x3rdev.sarcanis.common.blockentity.PurifierBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Sarcanis.MOD_ID);

    public static final Supplier<BlockEntityType<PurifierBlockEntity>> PURIFIER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "purifier_block_entity",
            () -> BlockEntityType.Builder.of(PurifierBlockEntity::new, BlockRegistry.PURIFIER_BLOCK.get()).build(null)
    );

    public static final Supplier<BlockEntityType<BoneCauldronBlockEntity>> BONE_CAULDRON_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "bone_cauldron_block_entity",
            () -> BlockEntityType.Builder.of(BoneCauldronBlockEntity::new, BlockRegistry.BONE_CAULDRON.get()).build(null)
    );

    public static final Supplier<BlockEntityType<IchorTreePartBlockEntity>> ICHOR_TREE_PART = BLOCK_ENTITY_TYPES.register(
            "ichor_tree_part",
            () -> BlockEntityType.Builder.of(IchorTreePartBlockEntity::new,
                    BlockRegistry.ICHOR_TREE_TRUNK_BOTTOM.get(),
                    BlockRegistry.ICHOR_TREE_TRUNK_MIDDLE.get(),
                    BlockRegistry.ICHOR_TREE_TRUNK_TOP.get(),
                    BlockRegistry.ICHOR_TREE_RECEPTACLE.get(),
                    BlockRegistry.ICHOR_TREE_EMPTY_PRODUCER.get(),
                    BlockRegistry.ICHOR_TREE_FERTILE_BRANCH.get(),
                    BlockRegistry.ICHOR_TREE_OVERGROWN_BRANCH.get(),
                    BlockRegistry.ICHOR_TREE_OVERGROWN_FERTILE_BRANCH.get(),
                    BlockRegistry.ICHOR_TREE_BULB.get(),
                    BlockRegistry.ICHOR_TREE_FRUIT.get(),
                    BlockRegistry.ICHOR_TREE_VINE.get()
            ).build(null)
    );

    // static method for use in Block classes overriding getTicker()
    public static <E extends BlockEntity, F extends BlockEntity> BlockEntityTicker<F> createTicker(
            BlockEntityType<F> type, BlockEntityType<E> checkedType, BlockEntityTicker<? super E> ticker) {
        return checkedType == type ? (BlockEntityTicker<F>) ticker : null;
    }
}
