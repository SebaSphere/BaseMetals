package com.mcmoddev.basemetals.proxy;

import com.mcmoddev.basemetals.BaseMetals;
import com.mcmoddev.basemetals.init.Blocks;
import com.mcmoddev.basemetals.init.Fluids;
import com.mcmoddev.basemetals.init.Items;
import com.mcmoddev.lib.client.renderer.RenderCustomArrow;
import com.mcmoddev.lib.client.renderer.RenderCustomBolt;
import com.mcmoddev.lib.entity.EntityCustomArrow;
import com.mcmoddev.lib.entity.EntityCustomBolt;

import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Base Metals Client Proxy
 *
 * @author Jasmine Iwanek
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		for (final String name : Fluids.getFluidBlockRegistry().keySet()) {
			final Block block = Fluids.getFluidBlockByName(name);
			final Item item = Item.getItemFromBlock(block);
			if (!item.getRegistryName().getResourceDomain().equals(BaseMetals.MODID))
				continue;
			final ModelResourceLocation fluidModelLocation = new ModelResourceLocation(item.getRegistryName().getResourceDomain() + ":" + name, "fluid");
			ModelBakery.registerItemVariants(item);
			ModelLoader.setCustomMeshDefinition(item, stack -> fluidModelLocation);
			ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
					return fluidModelLocation;
				}
			});
		}

		RenderingRegistry.registerEntityRenderingHandler(EntityCustomArrow.class, RenderCustomArrow::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityCustomBolt.class, RenderCustomBolt::new);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		if (Loader.isModLoaded("waila")) {
			com.mcmoddev.basemetals.waila.Waila.init();
		}
		/*
		for (MetalMaterial material : Materials.getAllMaterials()) {
			// Items
			registerRenderOuter(material.arrow);
			registerRenderOuter(material.axe);
			registerRenderOuter(material.blend);
			registerRenderOuter(material.boots);
			registerRenderOuter(material.bolt);
			registerRenderOuter(material.bow);
			registerRenderOuter(material.chestplate);
			registerRenderOuter(material.crackhammer);
			registerRenderOuter(material.crossbow);
			registerRenderOuter(material.door);
			registerRenderOuter(material.fishing_rod);
			registerRenderOuter(material.gear);
			registerRenderOuter(material.helmet);
			registerRenderOuter(material.hoe);
			registerRenderOuter(material.horse_armor);
			registerRenderOuter(material.ingot);
			registerRenderOuter(material.leggings);
			registerRenderOuter(material.nugget);
			registerRenderOuter(material.pickaxe);
			registerRenderOuter(material.powder);
			registerRenderOuter(material.rod);
			registerRenderOuter(material.shears);
			registerRenderOuter(material.shield);
			registerRenderOuter(material.shovel);
			registerRenderOuter(material.slab);
			registerRenderOuter(material.smallblend);
			registerRenderOuter(material.smallpowder);
			registerRenderOuter(material.sword);

			// Blocks
			registerRenderOuter(material.bars);
			registerRenderOuter(material.block);
			registerRenderOuter(material.button);
			// registerRenderOuter(material.doorBlock);
			// registerRenderOuter(material.double_slab);
			// registerRenderOuter(material.half_slab);
			registerRenderOuter(material.lever);
			registerRenderOuter(material.ore);
			registerRenderOuter(material.plate);
			registerRenderOuter(material.pressure_plate);
			registerRenderOuter(material.stairs);
			registerRenderOuter(material.trapdoor);
			registerRenderOuter(material.wall);

			// Mekanism
			registerRenderOuter(material.crystal);
			registerRenderOuter(material.shard);
			registerRenderOuter(material.clump);
			registerRenderOuter(material.powder_dirty);

			// IC2
			registerRenderOuter(material.dense_plate);
			registerRenderOuter(material.crushed);
			registerRenderOuter(material.crushed_purified);
			
			// Misc
			registerRenderOuter(Blocks.human_detector);
		}
		*/

		for (final String name : Items.getItemRegistry().keySet()) {
			registerRenderOuter(Items.getItemByName(name));
		}

		for (final String name : Blocks.getBlockRegistry().keySet()) {
			registerRenderOuter(Blocks.getBlockByName(name));
		}
	}

	public void registerRenderOuter(Item item) {
		if (item != null) {
			registerRender(item, Items.getNameOfItem(item));
		}
	}

	public void registerRenderOuter(Block block) {
		if ((block instanceof BlockDoor) || (block instanceof BlockSlab))
			return; // do not add door blocks or slabs

		if (block != null) {
			registerRender(Item.getItemFromBlock(block), Blocks.getNameOfBlock(block));
		}
	}

	public void registerRender(Item item, String name) {
		final ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		if (!item.getRegistryName().getResourceDomain().equals(BaseMetals.MODID))
			return;
		itemModelMesher.register(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), name), "inventory"));
	}
}
