package codasylph.thaumicalchemy.blocks;

import codasylph.thaumicalchemy.tileentities.TileAmalgamator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class TABlocks
{
    public static Block essentiaAmalgamator;
    
    
    static {
        essentiaAmalgamator = (Block)new BlockEssentiaAmalgamator();
    }
    
    public static void registerBlocks() {
        GameRegistry.registerBlock(essentiaAmalgamator, BlockAmalgamatorItem.class, "essentiaAmalgamator");
    }
    
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity((Class)TileAmalgamator.class, "tileAmalgamator");
    }
    
}
