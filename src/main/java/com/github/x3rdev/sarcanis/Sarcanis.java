package com.github.x3rdev.sarcanis;

import com.github.x3rdev.sarcanis.common.CommonEvents;
import com.github.x3rdev.sarcanis.common.registry.BlockItemRegistry;
import com.github.x3rdev.sarcanis.common.registry.BlockRegistry;
import com.github.x3rdev.sarcanis.common.registry.EntityRegistry;
import com.github.x3rdev.sarcanis.common.registry.ItemRegistry;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(Sarcanis.MOD_ID)
public class Sarcanis {
    public static final String MOD_ID = "sarcanis";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Sarcanis(ModContainer modContainer) {
        Sarcanis.LOGGER.info("Initializing sarcanis");
        IEventBus modEventBus = modContainer.getEventBus();
        IEventBus neoEventBus = NeoForge.EVENT_BUS;

        BlockItemRegistry.BLOCK_ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        EntityRegistry.ENTITY_TYPES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        ItemRegistry.ModItemTab.CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(CommonEvents::createEntityAttributes);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
