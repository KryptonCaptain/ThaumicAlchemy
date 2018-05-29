package codasylph.thaumicalchemy.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import thaumcraft.api.aspects.Aspect;
import codasylph.thaumicalchemy.AspectHelper;
import codasylph.thaumicalchemy.blocks.BlockEssentiaAmalgamator;
import codasylph.thaumicalchemy.tileentities.TileAmalgamator;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererAmalgamator extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
    private final ModelAmalgamator base;
    private final ModelJar midJar;
    private final ModelEssentia essentiaL;
    
    public RendererAmalgamator() {
        this.base = new ModelAmalgamator();
        this.midJar = new ModelJar();
        this.essentiaL = new ModelEssentia();
    }
    
    public void renderTileEntityAt(final TileEntity tile, final double x, final double y, final double z, final float scale) {
        this.render((TileAmalgamator)tile, x, y, z, scale);
    }
    /*//what does this do??
    private void adjustRotatePivotViaMeta(final World world, final int x, final int y, final int z) {
        final int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef((float)(meta * -90), 0.0f, 0.0f, 1.0f);
        GL11.glPopMatrix();
    }*/
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelId, final RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.5f, 1.5f, 0.5f);
        final ResourceLocation textures = new ResourceLocation("thaumicalchemy:textures/blocks/amalgamatorflat.png");
        this.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.base.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        this.midJar.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        return true;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return BlockEssentiaAmalgamator.renderId;
    }
    
    public void render(final TileAmalgamator tile, final double x, final double y, final double z, final float scale) {
        
    	GL11.glPushMatrix();
    	
    	int i = tile.storage[0].getAmount();
        if (i > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
            final ResourceLocation textures = new ResourceLocation("thaumicalchemy:textures/blocks/animatedglow.png");
            this.bindTexture(textures);
            GL11.glPushMatrix();
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            final Aspect a = tile.storage[0].getAspect();
            GL11.glColor3f(AspectHelper.getRed(a), AspectHelper.getGreen(a), AspectHelper.getBlue(a));
            GL11.glTranslatef(0.0f, 1.25f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            if (tile.getWorldObj() != null) {
                switch (tile.orientation.ordinal()) {
                    case 5: {
                    	GL11.glTranslatef(0.0f, 0.0f, -0.3125f); //test
                        break;
                    }
                    case 4: {
                    	GL11.glTranslatef(0.0f, 0.0f, 0.3125f);
                    	break;
                    }
                    case 3: {
                    	GL11.glTranslatef(0.3125f, 0.0f, 0.0f);
                        break;
                    }
                    case 2: {
                    	GL11.glTranslatef(-0.3125f, 0.0f, 0.0f);
                        break;
                    }
                }   
            }
            this.essentiaL.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, i);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
        i = tile.storage[1].getAmount();
        if (i > 0) {
            final Aspect a2 = tile.storage[1].getAspect();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
            final ResourceLocation textures2 = new ResourceLocation("thaumicalchemy:textures/blocks/animatedglow.png");
            this.bindTexture(textures2);
            GL11.glPushMatrix();
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            GL11.glColor3f(AspectHelper.getRed(a2), AspectHelper.getGreen(a2), AspectHelper.getBlue(a2));
            GL11.glTranslatef(0f, 1.25f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            
            if (tile.getWorldObj() != null) {
                switch (tile.orientation.ordinal()) {
                    case 5: {
                    	GL11.glTranslatef(0.0f, 0.0f, 0.3125f); //test
                        break;
                    }
                    case 4: {
                    	GL11.glTranslatef(0.0f, 0.0f, -0.3125f);
                    	break;
                    }
                    case 3: {
                    	GL11.glTranslatef(-0.3125f, 0.0f, 0.0f);
                        break;
                    }
                    case 2: {
                    	GL11.glTranslatef(0.3125f, 0.0f, 0.0f);
                        break;
                    }
                }   
            }
            this.essentiaL.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, i);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
        i = tile.storage[2].getAmount();
        if (i > 0) {
            final Aspect a2 = tile.storage[2].getAspect();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
            final ResourceLocation textures2 = new ResourceLocation("thaumicalchemy:textures/blocks/animatedglow.png");
            this.bindTexture(textures2);
            GL11.glPushMatrix();
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            GL11.glColor3f(AspectHelper.getRed(a2), AspectHelper.getGreen(a2), AspectHelper.getBlue(a2));
            GL11.glTranslatef(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef((float)(-tile.ticks * 10), 0.0f, 1.0f, 0.0f);
            this.essentiaL.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, (i/2) );
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
        //amalg model
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        final ResourceLocation texture = new ResourceLocation("thaumicalchemy:textures/blocks/amalgamator.png");
        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        
        if (tile.getWorldObj() != null) {
            switch (tile.orientation.ordinal()) {
                case 5: {
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 4: {
                	GL11.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
                	break;
                }
                case 3: {
                    GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 2: {
                    GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
            }   
        }
        this.base.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glRotatef((float)(tile.ticks * 10), 0.0f, 1.0f, 0.0f);
        this.midJar.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        
        GL11.glPopMatrix();
    }
}
