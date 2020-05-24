package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.SynthChrisMod.SynthChrisItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, SynthChrisMod.MOD_ID);

	public static final RegistryObject<Item> CHERRIES = ITEMS.register("cherries", () -> new Item(new Item.Properties().group(SynthChrisItemGroup.instance).food(new Food.Builder().hunger(3).build())));

	public static final RegistryObject<Item> CHERRY_SEEDS = ITEMS.register("cherry_seeds", () -> new BlockItem(ObjectInitNew.CHERRY_CROP.get(), new Item.Properties().group(SynthChrisItemGroup.instance)));

	public static final RegistryObject<Item> EGG_BRICK = ITEMS.register("egg_brick", () -> new Item(new Item.Properties().group(SynthChrisItemGroup.instance)));

	public static final RegistryObject<Item> EGG_STONE_SWORD = ITEMS.register("egg_stone_sword", () -> new SwordItem(ItemTier.STONE,3,-2.4f,new Item.Properties().group(SynthChrisItemGroup.instance)));
	public static final RegistryObject<Item> EGG_STONE_PICKAXE = ITEMS.register("egg_stone_pickaxe", () -> new PickaxeItem(ItemTier.STONE,1,-2.8f,new Item.Properties().group(SynthChrisItemGroup.instance)));
	public static final RegistryObject<Item> EGG_STONE_AXE = ITEMS.register("egg_stone_axe", () -> new AxeItem(ItemTier.STONE,7,-3.2f,new Item.Properties().group(SynthChrisItemGroup.instance)));
	public static final RegistryObject<Item> EGG_STONE_HOE = ITEMS.register("egg_stone_hoe", () -> new HoeItem(ItemTier.STONE,-2.0f,new Item.Properties().group(SynthChrisItemGroup.instance)));
	public static final RegistryObject<Item> EGG_STONE_SHOVEL = ITEMS.register("egg_stone_shovel", () -> new ShovelItem(ItemTier.STONE,2,-3f,new Item.Properties().group(SynthChrisItemGroup.instance)));

	//public static final RegistryObject<Item> CHICKEN_BLOCK = ITEMS.register("chicken_block_item", () -> new BlockItem(new Block(Block.Properties.from(Blocks.SLIME_BLOCK)).setRegistryName("chicken_block"), new Item.Properties().group(SynthChrisItemGroup.instance).food(new Food.Builder().hunger(14).saturation(1.2f).build())));
}
