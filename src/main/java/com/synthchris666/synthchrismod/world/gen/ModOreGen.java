package com.synthchris666.synthchrismod.world.gen;

import com.synthchris666.synthchrismod.init.ObjectInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen 
{
	public static void generateOre() 
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			if(biome == Biomes.PLAINS)
			{
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(20,5,5,25));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ObjectInit.egg_ore.getDefaultState(), 10)).withPlacement(customConfig));
			}
		}
	}
}
