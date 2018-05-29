package codasylph.thaumicalchemy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class TABlocks
{
    public static Block essentiaAmalgamator;
    
    public static void registerBlocks() {
        GameRegistry.registerBlock(essentiaAmalgamator, BlockAmalgamatorItem.class, "essentiaAmalgamator");
    }
    
    static {
        essentiaAmalgamator = (Block)new BlockEssentiaAmalgamator();
    }
}
