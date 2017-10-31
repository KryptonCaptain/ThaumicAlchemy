package me.codasylph.thaumicalchemy.blocks;

import me.codasylph.thaumicalchemy.tileentities.TileAmalgamator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import me.codasylph.thaumicalchemy.ThaumicAlchemy;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockContainer;

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
