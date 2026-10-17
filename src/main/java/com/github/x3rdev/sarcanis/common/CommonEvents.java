package com.github.x3rdev.sarcanis.common;

import com.github.x3rdev.sarcanis.Sarcanis;
import com.github.x3rdev.sarcanis.common.entity.Biophage;
import com.github.x3rdev.sarcanis.common.entity.Mosquito;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import com.github.x3rdev.sarcanis.common.worldgen.SarcanisRegion;
import com.github.x3rdev.sarcanis.common.worldgen.SarcanisSurfaceRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class CommonEvents {

    @SubscribeEvent
    public static void createEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.MOSQUITO.get(), Mosquito.createAttributes());
        event.put(EntityRegistry.BIOPHAGE.get(), Biophage.createAttributes());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new SarcanisRegion(2));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Sarcanis.MOD_ID, SarcanisSurfaceRules.makeRules());
        });
    }
}
