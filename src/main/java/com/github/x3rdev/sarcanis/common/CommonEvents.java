package com.github.x3rdev.sarcanis.common;

import com.github.x3rdev.sarcanis.common.entity.Biophage;
import com.github.x3rdev.sarcanis.common.entity.Mosquito;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class CommonEvents {

    @SubscribeEvent
    public static void createEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.MOSQUITO.get(), Mosquito.createAttributes());
        event.put(EntityRegistry.BIOPHAGE.get(), Biophage.createAttributes());
    }
}
