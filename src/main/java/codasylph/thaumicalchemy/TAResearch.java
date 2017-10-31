package codasylph.thaumicalchemy;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import codasylph.thaumicalchemy.blocks.TABlocks;

public class TAResearch
{
    public static void init() {
        final ShapedArcaneRecipe essamalgRecipe = ThaumcraftApi.addArcaneCraftingRecipe("ESSAMALG", new ItemStack(TABlocks.essentiaAmalgamator), new AspectList().add(Aspect.WATER, 25).add(Aspect.ORDER, 25).add(Aspect.FIRE, 10), new Object[] { "TJT", "JAJ", " V ", 'T', new ItemStack(ConfigBlocks.blockTube), 'J', new ItemStack(ConfigBlocks.blockJar), 'A', new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), 'V', new ItemStack(ConfigBlocks.blockTube, 1, 1) });
        final CrucibleRecipe dupRedstone = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.redstone, 2), (Object)new ItemStack(Items.redstone), new AspectList().add(Aspect.ENERGY, 2).add(Aspect.MECHANISM, 1));
        final CrucibleRecipe dupFlint = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.flint, 2), (Object)new ItemStack(Items.flint), new AspectList().add(Aspect.TOOL, 2).add(Aspect.EARTH, 1));
        final CrucibleRecipe dupLeather = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.leather, 2), (Object)new ItemStack(Items.leather), new AspectList().add(Aspect.CLOTH, 2).add(Aspect.BEAST, 1).add(Aspect.ARMOR, 1));
        final CrucibleRecipe dupCoal = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.coal, 2), (Object)new ItemStack(Items.coal), new AspectList().add(Aspect.ENERGY, 2).add(Aspect.FIRE, 2));
        final CrucibleRecipe manfBlazeRod = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.blaze_rod), (Object)new ItemStack(Items.blaze_powder), new AspectList().add(Aspect.FIRE, 5).add(Aspect.MAGIC, 3));
        final CrucibleRecipe transDiamond = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.diamond, 2), (Object)new ItemStack(Items.diamond), new AspectList().add(Aspect.GREED, 8).add(Aspect.CRYSTAL, 8));
        final CrucibleRecipe transEmerald = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.emerald, 2), (Object)new ItemStack(Items.emerald), new AspectList().add(Aspect.GREED, 10).add(Aspect.CRYSTAL, 8));
        final CrucibleRecipe transQuartz = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.quartz, 2), (Object)new ItemStack(Items.quartz), new AspectList().add(Aspect.ENERGY, 4).add(Aspect.CRYSTAL, 4));
        final CrucibleRecipe transLapis = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.dye, 2, 4), (Object)new ItemStack(Items.dye, 1, 4), new AspectList().add(Aspect.SENSES, 4).add(Aspect.CRYSTAL, 4));
        ResearchCategories.registerCategory("XALCHEMY", new ResourceLocation("thaumicalchemy:textures/alchemyTab.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
        ResearchItem research = new ResearchItem("ESSAMALG", "XALCHEMY", new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.SLIME, 4).add(Aspect.MECHANISM, 4).add(Aspect.MAGIC, 4), 1, -1, 2, new ItemStack(TABlocks.essentiaAmalgamator));
        research.setPages(new ResearchPage[] { new ResearchPage(Constants.ESSAMALPage1), new ResearchPage(Constants.ESSAMALPage2), new ResearchPage((IArcaneRecipe)essamalgRecipe) }).setParents(new String[] { "CENTRIFUGE" });
        ResearchCategories.addResearch(research);
        research = new ResearchItem("TRANSGEM", "XALCHEMY", new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.GREED, 4).add(Aspect.CRYSTAL, 4), 1, -5, 2, new ItemStack(Items.diamond));
        research.setPages(new ResearchPage[] { new ResearchPage(Constants.TRANSGEMPage1), new ResearchPage(transQuartz), new ResearchPage(transLapis), new ResearchPage(transDiamond), new ResearchPage(transEmerald) });
        research.setParents(new String[] { "TRANSGOLD" }).setSecondary();
        ResearchCategories.addResearch(research);
        research = new ResearchItem("NEWDISC", "XALCHEMY", new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.MAGIC, 2), -1, -3, 2, new ResourceLocation("thaumicalchemy:textures/NewDisc.png"));
        research.setPages(new ResearchPage[] { new ResearchPage(Constants.NEWDISCPage1), new ResearchPage(dupRedstone), new ResearchPage(dupFlint), new ResearchPage(dupCoal), new ResearchPage(dupLeather), new ResearchPage(manfBlazeRod) });
        research.setParents(new String[] { "ALCHEMICALMANUFACTURE", "ALCHEMICALDUPLICATION" }).setSecondary();
        ResearchCategories.addResearch(research);
    }
}
