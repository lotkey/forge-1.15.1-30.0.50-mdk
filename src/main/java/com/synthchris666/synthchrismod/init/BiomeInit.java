package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.world.biomes.ChickenBiome;
import com.synthchris666.synthchrismod.world.biomes.HellBiome;
import com.synthchris666.synthchrismod.world.biomes.OasisBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			SynthChrisMod.MOD_ID);

	public static final RegistryObject<Biome> CHICKEN_BIOME = BIOMES.register("chicken_forest",
			() -> new ChickenBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.001f).temperature(0.5f)
					.waterColor(36767).waterFogColor(12442330).surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.DIRT.getDefaultState(),
									Blocks.SAND.getDefaultState())).category(Category.PLAINS)
					.downfall(0.5f)
					.depth(.5f)
					.parent(null)));
	
	public static final RegistryObject<Biome> HELL = BIOMES.register("hell",
			() -> new HellBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.001f).temperature(-100f)
					.waterColor(3407872).waterFogColor(0).surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.DIRT.getDefaultState(),
									Blocks.SOUL_SAND.getDefaultState())).category(Category.PLAINS)
					.downfall(0.5f)
					.depth(.5f)
					.parent(null)));
	
	public static final RegistryObject<Biome> OASIS = BIOMES.register("oasis", () -> new OasisBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5f).temperature(.5f)
					.waterColor(0x3A82BC).waterFogColor(0).surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.DIRT.getDefaultState(),
									Blocks.SAND.getDefaultState())).category(Category.PLAINS)
					.downfall(0.5f)
					.depth(.5f)
					.parent(null)));
	
	public static void registerBiomes() {
		registerBiome(CHICKEN_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(HELL.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(OASIS.get(), Type.PLAINS, Type.OVERWORLD);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		
		BiomeManager.addSpawnBiome(biome);
	}
}