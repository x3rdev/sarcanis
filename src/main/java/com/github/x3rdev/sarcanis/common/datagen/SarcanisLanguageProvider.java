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

        // Entity
        addEntityType(EntityRegistry.MOSQUITO, "Mosquito");

        add("itemGroup." + Sarcanis.MOD_ID, "Sarcanis");
    }
}
