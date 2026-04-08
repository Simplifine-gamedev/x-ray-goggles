package com.orca.xraygoggles;

import com.orca.xraygoggles.item.XRayGogglesItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XRayGogglesMod implements ModInitializer {
    public static final String MOD_ID = "xraygoggles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Item XRAY_GOGGLES;

    @Override
    public void onInitialize() {
        XRAY_GOGGLES = Registry.register(
            Registries.ITEM,
            Identifier.of(MOD_ID, "xray_goggles"),
            new XRayGogglesItem(new Item.Settings().maxCount(1))
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(XRAY_GOGGLES);
        });

        LOGGER.info("X-Ray Goggles mod initialized!");
    }
}
