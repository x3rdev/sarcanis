package com.github.x3rdev.sarcanis;

import com.github.x3rdev.sarcanis.common.registry.ItemRegistry;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(Sarcanis.MODID)
public class Sarcanis {
    public static final String MODID = "sarcanis";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Sarcanis(IEventBus modEventBus, ModContainer modContainer) {
        ItemRegistry.ITEMS.register(modEventBus);
        ItemRegistry.ModItemTab.CREATIVE_MODE_TABS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
