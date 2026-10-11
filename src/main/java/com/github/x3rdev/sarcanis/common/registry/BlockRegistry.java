package com.github.x3rdev.sarcanis.common.registry;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.block.BoneCauldron;
import com.github.x3rdev.sarcanis.common.block.Purifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Sarcanis.MOD_ID);

    public static final DeferredHolder<Block, Block> FLESH_BLOCK = BLOCKS.register("flesh_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.8F).sound(SoundType.NYLIUM)));

    public static final DeferredHolder<Block, HalfTransparentBlock> MEMBRANE_BLOCK = BLOCKS.register("membrane_block",
            () -> new HalfTransparentBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.3F).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion().isValidSpawn((state, level, pos, entityType) -> false).isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false)));

    // everything below needs block properties defined
    public static final DeferredHolder<Block, Purifier> PURIFIER_BLOCK = BLOCKS.register("purifier_block",
            () -> new Purifier(BlockBehaviour.Properties.of()));

    public static final DeferredHolder<Block, BoneCauldron> BONE_CAULDRON = BLOCKS.register("bone_cauldron",
            () -> new BoneCauldron(BlockBehaviour.Properties.of()));
}
