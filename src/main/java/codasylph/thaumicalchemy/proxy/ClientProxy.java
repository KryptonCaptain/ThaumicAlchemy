package codasylph.thaumicalchemy.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import codasylph.thaumicalchemy.blocks.EssentiaAmalgamator;
import codasylph.thaumicalchemy.renderers.RendererAmalgamator;
import codasylph.thaumicalchemy.tileentities.TileAmalgamator;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers() {
        final RendererAmalgamator rendAmalgamator = new RendererAmalgamator();
        RenderingRegistry.registerBlockHandler(EssentiaAmalgamator.renderId = RenderingRegistry.getNextAvailableRenderId(), (ISimpleBlockRenderingHandler)rendAmalgamator);
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileAmalgamator.class, (TileEntitySpecialRenderer)rendAmalgamator);
    }
}
