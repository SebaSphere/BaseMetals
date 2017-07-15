package com.mcmoddev.lib.init;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.material.IMMDObject;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.material.MMDMaterial.MaterialType;
import com.mcmoddev.lib.recipe.*;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 *
 * @author Jasmine Iwanek
 *
 */
public abstract class Recipes {

	private static boolean initDone = false;
	private static final String SORTLOC = "after:minecraft:shapeless";

	protected Recipes() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		Materials.init();
		Blocks.init();
		Items.init();

		initPureVanillaOredicts();
		initPureVanillaCrusherRecipes();
		initVanillaRecipes();
		initGeneralRecipes();
		initModSpecificRecipes();

		initDone = true;
	}

	protected static void initPureVanillaOredicts() {
		OreDictionary.registerOre(Oredicts.BARS_IRON, net.minecraft.init.Blocks.IRON_BARS);
		OreDictionary.registerOre(Oredicts.BARS, net.minecraft.init.Blocks.IRON_BARS);
		OreDictionary.registerOre(Oredicts.DOOR_IRON, net.minecraft.init.Items.IRON_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.IRON_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR_WOOD, net.minecraft.init.Items.OAK_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR_WOOD, net.minecraft.init.Items.JUNGLE_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR_WOOD, net.minecraft.init.Items.SPRUCE_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR_WOOD, net.minecraft.init.Items.DARK_OAK_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR_WOOD, net.minecraft.init.Items.BIRCH_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR_WOOD, net.minecraft.init.Items.ACACIA_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.OAK_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.JUNGLE_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.SPRUCE_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.DARK_OAK_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.BIRCH_DOOR);
		OreDictionary.registerOre(Oredicts.DOOR, net.minecraft.init.Items.ACACIA_DOOR);
	}

	protected static void initPureVanillaCrusherRecipes() {
		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.STONE, new ItemStack(net.minecraft.init.Blocks.COBBLESTONE, 1)); // Stone to Cobblestone
		// CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.STONE, new ItemStack(net.minecraft.init.Blocks.COBBLESTONE, 1)); // Stone to Cobblestone
		// CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.STONEBRICK, 1), new ItemStack(net.minecraft.init.Blocks.COBBLESTONE, 1)); // Stone Bricks to Cobblestone
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.STONEBRICK, new ItemStack(net.minecraft.init.Blocks.COBBLESTONE, 1)); // Stone Bricks to Cobblestone
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.STONE_SLAB, 1, 0), new ItemStack(net.minecraft.init.Blocks.STONE_SLAB, 1, 3)); // Stone Slab to Cobblestone Slab
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.STONE_SLAB, 1, 5), new ItemStack(net.minecraft.init.Blocks.STONE_SLAB, 1, 3)); // Stone Bricks Slab to Cobblestone Slab

		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.COBBLESTONE, new ItemStack(net.minecraft.init.Blocks.GRAVEL, 1)); // Cobblestone to Gravel
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.MOSSY_COBBLESTONE, new ItemStack(net.minecraft.init.Blocks.GRAVEL, 1)); // Mossy Cobblestone to Gravel
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.COBBLESTONE_WALL, 1, 0), new ItemStack(net.minecraft.init.Blocks.GRAVEL, 1)); // Cobblestone Wall to Gravel
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.COBBLESTONE_WALL, 1, 1), new ItemStack(net.minecraft.init.Blocks.GRAVEL, 1)); // Mossy Cobblestone Wall to Gravel

		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.GRAVEL, new ItemStack(net.minecraft.init.Blocks.SAND, 1)); // Gravel to Sand
		// CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.SANDSTONE, 1), new ItemStack(net.minecraft.init.Blocks.SAND, 4)); // Sandstone to Sand
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.SANDSTONE, new ItemStack(net.minecraft.init.Blocks.SAND, 4)); // Sandstone to Sand
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.STONE_SLAB, 1, 1), new ItemStack(net.minecraft.init.Blocks.SAND, 2)); // Sandstone Slab to 2 Sand
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.GLASS, new ItemStack(net.minecraft.init.Blocks.SAND, 1)); // Glass to Sand

		// CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.RED_SANDSTONE, 1), new ItemStack(net.minecraft.init.Blocks.SAND, 4, 1)); // Red Sandstone to Red Sand
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.RED_SANDSTONE, new ItemStack(net.minecraft.init.Blocks.SAND, 4, 1)); // Red Sandstone to Red Sand
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.STONE_SLAB2, 1, 0), new ItemStack(net.minecraft.init.Blocks.SAND, 2, 1)); // Red Sandstone Slab to 2 Red Sand
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.STAINED_GLASS, new ItemStack(net.minecraft.init.Blocks.SAND, 4, 1)); // Red Stained Glass to Red Sand

		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.GLOWSTONE, new ItemStack(net.minecraft.init.Items.GLOWSTONE_DUST, 4)); // Glowstone to 4 Glowstone Dust

		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.ORE_LAPIS, new ItemStack(net.minecraft.init.Items.DYE, 8, 4)); // Lapis Ore to 8 Lapis
		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.BLOCK_LAPIS, new ItemStack(net.minecraft.init.Items.DYE, 9, 4)); // Lapis Block to 9 Lapis

		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.ORE_REDSTONE, new ItemStack(net.minecraft.init.Items.REDSTONE, 8)); // Redstone Ore to 8 Redstone
		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.BLOCK_REDSTONE, new ItemStack(net.minecraft.init.Items.REDSTONE, 9)); // Redstone Block to 9 Redstone

		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Items.REEDS, new ItemStack(net.minecraft.init.Items.SUGAR, 2)); // Sugar Cane to 2 Sugar

		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.BONE_BLOCK, new ItemStack(net.minecraft.init.Items.DYE, 9, 15)); // Bone Block to 9 Bonemeal
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Items.BONE, new ItemStack(net.minecraft.init.Items.DYE, 3, 15)); // Bone to 3 Bonemeal

		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Items.BLAZE_ROD, new ItemStack(net.minecraft.init.Items.BLAZE_POWDER, 2)); // Blaze Rod to 2 Blaze Powder

		CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.ORE_QUARTZ, new ItemStack(net.minecraft.init.Items.QUARTZ, 2)); // Nether Quartz Ore to 2 Quartz
		// CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.BLOCKQUARTZ, new ItemStack(net.minecraft.init.Items.QUARTZ, 4)); // Quartz Block to 4 Quartz
		// CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.QUARTZ_BLOCK, 1), new ItemStack(net.minecraft.init.Items.QUARTZ, 4)); // Quartz Block to 4 Quartz
		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.QUARTZ_BLOCK, new ItemStack(net.minecraft.init.Items.QUARTZ, 4)); // Quartz Block to 4 Quartz
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.STONE_SLAB, 1, 7), new ItemStack(net.minecraft.init.Items.QUARTZ, 2)); // Quartz Slab to 2 Quartz

		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.PRISMARINE, 1, 0), new ItemStack(net.minecraft.init.Items.PRISMARINE_SHARD, 4)); // Prismarine to Prismarine Shard
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.PRISMARINE, 1, 1), new ItemStack(net.minecraft.init.Items.PRISMARINE_SHARD, 9)); // Brismarine Bricks to Prismarine Shard
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(net.minecraft.init.Blocks.PRISMARINE, 1, 2), new ItemStack(net.minecraft.init.Items.PRISMARINE_SHARD, 8)); // Dark Prismarine to Prismarine Shard

		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.SEA_LANTERN, new ItemStack(net.minecraft.init.Items.PRISMARINE_CRYSTALS, 5)); // Sea Lantern to 5 Prismarine Crystals to Prismarine Shard

		CrusherRecipeRegistry.addNewCrusherRecipe(net.minecraft.init.Blocks.SLIME_BLOCK, new ItemStack(net.minecraft.init.Items.SLIME_BALL, 9)); // Slime Block to 9 Slime Balls

	}

	protected static void initVanillaRecipes() {
		// stub
	}

	protected static void initGeneralRecipes() {

		for (final MMDMaterial material : Materials.getAllMaterials()) {
			if (material == null) {
				return;
			}

			// first we handle any recipes possibly involving transformations of an ore-block
			makePowderRecipes(material); // this also handles ingot->powder, block->powder, etc..
			makeIngotRecipes(material); // nugget->ingot, ore->ingot, powder->ingot

			// next we hand recipes involving blocks
			makeBlockRecipes(material); // handles any recipe which outputs a block

			// nugget based recipes
			makeNuggetRecipes(material);

			// then the rest of the basic stuff
			makeSimpleRecipes(material); // slab, wall, small-powder, rod, lever, crackhammer, trapdoor, etc...
			makeModRecipes(material); // rod, gear, etc...

			// ranged weapons all use the 'ROD' of a material
			if (material.hasItem(Names.ROD)) {
				makeCrossbowRecipes(material);
				makeBowRecipes(material);
			}

			// shields are a necessary thing
			makeShieldRecipes(material);

			// for now this can live here
			if ((material.hasItem(Names.BLEND)) && (material.hasItem(Names.SMALLBLEND))) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.SMALLBLEND), 9), new ItemStack(material.getItem(Names.BLEND))));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.BLEND)), "xxx", "xxx", "xxx", 'x', new ItemStack(material.getItem(Names.SMALLBLEND))));
			}

			// as can this
			if (material.hasItem(Names.INGOT)) {
				// Vanilla has all the base tools & armors where they currently matter.
				generateBaseTools(material);
			}

			furnaceSpecial(material);
		}
	}

	private static void makeShieldRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();
		final String repairSort = "mmd:shieldrepair";
		final String upgradeSort = "mmd:shieldupgrade";

		if (material.hasItem(Names.SHIELD)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.SHIELD)), "xyx", "xxx", " x ", 'y', Oredicts.PLANK_WOOD, 'x', Oredicts.INGOT + oreDictName));
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.SHIELD)), new ItemStack(material.getItem(Names.INGOT), 6), 0); // 1 wood loss
			if (material.hasItem(Names.PLATE)) {
				if (Options.enablePlateRepairs()) {
					GameRegistry.addRecipe(new ShieldRepairRecipe(material));
					RecipeSorter.register(repairSort, ShieldRepairRecipe.class, Category.SHAPELESS, SORTLOC);
				}

				if (Options.enableShieldUpgrades()) {
					GameRegistry.addRecipe(new ShieldUpgradeRecipe(material));
					RecipeSorter.register(upgradeSort, ShieldUpgradeRecipe.class, Category.UNKNOWN, SORTLOC);
				}
			}
		}
	}

	private static void makeBowRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();

		if (material.hasItem(Names.ARROW)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.ARROW), 4), "x", "y", "z", 'x', Oredicts.NUGGET + oreDictName, 'y', Oredicts.ROD + oreDictName, 'z', Oredicts.FEATHER));
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.ARROW)), new ItemStack(material.getItem(Names.NUGGET), 1), 0); // 0.25 nugget loss
		}

		if (material.hasItem(Names.BOW)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.BOW)), " xy", "x y", " xy", 'x', Oredicts.ROD + oreDictName, 'y', Oredicts.STRING));
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.BOW)), new ItemStack(material.getItem(Names.INGOT), 1), 0); // 4.5 nugget loss
		}

	}

	private static void makeCrossbowRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();

		if ((material.hasItem(Names.GEAR)) && (material.hasItem(Names.CROSSBOW))) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.CROSSBOW)), "zxx", " yx", "x z", 'x', Oredicts.ROD + oreDictName, 'y', Oredicts.GEAR + oreDictName, 'z', Oredicts.STRING));
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.CROSSBOW)), new ItemStack(material.getItem(Names.INGOT), 2 + Options.gearQuantity()), 0);
		}

		if (material.hasItem(Names.BOLT)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.BOLT), 4), "x", "x", "y", 'x', Oredicts.ROD + oreDictName, 'y', Oredicts.FEATHER));
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.BOLT)), new ItemStack(material.getItem(Names.NUGGET), 2), 0); // 0.25 nugget loss
		}
	}

	private static void makeNuggetRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();

		if (material.hasItem(Names.NUGGET)) {
			if (material.hasItem(Names.BUTTON)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.BUTTON)), "x", "x", 'x', Oredicts.NUGGET + oreDictName));
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.BUTTON)), new ItemStack(material.getItem(Names.NUGGET), 2), 0);
			}
			if (material.hasItem(Names.ROD)) {
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.ROD)), new ItemStack(material.getItem(Names.NUGGET), 4), 0); // Roughly half a nugget loss
			}

			if ((material.hasItem(Names.POWDER)) && (material.hasItem(Names.SMALLPOWDER))) {
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.SMALLPOWDER)), new ItemStack(material.getItem(Names.NUGGET), 1), 0);
				CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.NUGGET + oreDictName, new ItemStack(material.getItem(Names.SMALLPOWDER), 1));
			}
		}
		if (material.hasItem(Names.SMALLBLEND)) {
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.SMALLBLEND)), new ItemStack(material.getItem(Names.NUGGET), 1), 0);
		}
	}

	private static void makeModRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();

		if (material.hasItem(Names.ROD)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.ROD), 4), "x", "x", 'x', Oredicts.INGOT + oreDictName));

			if (material.hasItem(Names.GEAR)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.GEAR), Options.gearQuantity()), " x ", "x/x", " x ", 'x', Oredicts.INGOT + oreDictName, '/', Oredicts.ROD + oreDictName));
				if (material.hasItem(Names.INGOT)) {
					// if there is no ingot, no cheese
					GameRegistry.addSmelting(new ItemStack(material.getItem(Names.GEAR)), new ItemStack(material.getItem(Names.INGOT), Options.gearQuantity()), 0); // you lose the rod
				}
			}
		}
	}

	private static void makeSimpleRecipes(@Nonnull final MMDMaterial material) {
		if (material == null) {
			return;
		}

		final String oreDictName = material.getCapitalizedName();

		if (material.hasBlock(Names.BLOCK)) {
			if (material.hasItem(Names.SLAB)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.SLAB), 6), "xxx", 'x', Oredicts.BLOCK + oreDictName));
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.SLAB)), new ItemStack(material.getItem(Names.NUGGET), 4), 0); // you lose roughly half a nugget
			}

			if ((material.hasItem(Names.ROD)) && (material.hasItem(Names.LEVER))) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.LEVER)), "x", "y", 'x', Oredicts.ROD + oreDictName, 'y', Oredicts.INGOT + oreDictName));
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.LEVER)), new ItemStack(material.getItem(Names.INGOT), 1), 0); // you lose the rod
			}

			if (material.hasBlock(Names.STAIRS)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.STAIRS), 4), "x  ", "xx ", "xxx", 'x', Oredicts.BLOCK + oreDictName));
			}

			if (material.hasBlock(Names.WALL)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.WALL), 6), "xxx", "xxx", 'x', Oredicts.BLOCK + oreDictName));
				GameRegistry.addSmelting(new ItemStack(material.getBlock(Names.WALL)), new ItemStack(material.getBlock(Names.BLOCK), 1), 0);
			}

			if ((material.hasItem(Names.CRACKHAMMER)) && (!Options.disableAllHammerRecipes())) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.CRACKHAMMER)), "x", "/", "/", 'x', Oredicts.BLOCK + oreDictName, '/', Oredicts.STICK_WOOD));
			}

			if (material.hasBlock(Names.BARS) && material.hasItem(Names.ROD)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.BARS), 4), "xxx", 'x', Oredicts.ROD + oreDictName));
			}

			if (material.getBlock(Names.BLOCK) instanceof IMMDObject) {
				if (material.hasBlock(Names.PLATE)) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.PLATE), Options.plateQuantity()), "xxx", 'x', Oredicts.INGOT + oreDictName));
					GameRegistry.addSmelting(new ItemStack(material.getBlock(Names.PLATE)), new ItemStack(material.getItem(Names.INGOT), 1), 0);
				}

				if (material.hasBlock(Names.PRESSURE_PLATE)) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.PRESSURE_PLATE)), "xx", 'x', Oredicts.INGOT + oreDictName));
					GameRegistry.addSmelting(new ItemStack(material.getBlock(Names.PRESSURE_PLATE)), new ItemStack(material.getItem(Names.INGOT), 2), 0);
				}

				if (material.hasBlock(Names.BARS)) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.BARS), 16), "xxx", "xxx", 'x', Oredicts.INGOT + oreDictName));
					GameRegistry.addSmelting(new ItemStack(material.getBlock(Names.BARS)), new ItemStack(material.getItem(Names.NUGGET), 3), 0); // roughly half a nugget loss
				}

				if (material.hasItem(Names.DOOR)) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.DOOR), 3), "xx", "xx", "xx", 'x', Oredicts.INGOT + oreDictName));
					GameRegistry.addSmelting(new ItemStack(material.getItem(Names.DOOR)), new ItemStack(material.getItem(Names.INGOT), 2), 0);
				}

				if (material.hasBlock(Names.TRAPDOOR)) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.TRAPDOOR)), "xx", "xx", 'x', Oredicts.INGOT + oreDictName));
					GameRegistry.addSmelting(new ItemStack(material.getBlock(Names.TRAPDOOR)), new ItemStack(material.getItem(Names.INGOT), 4), 0);
				}

				// Diamond, Gold & Iron Horse armor are in vanilla so dont do them for vanilla mats
				if ((material.getItem(Names.HORSE_ARMOR) instanceof IMMDObject) && (material.hasItem(Names.HORSE_ARMOR))) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.HORSE_ARMOR)), "  x", "xyx", "xxx", 'x', Oredicts.INGOT + oreDictName, 'y', net.minecraft.init.Blocks.WOOL));
					GameRegistry.addSmelting(new ItemStack(material.getItem(Names.HORSE_ARMOR)), new ItemStack(material.getItem(Names.INGOT), 6), 0); // 1 wool loss
				}

				if (material.hasItem(Names.FISHING_ROD)) {
					GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.FISHING_ROD)), "  x", " xy", "x y", 'x', Oredicts.ROD + oreDictName, 'y', Oredicts.STRING));
					GameRegistry.addSmelting(new ItemStack(material.getItem(Names.FISHING_ROD)), new ItemStack(material.getItem(Names.INGOT), 1), 0); // 4.5 nugget loss
				}

			}
		}
	}

	private static void makeBlockRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();

		if (material.hasBlock(Names.BLOCK) && (material.getBlock(Names.BLOCK) instanceof IMMDObject) && (material.hasItem(Names.INGOT))) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.INGOT), 9), Oredicts.BLOCK + oreDictName));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getBlock(Names.BLOCK)), "xxx", "xxx", "xxx", 'x', Oredicts.INGOT + oreDictName));
		}
	}

	private static void makeIngotRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();
		// NOTE: smelting XP is based on output item, not input item
		final float oreSmeltXP = material.getOreSmeltXP();

		if (material.hasItem(Names.INGOT)) {
			if (material.hasOre()) {
				GameRegistry.addSmelting(new ItemStack(material.getBlock(Names.ORE)), new ItemStack(material.getItem(Names.INGOT), 1), oreSmeltXP);
			} else if (material.hasBlend()) {
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.BLEND)), new ItemStack(material.getItem(Names.INGOT)), oreSmeltXP);
			}

			if (material.hasItem(Names.NUGGET)) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.NUGGET), 9), Oredicts.INGOT + oreDictName));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.INGOT)), "xxx", "xxx", "xxx", 'x', Oredicts.NUGGET + oreDictName));
			}

			if (material.hasItem(Names.POWDER)) {
				GameRegistry.addSmelting(new ItemStack(material.getItem(Names.POWDER)), new ItemStack(material.getItem(Names.INGOT), 1), oreSmeltXP);
			}
		}
	}

	private static void makePowderRecipes(@Nonnull final MMDMaterial material) {
		final String oreDictName = material.getCapitalizedName();

		if (material.hasItem(Names.POWDER)) {
			if (material.hasOre()) {
				CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.ORE + oreDictName, new ItemStack(material.getItem(Names.POWDER), 2));
			}
			if (material.hasItem(Names.INGOT)) {
				CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.INGOT + oreDictName, new ItemStack(material.getItem(Names.POWDER), 1));
			}
			if (material.hasItem(Names.BLOCK)) {
				CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.BLOCK + oreDictName, new ItemStack(material.getItem(Names.POWDER), 9));
			}
			if (material.hasItem(Names.SMALLPOWDER)) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.SMALLPOWDER), 9), new ItemStack(material.getItem(Names.POWDER))));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.POWDER)), "xxx", "xxx", "xxx", 'x', new ItemStack(material.getItem(Names.SMALLPOWDER))));
				if (material.hasItem(Names.NUGGET)) {
					CrusherRecipeRegistry.addNewCrusherRecipe(Oredicts.NUGGET + oreDictName, new ItemStack(material.getItem(Names.SMALLPOWDER), 1));
				}
			}
		}
	}

	private static void generateBaseTools(@Nonnull final MMDMaterial material) {
		if (material == null) {
			return;
		}

		final String oreDictName = material.getCapitalizedName();

		if ((material.hasItem(Names.BOOTS)) && (material.getItem(Names.BOOTS) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.BOOTS)), "x x", "x x", 'x', Oredicts.INGOT + oreDictName));
			if ((material.hasItem(Names.PLATE)) && (Options.enablePlateRepairs())) {
				GameRegistry.addRecipe(new BootsRepairRecipe(material));
				RecipeSorter.register("mmd:bootsrepair", BootsRepairRecipe.class, Category.SHAPELESS, SORTLOC);
			}
		}

		if ((material.hasItem(Names.HELMET)) && (material.getItem(Names.HELMET) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.HELMET)), "xxx", "x x", 'x', Oredicts.INGOT + oreDictName));
			if ((material.hasItem(Names.PLATE)) && (Options.enablePlateRepairs())) {
				GameRegistry.addRecipe(new HelmetRepairRecipe(material));
				RecipeSorter.register("mmd:helmetrepair", HelmetRepairRecipe.class, Category.SHAPELESS, SORTLOC);
			}
		}

		if ((material.hasItem(Names.CHESTPLATE)) && (material.getItem(Names.CHESTPLATE) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.CHESTPLATE)), "x x", "xxx", "xxx", 'x', Oredicts.INGOT + oreDictName));
			if ((material.hasItem(Names.PLATE)) && (Options.enablePlateRepairs())) {
				GameRegistry.addRecipe(new ChestplateRepairRecipe(material));
				RecipeSorter.register("mmd:chestplaterepair", ChestplateRepairRecipe.class, Category.SHAPELESS, SORTLOC);
			}
		}

		if ((material.hasItem(Names.LEGGINGS)) && (material.getItem(Names.LEGGINGS) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.LEGGINGS)), "xxx", "x x", "x x", 'x', Oredicts.INGOT + oreDictName));
			if ((material.hasItem(Names.PLATE)) && (Options.enablePlateRepairs())) {
				GameRegistry.addRecipe(new LeggingsRepairRecipe(material));
				RecipeSorter.register("mmd:leggingsrepair", LeggingsRepairRecipe.class, Category.SHAPELESS, SORTLOC);
			}
		}

		if ((material.hasItem(Names.AXE)) && (material.getItem(Names.AXE) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.AXE)), "xx", "x/", " /", 'x', Oredicts.INGOT + oreDictName, '/', Oredicts.STICK_WOOD));
		}

		if ((material.hasItem(Names.HOE)) && (material.getItem(Names.HOE) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.HOE)), "xx", " /", " /", 'x', Oredicts.INGOT + oreDictName, '/', Oredicts.STICK_WOOD));
		}

		if ((material.hasItem(Names.PICKAXE)) && (material.getItem(Names.PICKAXE) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.PICKAXE)), "xxx", " / ", " / ", 'x', Oredicts.INGOT + oreDictName, '/', Oredicts.STICK_WOOD));
		}

		if ((material.hasItem(Names.SHOVEL)) && (material.getItem(Names.SHOVEL) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.SHOVEL)), "x", "/", "/", 'x', Oredicts.INGOT + oreDictName, '/', Oredicts.STICK_WOOD));
		}

		if ((material.hasItem(Names.SWORD)) && (material.getItem(Names.SWORD) instanceof IMMDObject)) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.SWORD)), "x", "x", "/", 'x', Oredicts.INGOT + oreDictName, '/', Oredicts.STICK_WOOD));
		}

		if ((material.hasItem(Names.SHEARS)) && (material.getItem(Names.SHEARS) instanceof IMMDObject)) {
			String oredict = Oredicts.INGOT;
			if (material.getType() == MMDMaterial.MaterialType.GEM) {
				oredict = Oredicts.GEM;
			}
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(material.getItem(Names.SHEARS)), " x", "x ", 'x', oredict + oreDictName));
			GameRegistry.addSmelting(new ItemStack(material.getItem(Names.SHEARS)), new ItemStack(material.getItem(Names.INGOT), 2), 0);
		}
	}

	protected static void furnaceSpecial(@Nonnull final MMDMaterial material) {
		// Furnace cheese all the things!
		// TODO: First remove the vanilla recipes
		if ((material.hasItem(Names.INGOT)) && !(material.getItem(Names.INGOT) instanceof com.mcmoddev.lib.material.IMMDObject) && material.hasOre()) {
			if (Options.furnaceCheese()) {
				if (material.hasItem(Names.BOOTS))
					GameRegistry.addSmelting(material.getItem(Names.BOOTS), new ItemStack(material.getItem(Names.INGOT), 4), 0);

				if (material.hasItem(Names.HELMET))
					GameRegistry.addSmelting(material.getItem(Names.HELMET), new ItemStack(material.getItem(Names.INGOT), 5), 0);

				if (material.hasItem(Names.SWORD))
					GameRegistry.addSmelting(material.getItem(Names.SWORD), new ItemStack(material.getItem(Names.INGOT), 2), 0);

				if (material.hasItem(Names.SHOVEL))
					GameRegistry.addSmelting(material.getItem(Names.SHOVEL), new ItemStack(material.getItem(Names.INGOT), 1), 0);

				if (material.hasItem(Names.PICKAXE))
					GameRegistry.addSmelting(material.getItem(Names.PICKAXE), new ItemStack(material.getItem(Names.INGOT), 3), 0);

				if (material.hasItem(Names.HOE))
					GameRegistry.addSmelting(material.getItem(Names.HOE), new ItemStack(material.getItem(Names.INGOT), 2), 0);

				if (material.hasItem(Names.AXE))
					GameRegistry.addSmelting(material.getItem(Names.AXE), new ItemStack(material.getItem(Names.INGOT), 3), 0);

				if (material.hasItem(Names.LEGGINGS))
					GameRegistry.addSmelting(material.getItem(Names.LEGGINGS), new ItemStack(material.getItem(Names.INGOT), 7), 0);

				if (material.hasItem(Names.CHESTPLATE))
					GameRegistry.addSmelting(material.getItem(Names.CHESTPLATE), new ItemStack(material.getItem(Names.INGOT), 8), 0);

				if (material.hasItem(Names.CRACKHAMMER))
					GameRegistry.addSmelting(material.getItem(Names.CRACKHAMMER), new ItemStack(material.getBlock(Names.BLOCK), 1), 0);
			} else if (Options.furnace1112()) {
				//do nothing, contents commented out for now
/*
				ItemStack outputStack = new ItemStack(material.getItem(Names.NUGGET), 1);
				if (material.hasItem(Names.BOOTS))
					GameRegistry.addSmelting(material.getItem(Names.BOOTS), outputStack, 0);

				if (material.hasItem(Names.HELMET))
					GameRegistry.addSmelting(material.getItem(Names.HELMET), outputStack, 0);

				if (material.hasItem(Names.SWORD))
					GameRegistry.addSmelting(material.getItem(Names.SWORD), outputStack, 0);

				if (material.hasItem(Names.SHOVEL))
					GameRegistry.addSmelting(material.getItem(Names.SHOVEL), outputStack, 0);

				if (material.hasItem(Names.PICKAXE))
					GameRegistry.addSmelting(material.getItem(Names.PICKAXE), outputStack, 0);

				if (material.hasItem(Names.HOE))
					GameRegistry.addSmelting(material.getItem(Names.HOE), outputStack, 0);

				if (material.hasItem(Names.AXE))
					GameRegistry.addSmelting(material.getItem(Names.AXE), outputStack, 0);

				if (material.hasItem(Names.LEGGINGS))
					GameRegistry.addSmelting(material.getItem(Names.LEGGINGS), outputStack, 0);

				if (material.hasItem(Names.CHESTPLATE))
					GameRegistry.addSmelting(material.getItem(Names.CHESTPLATE), outputStack, 0);

				if (material.hasItem(Names.CRACKHAMMER))
					GameRegistry.addSmelting(material.getItem(Names.CRACKHAMMER), outputStack, 0);
*/
			}
		}
	}

	private static void initModSpecificRecipes() {

	}

	protected static void addAdditionalOredicts(@Nonnull final String materialName, String oreDictName) {
		addAdditionalOredicts(Materials.getMaterialByName(materialName), oreDictName);
	}

	protected static void addAdditionalOredicts(@Nonnull final MMDMaterial material, @Nonnull final String oreDictNameIn) {
		if (material == null) {
			return;
		}

		String oreDictName = StringUtils.capitalize(oreDictNameIn);

		if ((material.hasOre()) && (material.hasBlock(Names.ORE))) {
			OreDictionary.registerOre(Oredicts.ORE + oreDictName, material.getBlock(Names.ORE));
		}
		if (material.hasBlock(Names.BLOCK)) {
			OreDictionary.registerOre(Oredicts.BLOCK + oreDictName, material.getBlock(Names.BLOCK));
		}
		if (material.hasItem(Names.PLATE)) {
			OreDictionary.registerOre(Oredicts.PLATE + oreDictName, material.getItem(Names.PLATE));
		}
		if (material.hasBlock(Names.BARS)) {
			OreDictionary.registerOre(Oredicts.BARS + oreDictName, material.getBlock(Names.BARS));
		}
		if (material.hasItem(Names.DOOR)) {
			OreDictionary.registerOre(Oredicts.DOOR + oreDictName, material.getItem(Names.DOOR));
		}
		if (material.hasItem(Names.TRAPDOOR)) {
			OreDictionary.registerOre(Oredicts.TRAPDOOR + oreDictName, material.getItem(Names.TRAPDOOR));
		}
		if (material.hasBlend()) {
			if (material.hasItem(Names.BLEND)) {
				OreDictionary.registerOre(Oredicts.DUST + oreDictName, material.getItem(Names.BLEND));
			}
			if (material.hasItem(Names.SMALLBLEND)) {
				OreDictionary.registerOre(Oredicts.DUST_TINY + oreDictName, material.getItem(Names.SMALLBLEND));
				OreDictionary.registerOre(Oredicts.DUST_SMALL + oreDictName, material.getItem(Names.SMALLBLEND));
			}
		}
		if (material.hasItem(Names.INGOT)) {
			if (material.getType() != MaterialType.GEM) {
				OreDictionary.registerOre(Oredicts.INGOT + oreDictName, material.getItem(Names.INGOT)); // For non-gem based
			} else if (material.getType() == MaterialType.GEM) {
				OreDictionary.registerOre(Oredicts.GEM + oreDictName, material.getItem(Names.INGOT)); // For Gem based
			}
		}
		if (material.hasItem(Names.NUGGET)) {
			OreDictionary.registerOre(Oredicts.NUGGET + oreDictName, material.getItem(Names.NUGGET));
		}
		if (material.hasItem(Names.POWDER)) {
			OreDictionary.registerOre(Oredicts.DUST + oreDictName, material.getItem(Names.POWDER));
		}
		if (material.hasItem(Names.SMALLPOWDER)) {
			OreDictionary.registerOre(Oredicts.DUST_TINY + oreDictName, material.getItem(Names.SMALLPOWDER));
			OreDictionary.registerOre(Oredicts.DUST_SMALL + oreDictName, material.getItem(Names.SMALLPOWDER));
		}
		if (material.hasItem(Names.GEAR)) {
			OreDictionary.registerOre(Oredicts.GEAR + oreDictName, material.getItem(Names.GEAR));
		}
		if (material.hasItem(Names.ROD)) {
			OreDictionary.registerOre(Oredicts.ROD + oreDictName, material.getItem(Names.ROD));
			OreDictionary.registerOre(Oredicts.STICK + oreDictName, material.getItem(Names.ROD));
		}
	}

	protected static void addAlloyRecipe(@Nonnull final String materialName, int outputQty, Object... ingredients) {
		addAlloyRecipe(Materials.getMaterialByName(materialName), outputQty, ingredients);
	}

	protected static void addAlloyRecipe(@Nonnull final MMDMaterial material, @Nonnull final int outputQty, @Nonnull final Object... ingredients) {
		if (ingredients.length == 2 && ingredients[0] instanceof String && ingredients[1] instanceof String) {
			addSimpleAlloyRecipe(material, outputQty, (String) ingredients[0], (String) ingredients[1]);
		}

		final Object[] dustIngredients = (new String[ingredients.length]);
		final Object[] tinyDustIngredients = (new String[ingredients.length]);

		for (int i = 0; i < ingredients.length; i++) {
			final String oreDictName = StringUtils.capitalize((String) ingredients[i]);
			dustIngredients[i] = String.format("%s%s", Oredicts.DUST, oreDictName);
			tinyDustIngredients[i] = String.format("%s%s", Oredicts.DUST_TINY, oreDictName);
		}

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.BLEND), outputQty), dustIngredients));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.SMALLBLEND), outputQty), tinyDustIngredients));
	}

	protected static void addSimpleAlloyRecipe(@Nonnull final String materialName, int outputQty, String oredict1, String oredict2) {
		addSimpleAlloyRecipe(Materials.getMaterialByName(materialName), outputQty, oredict1, oredict2);
	}

	protected static void addSimpleAlloyRecipe(@Nonnull final MMDMaterial material, @Nonnull final int outputQty, @Nonnull final String oredict1In, @Nonnull final String oredict2In) {
		final String oredict1 = StringUtils.capitalize(oredict1In);
		final String oredict2 = StringUtils.capitalize(oredict2In);

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.BLEND), outputQty), Oredicts.DUST + oredict1, Oredicts.DUST + oredict2));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(material.getItem(Names.SMALLBLEND), outputQty), Oredicts.DUST_TINY + oredict1, Oredicts.DUST_TINY + oredict2));
	}
}
