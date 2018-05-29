package codasylph.thaumicalchemy.blocks;

import java.util.List;

import thaumcraft.client.renderers.block.BlockRenderer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import codasylph.thaumicalchemy.ThaumicAlchemy;
import codasylph.thaumicalchemy.tileentities.TileAmalgamator;

public class BlockEssentiaAmalgamator extends BlockContainer
{
    private final String unlocalizedname = "essentiaAmalgamator";
    public static int renderId;
    
    protected BlockEssentiaAmalgamator() {
        super(Material.iron);
        this.setBlockName(this.unlocalizedname);
        this.setCreativeTab((CreativeTabs)ThaumicAlchemy.tabTA);
        this.setBlockTextureName("glass");
    }
    
    public TileEntity createNewTileEntity(final World world, final int meta) {
        return new TileAmalgamator();
    }
    
    public int getRenderType() {
        return BlockEssentiaAmalgamator.renderId;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    //TODO boxes
    static float inc = 1.0F / 16;
    
    public void setBlockBoundsBasedOnState(final IBlockAccess world, final int i, final int j, final int k) {
        //final int metadata = world.getBlockMetadata(i, j, k);
        TileEntity te = world.getTileEntity(i, j, k);
		if ( (te != null)  )
        {
			TileAmalgamator tile = (TileAmalgamator)te;
			if (tile.orientation.ordinal() == 2 || tile.orientation.ordinal() == 3) {
				this.setBlockBounds(0.0f, 0.0f, BlockRenderer.W5, 1.0f, 1.0f, BlockRenderer.W11);
			}
			if (tile.orientation.ordinal() == 4 || tile.orientation.ordinal() == 5) {
				this.setBlockBounds(BlockRenderer.W5, 0.0f, 0.0f, BlockRenderer.W11, 1.0f, 1.0f);
			}
        }
        super.setBlockBoundsBasedOnState(world, i, j, k);
    }
    
    public void addCollisionBoxesToList(final World world, final int i, final int j, final int k, final AxisAlignedBB axisalignedbb, final List arraylist, final Entity par7Entity) {
        //final int metadata = world.getBlockMetadata(i, j, k);
    	TileEntity te = world.getTileEntity(i, j, k);
		if ( (te != null)  )
        {
			TileAmalgamator tile = (TileAmalgamator)te;
			if (tile.orientation.ordinal() == 2 || tile.orientation.ordinal() == 3) {
				this.setBlockBounds(0.0f, 0.0f, BlockRenderer.W5, 1.0f, 1.0f, BlockRenderer.W11);
			}
			if (tile.orientation.ordinal() == 4 || tile.orientation.ordinal() == 5) {
				this.setBlockBounds(BlockRenderer.W5, 0.0f, 0.0f, BlockRenderer.W11, 1.0f, 1.0f);
			}
        }
        super.addCollisionBoxesToList(world, i, j, k, axisalignedbb, arraylist, par7Entity);
    }
    
    /*//this was to check it was all working correctly
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
		 //this was to check how dir.offset behaved
		TileEntity te = world.getTileEntity(x, y, z);
		if ( (te != null)  )
        {
			TileAmalgamator tile = (TileAmalgamator)te;
	        world.playSoundEffect(x, y, z, "thaumcraft:alembicknock", 0.2F, 1.0F);
	        
	        System.out.println("aux orientation " + tile.orientation );
	        System.out.println("aux orientation ordinal " + tile.orientation.ordinal() );
	        
	        if (tile.storage[0].getAspect() != null)
	        	System.out.println("0 amount " + tile.storage[0].getAmount() + " " + tile.storage[0].getAspect().getName() );
	        if (tile.storage[1].getAspect() != null)
	        	System.out.println("1 amount " + tile.storage[1].getAmount() + " " + tile.storage[1].getAspect().getName() );
	        if (tile.storage[2].getAspect() != null)
	        	System.out.println("2 amount " + tile.storage[2].getAmount() + " " + tile.storage[2].getAspect().getName() );

        }
        
		return super.onBlockActivated(world, x, y, z, player, side, par7, par8, par9);
	}
    */
}
