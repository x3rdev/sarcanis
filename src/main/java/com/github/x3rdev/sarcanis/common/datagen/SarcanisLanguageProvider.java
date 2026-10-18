package com.github.x3rdev.sarcanis.common.datagen;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.registry.BlockRegistry;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import com.github.x3rdev.sarcanis.common.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class SarcanisLanguageProvider extends LanguageProvider {

    public SarcanisLanguageProvider(PackOutput output) {
        super(output, Sarcanis.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Block
        addBlock(BlockRegistry.FLESH_BLOCK, "Flesh Block");
        addBlock(BlockRegistry.MEMBRANE_BLOCK, "Membrane Block");
        addBlock(BlockRegistry.ICHOR_TREE_TRUNK_BOTTOM, "Ichor Tree Trunk Bottom");
        addBlock(BlockRegistry.ICHOR_TREE_TRUNK_MIDDLE, "Ichor Tree Trunk Middle");
        addBlock(BlockRegistry.ICHOR_TREE_TRUNK_TOP, "Ichor Tree Trunk Top");
        addBlock(BlockRegistry.ICHOR_TREE_RECEPTACLE, "Ichor Tree Receptacle");
        addBlock(BlockRegistry.ICHOR_TREE_EMPTY_PRODUCER, "Ichor Tree Empty Producer");
        addBlock(BlockRegistry.ICHOR_TREE_FERTILE_BRANCH, "Ichor Tree Fertile Branch");
        addBlock(BlockRegistry.ICHOR_TREE_OVERGROWN_BRANCH, "Ichor Tree Overgrown Branch");
        addBlock(BlockRegistry.ICHOR_TREE_OVERGROWN_FERTILE_BRANCH, "Ichor Tree Overgrown Fertile Branch");
        addBlock(BlockRegistry.ICHOR_TREE_BULB, "Ichor Tree Bulb");
        addBlock(BlockRegistry.ICHOR_TREE_FRUIT, "Ichor Tree Fruit");
        addBlock(BlockRegistry.ICHOR_TREE_VINE, "Ichor Tree Vine");

        // Item
        addItem(ItemRegistry.BONE_SYRINGE_EMPTY, "Bone Syringe");
        addItem(ItemRegistry.BONE_SYRINGE_BLOOD, "Bone Syringe of Blood");
        addItem(ItemRegistry.BONE_SYRINGE_ICHOR, "Bone Syringe of Ichor");
        addItem(ItemRegistry.BONE_NEEDLE, "Bone Needle");
        addItem(ItemRegistry.BONE_SHARD, "Bone Shard");
        addItem(ItemRegistry.INFECTED_FLESH, "Infected Flesh");
        addItem(ItemRegistry.TWISTED_BONE, "Twisted Bone");
        addItem(ItemRegistry.SINEW_STRAND, "Sinew Strand");
        addItem(ItemRegistry.MUCOUS_MEMBRANE, "Mucous Membrane");
        addItem(ItemRegistry.SHARP_BONE, "Sharp Bone");
        addItem(ItemRegistry.GLIAL_MASS, "Glial Mass");
        addItem(ItemRegistry.SYMBIOTIC_TUMOR, "Symbiotic Tumor");
        addItem(ItemRegistry.TWITCHING_LEG, "Twitching Leg");
        addItem(ItemRegistry.AMORPHOUS_FLESH, "Amorphous Flesh");
        addItem(ItemRegistry.COOKED_AMORPHOUS_FLESH, "Cooked Amorphous Flesh");
        addItem(ItemRegistry.MOSQUITO_SPAWN_EGG, "Mosquito Spawn Egg");
        addItem(ItemRegistry.BIOPHAGE_SPAWN_EGG, "Biophage Spawn Egg");
        addItem(ItemRegistry.TEST_DAGGER, "Test Dagger");

        // Entity
        addEntityType(EntityRegistry.MOSQUITO, "Mosquito");
        addEntityType(EntityRegistry.BIOPHAGE, "Biophage");

        add("biome." + Sarcanis.MOD_ID + ".fleshlands", "Fleshlands");

        add("itemGroup." + Sarcanis.MOD_ID, "Sarcanis");
    }
}
