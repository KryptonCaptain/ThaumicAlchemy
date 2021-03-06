package codasylph.thaumicalchemy.tileentities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.TileThaumcraft;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IAspectContainer;
import thaumcraft.api.aspects.IEssentiaTransport;
import thaumcraft.common.config.ConfigBlocks;
import codasylph.thaumicalchemy.AspectHelper;
import codasylph.thaumicalchemy.EssentiaTank;

public class TileAmalgamator extends TileThaumcraft implements IEssentiaTransport
{
    public static final String tileEntityName = "tileAmalgamator";
    public EssentiaTank[] storage;
    public int ticks;
    
    public ForgeDirection orientation;
    
    public TileAmalgamator() {
        (this.storage = new EssentiaTank[3])[0] = new EssentiaTank(null, 0, 4);
        this.storage[1] = new EssentiaTank(null, 0, 4);
        this.storage[2] = new EssentiaTank(null, 0, 8);
        this.ticks = 0;
        this.orientation = ForgeDirection.getOrientation(2);
    }
    
    public void updateEntity() {
        for (final ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            if (this.canInputFrom(dir) && this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY, this.zCoord + dir.offsetZ) instanceof IEssentiaTransport) {
                final IEssentiaTransport tube = (IEssentiaTransport)this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY, this.zCoord + dir.offsetZ);
                this.addEssentia(tube.getEssentiaType(dir), tube.takeEssentia(tube.getEssentiaType(dir), 1, dir), dir);
            }
        }
        if (this.storage != null) {
            if (AspectHelper.getCompound(this.storage[0].getAspect(), this.storage[1].getAspect()) != null) {
                final Aspect compound = AspectHelper.getCompound(this.storage[0].getAspect(), this.storage[1].getAspect());
                if (this.storage[0].getAmount() == 4 && this.storage[1].getAmount() == 4 && 
                		(this.storage[2].getAspect() == null || this.storage[2].getAspect() == compound) && 
                		this.storage[2].getAmount() <=6 &&
                		this.ticks >= 36 ) {
                	
                    this.takeEssentia(this.storage[0].getAspect(), 4, 0);
                    this.takeEssentia(this.storage[1].getAspect(), 4, 1);
                    this.addEssentia(compound, 2, 2);//TODO revise rand
                    this.ticks = 0;
                }
                ++this.ticks;
            }
            else if (this.storage[0].getAspect() != null && this.storage[1].getAspect() != null 
            		&& this.storage[0].getAspect() != this.storage[1].getAspect() ) {
            	
                this.takeEssentia(this.storage[0].getAspect(), 1, 0);
                this.takeEssentia(this.storage[1].getAspect(), 1, 1);
                this.spill();
            }
            else if ( (this.storage[0].getAspect() != null && this.storage[1].getAspect() != null) &&
            		(this.storage[0].getAspect() == this.storage[1].getAspect()) &&
            		(this.storage[2].getAspect() == null || this.storage[2].getAspect()==this.storage[0].getAspect()) &&
            		(this.storage[2].getAmount() <= 6) ) {
            	
                final Aspect type = this.storage[0].getAspect();
                this.takeEssentia(type, 1, 0);
                this.takeEssentia(type, 1, 1);
                this.addEssentia(type, 2, 2);
            }
          //fucking why was there no output/overflow checks
        }
    }
    
    private void spill() {
        if (this.worldObj.isAirBlock(this.xCoord, this.yCoord + 1, this.zCoord)) {
            if (this.worldObj.rand.nextBoolean()) {
                this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, ConfigBlocks.blockFluxGas, 0, 3);
            }
            else {
                this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, ConfigBlocks.blockFluxGoo, 0, 3);
            }
        }
        else {
            final Block bi = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
            final int md = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord + 1, this.zCoord);
            if (bi == ConfigBlocks.blockFluxGoo && md < 7) {
                this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, ConfigBlocks.blockFluxGoo, md + 1, 3);
            }
            else if (bi == ConfigBlocks.blockFluxGas && md < 7) {
                this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, ConfigBlocks.blockFluxGas, md + 1, 3);
            }
            else {
                final int x = -1 + this.worldObj.rand.nextInt(3);
                final int y = -1 + this.worldObj.rand.nextInt(3);
                final int z = -1 + this.worldObj.rand.nextInt(3);
                if (this.worldObj.isAirBlock(this.xCoord + x, this.yCoord + y, this.zCoord + z)) {
                    if (this.worldObj.rand.nextBoolean()) {
                        this.worldObj.setBlock(this.xCoord + x, this.yCoord + y, this.zCoord + z, ConfigBlocks.blockFluxGas, 0, 3);
                    }
                    else {
                        this.worldObj.setBlock(this.xCoord + x, this.yCoord + y, this.zCoord + z, ConfigBlocks.blockFluxGoo, 0, 3);
                    }
                }
            }
        }
    }
    
    public static ForgeDirection getAdjacentSide(ForgeDirection dir) {
    	if (dir == ForgeDirection.NORTH) {
    		return ForgeDirection.EAST ;
    	}
    	else if (dir == ForgeDirection.EAST) {
    		return ForgeDirection.SOUTH ;
    	}
    	else if (dir == ForgeDirection.SOUTH) {
    		return ForgeDirection.WEST ;
    	}
    	else  {
    		return ForgeDirection.NORTH ;
    	}
    }
    
    public boolean isConnectable(final ForgeDirection face) {
        return face == ForgeDirection.DOWN  || face == getAdjacentSide(orientation) || face == getAdjacentSide(orientation.getOpposite()) ;
    }
    
    public boolean canInputFrom(final ForgeDirection face) {
        /*if (face != null) {
            final int i = face.ordinal() - 4;
            if (i >= 0) {
                return this.storage[i].getAmount() < this.storage[i].getCapacity() ;
            }
        }*/
    	if (face == getAdjacentSide(orientation))
    		return this.storage[0].getAmount() < this.storage[0].getCapacity() ;
    	if (face == getAdjacentSide(orientation).getOpposite())
    		return this.storage[1].getAmount() < this.storage[1].getCapacity() ;
        return false;
    }
    
    public boolean canOutputTo(final ForgeDirection face) {
        return face == ForgeDirection.DOWN && this.storage[2].getAmount() > 0;
    }
    
    public void setSuction(final Aspect aspect, final int amount) {
    }
    
    public Aspect getSuctionType(final ForgeDirection face) {
        return null;
    }
    
    public int getSuctionAmount(final ForgeDirection face) {
        if (this.canInputFrom(face)) {
            return 128;
        }
        return 0;
    }
    
    public int takeEssentia(final Aspect aspect, final int amount, final ForgeDirection face) {
        if (this.canOutputTo(face)) {
            if (!this.worldObj.isRemote) {
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            }
            return this.storage[2].remove(aspect, amount);
        }
        return 0;
    }
    
    public int takeEssentia(final Aspect aspect, final int amount, final int tank) {
        if (!this.worldObj.isRemote) {
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
        return this.storage[tank].remove(aspect, amount);
    }
    
    public int addEssentia(final Aspect aspect, final int amount, final ForgeDirection face) {
        if (this.canInputFrom(face)) {
            if (!this.worldObj.isRemote) {
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            }
            /*
            final int i = face.ordinal() - 4;
            return this.storage[i].add(aspect, amount);
            */
            //
            if (face == getAdjacentSide(orientation))
        		return this.storage[0].add(aspect, amount) ;
            if (face == getAdjacentSide(orientation).getOpposite())
        		return this.storage[1].add(aspect, amount) ;
            
        }
        return 0;
    }
    
    public int addEssentia(final Aspect aspect, final int amount, final int tank) {
        if (!this.worldObj.isRemote) {
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
        return this.storage[tank].add(aspect, amount);
    }
    
  //TODO getEssentiaType
    public Aspect getEssentiaType(final ForgeDirection face) { 
        /*
    	//System.out.println("Contains: ");
        final int i = (face != null) ? (face.ordinal() - 4) : 2;
        if (i >= 0) {
            //System.out.println(this.storage[i].getAspect().getName() + " " + this.storage[i].getAmount() + " in " + i);
            return this.storage[i].getAspect();
        }
        for (int j = 0; j < 3; ++j) {
            final String aspect = (this.storage[j].getAspect() != null) ? this.storage[j].getAspect().getName() : "null";
            //System.out.println(aspect + " " + this.storage[j].getAmount() + " in " + j + ", ");
            //what does this even do?? -K
        }*/
    	if (face == getAdjacentSide(orientation))
    		return this.storage[0].getAspect() ;
    	if (face == getAdjacentSide(orientation).getOpposite())
    		return this.storage[1].getAspect() ;
    	if (face == ForgeDirection.DOWN)
    		return this.storage[2].getAspect() ;
    	
        return this.storage[2].getAspect();
    }
    
  //TODO getEssentiaAmount
    public int getEssentiaAmount(final ForgeDirection face) { 
        /*
    	final int i = (face != null) ? (face.ordinal() - 4) : 2;
        if (i >= 0) {
            return this.storage[i].getAmount();
        }*/
        
        if (face == getAdjacentSide(orientation))
    		return this.storage[0].getAmount() ;
    	if (face == getAdjacentSide(orientation).getOpposite())
    		return this.storage[1].getAmount() ;
    	if (face == ForgeDirection.DOWN)
    		return this.storage[2].getAmount() ;
    		
        return this.storage[2].getAmount();
    }
    
    public int getMinimumSuction() {
        return 0;
    }
    
    public boolean renderExtendedTube() {
        return false;
    }
    
    public void writeCustomNBT(final NBTTagCompound nbt) {

        nbt.setInteger("ticks", this.ticks);
        nbt.setString("Tank0a", (this.storage[0].getAspect() != null) ? this.storage[0].getAspect().getTag() : "null");
        nbt.setInteger("Tank0i", this.storage[0].getAmount());
        nbt.setString("Tank1a", (this.storage[1].getAspect() != null) ? this.storage[1].getAspect().getTag() : "null");
        nbt.setInteger("Tank1i", this.storage[1].getAmount());
        nbt.setString("Tank2a", (this.storage[2].getAspect() != null) ? this.storage[2].getAspect().getTag() : "null");
        nbt.setInteger("Tank2i", this.storage[2].getAmount());
        
        nbt.setInteger("orientation", this.orientation.ordinal());
    }
    
    public void readCustomNBT(final NBTTagCompound nbt) {

        this.ticks = nbt.getInteger("ticks");
        this.storage[0].setContent((nbt.getString("Tank0a") != "null") ? Aspect.getAspect(nbt.getString("Tank0a")) : null, nbt.getInteger("Tank0i"));
        this.storage[1].setContent((nbt.getString("Tank1a") != "null") ? Aspect.getAspect(nbt.getString("Tank1a")) : null, nbt.getInteger("Tank1i"));
        this.storage[2].setContent((nbt.getString("Tank2a") != "null") ? Aspect.getAspect(nbt.getString("Tank2a")) : null, nbt.getInteger("Tank2i"));
        
        this.orientation = ForgeDirection.getOrientation(nbt.getInteger("orientation"));
    }
    
}
