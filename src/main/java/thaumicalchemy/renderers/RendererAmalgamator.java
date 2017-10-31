package me.codasylph.thaumicalchemy.renderers;

import thaumcraft.api.aspects.Aspect;
import me.codasylph.thaumicalchemy.AspectHelper;
import me.codasylph.thaumicalchemy.blocks.EssentiaAmalgamator;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import org.lwjgl.opengl.GL11;
import net.minecraft.world.World;
import me.codasylph.thaumicalchemy.tileentities.TileAmalgamator;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

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
    
    private void adjustRotatePivotViaMeta(final World world, final int x, final int y, final int z) {
        final int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef((float)(meta * -90), 0.0f, 0.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
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
        return EssentiaAmalgamator.renderId;
    }
    
    public void render(final TileAmalgamator tile, final double x, final double y, final double z, final float scale) {
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
            GL11.glTranslatef(0.3125f, 1.25f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
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
            GL11.glTranslatef(-0.3125f, 1.25f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
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
            this.essentiaL.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, i);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        final ResourceLocation textures = new ResourceLocation("thaumicalchemy:textures/blocks/amalgamator.png");
        this.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.base.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glRotatef((float)(tile.ticks * 10), 0.0f, 1.0f, 0.0f);
        this.midJar.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
