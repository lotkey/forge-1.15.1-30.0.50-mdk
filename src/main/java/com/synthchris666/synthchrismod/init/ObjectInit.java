package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.SynthChrisMod.SynthChrisItemGroup;
import com.synthchris666.synthchrismod.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
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
public class ObjectInit 
{
	public static final Block egg_block = null;
	public static final Block egg_ore = null;
	public static final Block special_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5f,15f).sound(SoundType.STONE)).setRegistryName("egg_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f,15f).sound(SoundType.STONE)).setRegistryName("egg_ore"));
		event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(25).slipperiness(1.2f).speedFactor(0.7f).noDrops()).setRegistryName("special_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(egg_block, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_block"));
		event.getRegistry().register(new BlockItem(egg_ore, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_ore"));
		event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("special_block"));
	}
}
