package com.github.x3rdev.sarcanis.common.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class Networks {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToServer(
                DaggerTargetEntity.TYPE,
                DaggerTargetEntity.STREAM_CODEC,
                DaggerTargetEntity::handleServerBoundPacket
        );
    }
}
