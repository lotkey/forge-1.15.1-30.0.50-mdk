package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.SynthChrisMod.SynthChrisItemGroup;
import com.synthchris666.synthchrismod.objects.blocks.BlockQuarry;
import com.synthchris666.synthchrismod.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(SynthChrisMod.MOD_ID)
@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.MOD)
public class ObjectInit {
	//public static final Block multi_ore = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		//event.getRegistry().register(new Block(Block.Properties.from(Blocks.DIAMOND_ORE)).setRegistryName("multi_ore"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		//event.getRegistry().register(new BlockItem(multi_ore, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("multi_ore"));
	}
}
