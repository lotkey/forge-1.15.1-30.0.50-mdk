package com.synthchris666.synthchrismod.world.gen;

import com.synthchris666.synthchrismod.init.BiomeInit;
import com.synthchris666.synthchrismod.init.ObjectInitNew;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen {
	public static void generateOre() {
		ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 5, 60));
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == BiomeInit.CHICKEN_BIOME.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EGG_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.MULTI_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EGG_STONE.get().getDefaultState(), 10))
								.withPlacement(
										Placement.COUNT_RANGE.configure(new CountRangeConfig(20000, 5, 5, 100))));
			}
			if (biome == BiomeInit.HELL.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.DIAMOND_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.GOLD_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EMERALD_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.LAPIS_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.IRON_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.REDSTONE_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EGG_INGOT_BLOCK_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EGG_STONE.get().getDefaultState(), 10))
								.withPlacement(
										Placement.COUNT_RANGE.configure(new CountRangeConfig(20000, 5, 5, 100))));
			}

			if (biome == BiomeInit.OASIS.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EGG_BRICKS.get().getDefaultState(), 10))
								.withPlacement(customConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ObjectInitNew.EGG_STONE.get().getDefaultState(), 10))
								.withPlacement(
										Placement.COUNT_RANGE.configure(new CountRangeConfig(20000, 5, 5, 100))));
			}
		}
	}
}
