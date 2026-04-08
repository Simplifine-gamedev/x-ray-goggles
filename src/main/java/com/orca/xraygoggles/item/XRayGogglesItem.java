package com.orca.xraygoggles.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.item.ArmorMaterial;

public class XRayGogglesItem extends ArmorItem {

    public XRayGogglesItem(Settings settings) {
        super(ArmorMaterials.GOLD, Type.HELMET, settings);
    }
}
