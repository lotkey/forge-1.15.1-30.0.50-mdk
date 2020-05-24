package com.synthchris666.synthchrismod.world.biomes;

import com.synthchris666.synthchrismod.world.feature.BleedingTree;
import com.synthchris666.synthchrismod.world.feature.GildedTree;
import com.synthchris666.synthchrismod.world.feature.MagicTree;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class HellBiome extends Biome {

	public HellBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		final BlockClusterFeatureConfig WITHER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.WITHER_ROSE.getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
		
		for(int i = 0; i < 100; i++) {
			this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.ZOMBIE, 1000000, 200, 1000));
			this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SKELETON, 1000000, 200, 1000));
			this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WITHER_SKELETON, 1000000, 200, 1000));
			this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.GHAST, 1000000, 200, 1000));
			this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1000000, 200, 1000));
		}
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(14285715f)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.02f)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.MEGA_JUNGLE_TREE.withConfiguration(BleedingTree.BLEEDING_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(30, 0.0001f, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.MEGA_JUNGLE_TREE.withConfiguration(GildedTree.GILDED_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(30, 0.0001f, 1))));

	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(WITHER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
		
	    //DefaultBiomeFeatures.addDesertFeatures(this);
		//DefaultBiomeFeatures.addOakTreesFlowersGrass(this);
		DefaultBiomeFeatures.addGrass(this);
		//DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addStructures(this);
		
		
	}

	@Override
	public int getGrassColor(double posX, double posZ) {
		return 15963;
	}
}