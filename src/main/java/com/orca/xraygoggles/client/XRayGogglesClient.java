package com.orca.xraygoggles.client;

import com.orca.xraygoggles.XRayGogglesMod;
import com.orca.xraygoggles.XRayState;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class XRayGogglesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
        HudRenderCallback.EVENT.register(this::onHudRender);
        XRayGogglesMod.LOGGER.info("X-Ray Goggles client initialized!");
    }

    private void onClientTick(MinecraftClient client) {
        if (client.player == null) {
            XRayState.setXrayEnabled(false);
            return;
        }

        ItemStack helmet = client.player.getEquippedStack(EquipmentSlot.HEAD);
        boolean wearingGoggles = helmet.getItem() == XRayGogglesMod.XRAY_GOGGLES;

        if (!wearingGoggles) {
            if (XRayState.isXrayEnabled()) {
                XRayState.setXrayEnabled(false);
                reloadChunks(client);
            }
            return;
        }

        boolean isSneaking = client.player.isSneaking();
        boolean wasSneaking = XRayState.wasSneaking();

        if (isSneaking && !wasSneaking) {
            XRayState.toggle();
            reloadChunks(client);
        }

        XRayState.setWasSneaking(isSneaking);
    }

    private void reloadChunks(MinecraftClient client) {
        if (client.worldRenderer != null) {
            client.worldRenderer.reload();
        }
    }

    private void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        ItemStack helmet = client.player.getEquippedStack(EquipmentSlot.HEAD);
        boolean wearingGoggles = helmet.getItem() == XRayGogglesMod.XRAY_GOGGLES;

        if (wearingGoggles && XRayState.isXrayEnabled()) {
            renderXRayOverlay(context, client);
        }
    }

    private void renderXRayOverlay(DrawContext context, MinecraftClient client) {
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();
        int borderSize = 20;
        int color = 0x4000FF00;

        context.fill(0, 0, width, borderSize, color);
        context.fill(0, height - borderSize, width, height, color);
        context.fill(0, borderSize, borderSize, height - borderSize, color);
        context.fill(width - borderSize, borderSize, width, height - borderSize, color);

        int cornerSize = 40;
        int cornerColor = 0x6000FF00;
        context.fill(0, 0, cornerSize, cornerSize, cornerColor);
        context.fill(width - cornerSize, 0, width, cornerSize, cornerColor);
        context.fill(0, height - cornerSize, cornerSize, height, cornerColor);
        context.fill(width - cornerSize, height - cornerSize, width, height, cornerColor);
    }
}
