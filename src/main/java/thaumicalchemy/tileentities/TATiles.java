package me.codasylph.thaumicalchemy.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;

public class TATiles
{
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity((Class)TileAmalgamator.class, "tileAmalgamator");
    }
}
