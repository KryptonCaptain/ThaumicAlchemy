package codasylph.thaumicalchemy.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import codasylph.thaumicalchemy.tileentities.TileAmalgamator;

public class BlockAmalgamatorItem extends ItemBlock {
	
	public BlockAmalgamatorItem(final Block par1) {
        super(par1);
        setMaxDamage(0);
		setHasSubtypes(true);
	}
  
	public int getMetadata(int par1)
	{
		return par1;
	}
	/*
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}*/
	
	public boolean placeBlockAt(final ItemStack stack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ, final int metadata) {
        final boolean ret = super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);

        if (ret) {
        	TileAmalgamator tile = (TileAmalgamator)world.getTileEntity(x, y, z);
            if ((tile != null) && ((tile instanceof TileAmalgamator)))
            {
              int var6 = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
              switch (var6)
              {
              case 0: 
                tile.orientation = ForgeDirection.getOrientation(2); break;
              case 1: 
                tile.orientation = ForgeDirection.getOrientation(5); break;
              case 2: 
                tile.orientation = ForgeDirection.getOrientation(3); break;
              case 3: 
                tile.orientation = ForgeDirection.getOrientation(4);
              }
              tile.markDirty();
              world.markBlockForUpdate(x, y, x);
            }
        }
        
        return ret;
    }

	

}
