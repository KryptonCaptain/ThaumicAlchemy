package codasylph.thaumicalchemy.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import codasylph.thaumicalchemy.ThaumicAlchemy;
import codasylph.thaumicalchemy.tileentities.TileAmalgamator;

public class EssentiaAmalgamator extends BlockContainer
{
    private final String unlocalizedname = "essentiaAmalgamator";
    public static int renderId;
    
    protected EssentiaAmalgamator() {
        super(Material.clay);
        this.setBlockName(this.unlocalizedname);
        this.setCreativeTab((CreativeTabs)ThaumicAlchemy.tabTA);
        this.setBlockTextureName("glass");
    }
    
    public TileEntity createNewTileEntity(final World world, final int meta) {
        return new TileAmalgamator();
    }
    
    public int getRenderType() {
        return EssentiaAmalgamator.renderId;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
}
