package com.github.x3rdev.sarcanis.common.datagen;

import com.github.x3rdev.sarcanis.common.registry.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SarcanisLootTableProvider extends LootTableProvider {

    public SarcanisLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(SarcanisBlockSubProvider::new, LootContextParamSets.BLOCK)
        ), registries);
    }

    private static class SarcanisBlockSubProvider extends BlockLootSubProvider {

        protected SarcanisBlockSubProvider(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockRegistry.BLOCKS.getEntries().stream()
                    .map(blockDeferredHolder -> ((Block) blockDeferredHolder.get())).toList();
        }

        @Override
        protected void generate() {
            dropSelf(BlockRegistry.FLESH_BLOCK.get());
            dropSelf(BlockRegistry.MEMBRANE_BLOCK.get());
            dropSelf(BlockRegistry.PURIFIER_BLOCK.get());
            dropSelf(BlockRegistry.BONE_CAULDRON.get());
        }
    }
}
