package me.codasylph.thaumicalchemy.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import me.codasylph.thaumicalchemy.tileentities.TileAmalgamator;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import me.codasylph.thaumicalchemy.blocks.EssentiaAmalgamator;
import cpw.mods.fml.client.registry.RenderingRegistry;
import me.codasylph.thaumicalchemy.renderers.RendererAmalgamator;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers() {
        final RendererAmalgamator rendAmalgamator = new RendererAmalgamator();
        RenderingRegistry.registerBlockHandler(EssentiaAmalgamator.renderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)rendAmalgamator);
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileAmalgamator.class, (TileEntitySpecialRenderer)rendAmalgamator);
    }
}
