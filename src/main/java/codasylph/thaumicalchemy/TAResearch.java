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
        //
    	ShapedArcaneRecipe essamalgRecipe = ThaumcraftApi.addArcaneCraftingRecipe("ESSAMALG", new ItemStack(TABlocks.essentiaAmalgamator), new AspectList().add(Aspect.WATER, 25).add(Aspect.ORDER, 25).add(Aspect.FIRE, 10), new Object[] { "TJT", "JAJ", " V ", 'T', new ItemStack(ConfigBlocks.blockTube), 'J', new ItemStack(ConfigBlocks.blockJar), 'A', new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), 'V', new ItemStack(ConfigBlocks.blockTube, 1, 1) });
        
        //
        CrucibleRecipe dupRedstone = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.redstone, 2), 
        		(Object)new ItemStack(Items.redstone), new AspectList().add(Aspect.ENERGY, 2).add(Aspect.MECHANISM, 1));
        
        CrucibleRecipe dupFlint = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.flint, 2), 
        		(Object)new ItemStack(Items.flint), new AspectList().add(Aspect.TOOL, 2).add(Aspect.EARTH, 1));
        
        CrucibleRecipe dupLeather = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.leather, 2), 
        		(Object)new ItemStack(Items.leather), new AspectList().add(Aspect.CLOTH, 2).add(Aspect.BEAST, 1).add(Aspect.ARMOR, 1));
        
        CrucibleRecipe dupCoal = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.coal, 2), 
        		(Object)new ItemStack(Items.coal), new AspectList().add(Aspect.ENERGY, 2).add(Aspect.FIRE, 2));
        
        CrucibleRecipe manfBlazeRod = ThaumcraftApi.addCrucibleRecipe("NEWDISC", new ItemStack(Items.blaze_rod), 
        		(Object)new ItemStack(Items.blaze_powder), new AspectList().add(Aspect.FIRE, 5).add(Aspect.MAGIC, 3));
        
        //
        CrucibleRecipe transDiamond = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.diamond, 2), 
        		(Object)new ItemStack(Items.diamond), new AspectList().add(Aspect.GREED, 8).add(Aspect.CRYSTAL, 8));
        
        CrucibleRecipe transEmerald = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.emerald, 2), 
        		(Object)new ItemStack(Items.emerald), new AspectList().add(Aspect.GREED, 10).add(Aspect.CRYSTAL, 8));
        
        CrucibleRecipe transQuartz = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.quartz, 2), 
        		(Object)new ItemStack(Items.quartz), new AspectList().add(Aspect.ENERGY, 4).add(Aspect.CRYSTAL, 4));
        
        CrucibleRecipe transLapis = ThaumcraftApi.addCrucibleRecipe("TRANSGEM", new ItemStack(Items.dye, 2, 4), 
        		(Object)new ItemStack(Items.dye, 1, 4), new AspectList().add(Aspect.SENSES, 4).add(Aspect.CRYSTAL, 4));
        
        
        ResearchCategories.registerCategory("XALCHEMY", 
        		new ResourceLocation("thaumcraft:textures/misc/r_alchman.png"), 
        		new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
        
        new FakeResearchItem("TA.ALCHEMICALDUPLICATION", "XALCHEMY", "ALCHEMICALDUPLICATION", "ALCHEMY", -1, 0, ResearchCategories.getResearch("ALCHEMICALDUPLICATION").icon_resource).registerResearchItem();
        
        new FakeResearchItem("TA.CENTRIFUGE", "XALCHEMY", "CENTRIFUGE", "ALCHEMY", 1, 0, ResearchCategories.getResearch("CENTRIFUGE").icon_item).registerResearchItem();
        
        new FakeResearchItem("TA.TRANSGOLD", "XALCHEMY", "TRANSGOLD", "ALCHEMY", 0, -2, ResearchCategories.getResearch("TRANSGOLD").icon_item).registerResearchItem();

        
        
        new ResearchItem("ESSAMALG", "XALCHEMY", 
        		new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.SLIME, 4).add(Aspect.MECHANISM, 4).add(Aspect.MAGIC, 4), 
        		2, 2, 3, new ItemStack(TABlocks.essentiaAmalgamator))
        	.setPages(new ResearchPage[] { 
        			new ResearchPage("tc.research_page.ESSAMALG.1"), 
        			new ResearchPage("tc.research_page.ESSAMALG.2"), 
        			new ResearchPage((IArcaneRecipe)essamalgRecipe) })
			.setParents("TA.CENTRIFUGE")
			.registerResearchItem();
        

        new ResearchItem("TRANSGEM", "XALCHEMY", 
        		new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.GREED, 4).add(Aspect.CRYSTAL, 4), 
        		0, -4, 2, new ItemStack(Items.diamond))
        	.setPages(new ResearchPage[] { 
        			new ResearchPage("tc.research_page.TRANSGEM.1"), 
        			new ResearchPage(transQuartz), 
        			new ResearchPage(transLapis), 
        			new ResearchPage(transDiamond), 
        			new ResearchPage(transEmerald) })
			.setParents("TA.TRANSGOLD")
			.setSecondary()
			.registerResearchItem();
 
        new ResearchItem("NEWDISC", "XALCHEMY", 
        		new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.MAGIC, 2), 
        		-2, 2, 2, new ResourceLocation("thaumicalchemy:textures/r_newDisc.png"))
        	.setPages(new ResearchPage[] { 
        			new ResearchPage("tc.research_page.NEWDISC.1"), 
        			new ResearchPage(dupRedstone), 
        			new ResearchPage(dupFlint), 
        			new ResearchPage(dupCoal), 
        			new ResearchPage(dupLeather), 
        			new ResearchPage(manfBlazeRod) })
			.setParents("ALCHEMICALMANUFACTURE", "TA.ALCHEMICALDUPLICATION")
			.setSecondary()
			.registerResearchItem();
 
    }
}
