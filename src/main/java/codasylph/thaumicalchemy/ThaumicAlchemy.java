package codasylph.thaumicalchemy;

import net.minecraft.creativetab.CreativeTabs;
import codasylph.thaumicalchemy.blocks.TABlocks;
import codasylph.thaumicalchemy.proxy.IProxy;
import codasylph.thaumicalchemy.tileentities.TATiles;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = "thaumicalchemy", 
		name = "Thaumic Alchemy", 
		version = "${version}", 
		dependencies = "required-after:Thaumcraft@[4.2.3.5,)"
	)

public class ThaumicAlchemy
{
    @Mod.Instance
    public static ThaumicAlchemy instance;
    @SidedProxy(clientSide = "codasylph.thaumicalchemy.proxy.ClientProxy", serverSide = "codasylph.thaumicalchemy.proxy.ServerProxy")
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
