package com.synthchris666.synthchrismod.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.synthchris666.synthchrismod.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class ChickenBiomeProvider extends BiomeProvider{

	private Random rand;
	
	public ChickenBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.CHICKEN_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.CHICKEN_BIOME.get();
	}
	
}
