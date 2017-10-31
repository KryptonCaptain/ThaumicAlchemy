package me.codasylph.thaumicalchemy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import thaumcraft.api.ItemApi;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabTA extends CreativeTabs
{
    public CreativeTabTA(final int id, final String unlocalizedName) {
        super(id, unlocalizedName);
    }
    
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ItemApi.getItem("itemEssence", 0).getItem();
    }
}
