package com.github.x3rdev.sarcanis.client;

import com.github.x3rdev.sarcanis.client.renderer.MosquitoRenderer;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.MOSQUITO.get(),
                context -> new MosquitoRenderer(context));
    }
}
