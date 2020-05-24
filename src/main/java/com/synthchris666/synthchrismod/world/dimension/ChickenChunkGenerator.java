package com.synthchris666.synthchrismod.world.dimension;

import java.util.Random;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class ChickenChunkGenerator extends NoiseChunkGenerator<ChickenGenSettings> {
	
   public ChickenChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, ChickenGenSettings settingsIn) {
      super(worldIn, biomeProviderIn, 8, 4, 128, settingsIn, true);
   }

   protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
      double d0 = 1368.824D;
      double d1 = 684.412D;
      double d2 = 17.110300000000002D;
      double d3 = 4.277575000000001D;
      int i = 64;
      int j = -3000;
      //this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, 1368.824D, 684.412D, 17.110300000000002D, 4.277575000000001D, 64, -3000);
      this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, 1368.824D, 684.412D, 17.110300000000002D, 4.277575000000001D, 64, -3000);
   }

   protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
      return new double[]{(double)this.biomeProvider.func_222365_c(noiseX, noiseZ), 0.0D};
   }

   protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
      return 8.0D - p_222545_1_;
   }

   protected double func_222551_g() {
      return (double)((int)super.func_222551_g() / 2);
   }

   protected double func_222553_h() {
      return 8.0D;
   }

   public int getGroundHeight() {
      return 50;
   }
   
   public int getSeaLevel() {
      return 0;
   }
   
   @Override
   protected void makeBedrock(IChunk chunkIn, Random rand) {
   }
}