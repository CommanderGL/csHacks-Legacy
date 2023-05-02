package net.crossscar.cshacks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.crossscar.cshacks.gui.CsScreen;
import net.crossscar.cshacks.hacks.FlyHack;

public class Main implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("cshacks");
    
    @Override
    public void onInitializeClient() {
        Main.LOGGER.info("csHacks Client Initialized!");

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            FlyHack.onUpdate(player, CsScreen.fly);
        });
    }
}
