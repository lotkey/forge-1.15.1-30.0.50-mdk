package com.synthchris666.synthchrismod.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class OasisBiome extends Biome {

	public OasisBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 2500000, 20, 30));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 2500000, 20, 30));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 2500000, 20, 30));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 2500000, 20, 30));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(14285715f)));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.25f)));
		
		//DefaultBiomeFeatures.addDesertFeatures(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addOakTreesFlowersGrass(this);
	}
	
	@Override
	public int getGrassColor(double posX, double posZ) {
		return 0x2FA985;
	}
	
	@Override
	public int getFoliageColor() {
		return 0x005881;
	}
}