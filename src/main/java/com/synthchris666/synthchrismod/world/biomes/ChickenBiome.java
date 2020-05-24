package com.synthchris666.synthchrismod.world.biomes;

import com.synthchris666.synthchrismod.world.feature.CherryTree;
import com.synthchris666.synthchrismod.world.feature.MagicTree;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class ChickenBiome extends Biome {

	public ChickenBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 2500000, 20, 30));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(ModEntityTypes.THICCEN_ENTITY.get(), 2000, 20, 30));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(14285715f)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.02f)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(CherryTree.CHERRY_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.0001f, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(MagicTree.MAGIC_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.0001f, 1))));
		
		//DefaultBiomeFeatures.addDesertFeatures(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addLakes(this);
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		int randInt = (int)(Math.random() * (posX + posZ)) / 5000;
		return 16757248 + randInt;
	}
	
	@Override
	public int getFoliageColor() {
		//return (int)(Math.random() * 15353088);
		int blue = 0;
		int red = 16711680;
		int green = (int)(Math.random() * 255) * 256;		
		return blue + red + green;
	}

}