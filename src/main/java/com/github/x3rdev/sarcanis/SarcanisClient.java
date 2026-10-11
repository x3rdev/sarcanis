package com.github.x3rdev.sarcanis;

import com.github.x3rdev.sarcanis.client.ClientEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = Sarcanis.MOD_ID, dist = Dist.CLIENT)
public class SarcanisClient {



    public SarcanisClient(ModContainer modContainer) {
        Sarcanis.LOGGER.info("Initializing sarcanis (client)");
        IEventBus modEventBus = modContainer.getEventBus();
        IEventBus neoEventBus = NeoForge.EVENT_BUS;

        modEventBus.addListener(ClientEvents::registerRenderers);
    }
}
