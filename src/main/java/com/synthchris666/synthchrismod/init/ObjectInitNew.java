package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.objects.blocks.BlockQuarry;
import com.synthchris666.synthchrismod.objects.blocks.CherryCrop;
import com.synthchris666.synthchrismod.objects.blocks.EggChestBlock;
import com.synthchris666.synthchrismod.objects.blocks.EggGrassBlock;
import com.synthchris666.synthchrismod.objects.blocks.ModDoor;
import com.synthchris666.synthchrismod.objects.blocks.ModPressurePlateBlock;
import com.synthchris666.synthchrismod.objects.blocks.ModSaplingBlock;
import com.synthchris666.synthchrismod.objects.blocks.ModTrapdoor;
import com.synthchris666.synthchrismod.objects.blocks.ModWoodButtonBlock;
import com.synthchris666.synthchrismod.objects.blocks.SpecialBlock;
import com.synthchris666.synthchrismod.world.feature.BleedingTree;
import com.synthchris666.synthchrismod.world.feature.CherryTree;
import com.synthchris666.synthchrismod.world.feature.GildedTree;
import com.synthchris666.synthchrismod.world.feature.MagicTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ObjectInitNew {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			SynthChrisMod.MOD_ID);
	
	public static final RegistryObject<Block> EGG_ORE = BLOCKS.register("egg_ore", () -> new Block(Block.Properties.from(Blocks.DIAMOND_ORE)));
	public static final RegistryObject<Block> EGG_INGOT_BLOCK = BLOCKS.register("egg_ingot_block", () -> new Block(Block.Properties.from(Blocks.DIAMOND_BLOCK)));
	public static final RegistryObject<Block> MULTI_ORE = BLOCKS.register("multi_ore", () -> new Block(Block.Properties.from(Blocks.DIAMOND_ORE)));
	public static final RegistryObject<Block> CHICKEN_TOTEM = BLOCKS.register("chicken_totem", () -> new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(25)
			.slipperiness(1.2f).speedFactor(0.7f)));
	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", () -> new BlockQuarry(Block.Properties.from(Blocks.IRON_BLOCK)));
	
	public static final RegistryObject<Block> EGG_BLOCK = BLOCKS.register("egg_block", () -> new Block(Block.Properties.from(Blocks.BONE_BLOCK)));

	public static final RegistryObject<Block> EGG_STONE = BLOCKS.register("egg_stone", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final RegistryObject<Block> EGG_STONE_STAIRS = BLOCKS.register("egg_stone_stairs",
			() -> new StairsBlock(() -> ObjectInitNew.EGG_STONE.get().getDefaultState(),
					Block.Properties.from(Blocks.STONE_STAIRS)));
	public static final RegistryObject<Block> EGG_STONE_FENCE = BLOCKS.register("egg_stone_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.NETHER_BRICK_FENCE)));
	public static final RegistryObject<Block> EGG_STONE_PRESSURE_PLATE = BLOCKS.register("egg_stone_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.from(Blocks.STONE_PRESSURE_PLATE)));
	public static final RegistryObject<Block> EGG_STONE_SLAB = BLOCKS.register("egg_stone_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.STONE_SLAB)));
	public static final RegistryObject<Block> EGG_STONE_WALL = BLOCKS.register("egg_stone_wall", () -> new WallBlock(Block.Properties.from(Blocks.COBBLESTONE_WALL)));
	
	public static final RegistryObject<Block> EGG_BRICKS = BLOCKS.register("egg_bricks", () -> new Block(Block.Properties.from(Blocks.NETHER_BRICKS)));
	public static final RegistryObject<Block> EGG_BRICK_STAIRS = BLOCKS.register("egg_brick_stairs",
			() -> new StairsBlock(() -> ObjectInitNew.EGG_BRICKS.get().getDefaultState(),
					Block.Properties.from(Blocks.NETHER_BRICK_STAIRS)));
	public static final RegistryObject<Block> EGG_BRICK_FENCE = BLOCKS.register("egg_brick_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.NETHER_BRICK_FENCE)));
	public static final RegistryObject<Block> EGG_BRICK_WALL = BLOCKS.register("egg_brick_wall", () -> new WallBlock(Block.Properties.from(Blocks.COBBLESTONE_WALL)));
	public static final RegistryObject<Block> EGG_BRICK_SLAB = BLOCKS.register("egg_brick_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.STONE_SLAB)));

	public static final RegistryObject<Block> EGG_CHEST = BLOCKS.register("egg_chest",
			() -> new EggChestBlock(Block.Properties.from(Blocks.STONE)));

	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES).lightValue(15)));
	public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling",
			() -> new ModSaplingBlock(() -> new CherryTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs",
			() -> new StairsBlock(() -> ObjectInitNew.CHERRY_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button",
			() -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
	public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door", () -> new ModDoor(Block.Properties.from(Blocks.DARK_OAK_DOOR)));
	public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new ModTrapdoor(Block.Properties.from(Blocks.DARK_OAK_TRAPDOOR)));

	public static final RegistryObject<Block> MAGIC_PLANKS = BLOCKS.register("magic_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> MAGIC_LOG = BLOCKS.register("magic_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> MAGIC_LEAVES = BLOCKS.register("magic_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES).lightValue(15)));
	public static final RegistryObject<Block> MAGIC_SAPLING = BLOCKS.register("magic_sapling",
			() -> new ModSaplingBlock(() -> new MagicTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> MAGIC_STAIRS = BLOCKS.register("magic_stairs",
			() -> new StairsBlock(() -> ObjectInitNew.MAGIC_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> MAGIC_FENCE = BLOCKS.register("magic_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> MAGIC_BUTTON = BLOCKS.register("magic_button",
			() -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> MAGIC_PRESSURE_PLATE = BLOCKS.register("magic_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
	public static final RegistryObject<Block> MAGIC_SLAB = BLOCKS.register("magic_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> MAGIC_DOOR = BLOCKS.register("magic_door", () -> new ModDoor(Block.Properties.from(Blocks.DARK_OAK_DOOR)));
	public static final RegistryObject<Block> MAGIC_TRAPDOOR = BLOCKS.register("magic_trapdoor", () -> new ModTrapdoor(Block.Properties.from(Blocks.DARK_OAK_TRAPDOOR)));
	
	public static final RegistryObject<Block> BLEEDING_LOG = BLOCKS.register("bleeding_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	public static final RegistryObject<Block> BLEEDING_LEAVES = BLOCKS.register("bleeding_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.DARK_OAK_LEAVES)));
	public static final RegistryObject<Block> BLEEDING_SAPLING = BLOCKS.register("bleeding_sapling",
			() -> new ModSaplingBlock(() -> new BleedingTree(), Block.Properties.from(Blocks.DARK_OAK_SAPLING)));
	public static final RegistryObject<Block> BLEEDING_PLANKS = BLOCKS.register("bleeding_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> BLEEDING_STAIRS = BLOCKS.register("bleeding_stairs",
			() -> new StairsBlock(() -> ObjectInitNew.BLEEDING_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> BLEEDING_FENCE = BLOCKS.register("bleeding_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> BLEEDING_BUTTON = BLOCKS.register("bleeding_button",
			() -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> BLEEDING_PRESSURE_PLATE = BLOCKS.register("bleeding_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
	public static final RegistryObject<Block> BLEEDING_SLAB = BLOCKS.register("bleeding_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> BLEEDING_DOOR = BLOCKS.register("bleeding_door", () -> new ModDoor(Block.Properties.from(Blocks.DARK_OAK_DOOR)));
	public static final RegistryObject<Block> BLEEDING_TRAPDOOR = BLOCKS.register("bleeding_trapdoor", () -> new ModTrapdoor(Block.Properties.from(Blocks.DARK_OAK_TRAPDOOR)));

	public static final RegistryObject<Block> GILDED_LOG = BLOCKS.register("gilded_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	public static final RegistryObject<Block> GILDED_LEAVES = BLOCKS.register("gilded_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.DARK_OAK_LEAVES)));
	public static final RegistryObject<Block> GILDED_SAPLING = BLOCKS.register("gilded_sapling",
			() -> new ModSaplingBlock(() -> new GildedTree(), Block.Properties.from(Blocks.DARK_OAK_SAPLING)));
	public static final RegistryObject<Block> GILDED_PLANKS = BLOCKS.register("gilded_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> GILDED_STAIRS = BLOCKS.register("gilded_stairs",
			() -> new StairsBlock(() -> ObjectInitNew.GILDED_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> GILDED_FENCE = BLOCKS.register("gilded_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> GILDED_BUTTON = BLOCKS.register("gilded_button",
			() -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
	public static final RegistryObject<Block> GILDED_PRESSURE_PLATE = BLOCKS.register("gilded_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
	public static final RegistryObject<Block> GILDED_SLAB = BLOCKS.register("gilded_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> GILDED_DOOR = BLOCKS.register("gilded_door", () -> new ModDoor(Block.Properties.from(Blocks.DARK_OAK_DOOR)));
	public static final RegistryObject<Block> GILDED_TRAPDOOR = BLOCKS.register("gilded_trapdoor", () -> new ModTrapdoor(Block.Properties.from(Blocks.DARK_OAK_TRAPDOOR)));
	
	public static final RegistryObject<Block> CHERRY_CROP = BLOCKS.register("cherry_crop", () -> new CherryCrop(Block.Properties.from(Blocks.WHEAT)));
	
	public static final RegistryObject<Block> EGG_GRASS_BLOCK = BLOCKS.register("egg_grass_block", () -> new EggGrassBlock(Block.Properties.from(Blocks.GRASS_BLOCK)));
	
	public static final RegistryObject<Block> DIAMOND_BLOCK_ORE = BLOCKS.register("diamond_block_ore", () -> new Block(Block.Properties.from(Blocks.DIAMOND_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> IRON_BLOCK_ORE = BLOCKS.register("iron_block_ore", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> COAL_BLOCK_ORE = BLOCKS.register("coal_block_ore", () -> new Block(Block.Properties.from(Blocks.COAL_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> GOLD_BLOCK_ORE = BLOCKS.register("gold_block_ore", () -> new Block(Block.Properties.from(Blocks.GOLD_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> EMERALD_BLOCK_ORE = BLOCKS.register("emerald_block_ore", () -> new Block(Block.Properties.from(Blocks.EMERALD_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> LAPIS_BLOCK_ORE = BLOCKS.register("lapis_block_ore", () -> new Block(Block.Properties.from(Blocks.LAPIS_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> EGG_INGOT_BLOCK_ORE = BLOCKS.register("egg_ingot_block_ore", () -> new Block(Block.Properties.from(Blocks.DIAMOND_BLOCK).lightValue(15)));
	public static final RegistryObject<Block> REDSTONE_BLOCK_ORE = BLOCKS.register("redstone_block_ore", () -> new Block(Block.Properties.from(Blocks.REDSTONE_BLOCK).lightValue(15)));
	
	public static final RegistryObject<Block> CHICKEN_BLOCK = BLOCKS.register("chicken_block", () -> new SlimeBlock(Block.Properties.from(Blocks.SLIME_BLOCK)));
	public static final RegistryObject<Block> COOKED_CHICKEN_BLOCK = BLOCKS.register("cooked_chicken_block", () -> new SlimeBlock(Block.Properties.from(Blocks.SLIME_BLOCK)));
	public static final RegistryObject<Block> FEATHER_BLOCK = BLOCKS.register("feather_block", () -> new SlimeBlock(Block.Properties.from(Blocks.SLIME_BLOCK)));
}
