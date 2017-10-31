package me.codasylph.thaumicalchemy;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import me.codasylph.thaumicalchemy.tileentities.TATiles;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import me.codasylph.thaumicalchemy.blocks.TABlocks;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.SidedProxy;
import me.codasylph.thaumicalchemy.proxy.IProxy;
import cpw.mods.fml.common.Mod;

@Mod(modid = "thaumicalchemy", name = "Thaumic Alchemy", version = "1.7.10-1.0", dependencies = "after:Thaumcraft")
public class ThaumicAlchemy
{
    @Mod.Instance
    public static ThaumicAlchemy instance;
    @SidedProxy(clientSide = "me.codasylph.thaumicalchemy.proxy.ClientProxy", serverSide = "me.codasylph.thaumicalchemy.proxy.ServerProxy")
    public static IProxy proxy;
    public static CreativeTabTA tabTA;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        TABlocks.registerBlocks();
    }
    
    @Mod.EventHandler
    public void Init(final FMLInitializationEvent event) {
        TATiles.registerTileEntities();
        ThaumicAlchemy.proxy.registerRenderers();
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        TAResearch.init();
    }
    
    static {
        ThaumicAlchemy.tabTA = new CreativeTabTA(CreativeTabs.getNextID(), "ThaumicAlchemyTab");
    }
}
