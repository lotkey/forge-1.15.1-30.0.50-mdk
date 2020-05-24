package com.synthchris666.synthchrismod.objects.blocks;

import java.util.List;
import java.util.Random;

import com.synthchris666.synthchrismod.init.ObjectInitNew;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;

public class EggGrassBlock extends SpreadableSnowyDirtBlock implements IGrowable {
	   public EggGrassBlock(Block.Properties properties) {
	      super(properties);
	   }

	   /**
	    * Whether this IGrowable can grow
	    */
	   public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
	      return worldIn.getBlockState(pos.up()).isAir();
	   }

	   public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
	      return true;
	   }

	   public void grow(ServerWorld p_225535_1_, Random rand, BlockPos pos, BlockState p_225535_4_) {
	      BlockPos blockpos = pos.up();
	      BlockState blockstate = ObjectInitNew.EGG_GRASS_BLOCK.get().getDefaultState();

	      for(int i = 0; i < 128; ++i) {
	         BlockPos blockpos1 = blockpos;
	         int j = 0;

	         while(true) {
	            if (j >= i / 16) {
	               BlockState blockstate2 = p_225535_1_.getBlockState(blockpos1);
	               if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0) {
	                  ((IGrowable)blockstate.getBlock()).grow(p_225535_1_, rand, blockpos1, blockstate2);
	               }

	               if (!blockstate2.isAir()) {
	                  break;
	               }

	               BlockState blockstate1;
	               if (rand.nextInt(8) == 0) {
	                  List<ConfiguredFeature<?, ?>> list = p_225535_1_.getBiome(blockpos1).getFlowers();
	                  if (list.isEmpty()) {
	                     break;
	                  }

	                  ConfiguredFeature<?, ?> configuredfeature = ((DecoratedFeatureConfig)(list.get(0)).config).feature;
	                  blockstate1 = ((FlowersFeature)configuredfeature.feature).getFlowerToPlace(rand, blockpos1, configuredfeature.config);
	               } else {
	                  blockstate1 = blockstate;
	               }

	               if (blockstate1.isValidPosition(p_225535_1_, blockpos1)) {
	                  p_225535_1_.setBlockState(blockpos1, blockstate1, 3);
	               }
	               break;
	            }

	            blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
	            if (p_225535_1_.getBlockState(blockpos1.down()).getBlock() != this || p_225535_1_.getBlockState(blockpos1).isCollisionShapeOpaque(p_225535_1_, blockpos1)) {
	               break;
	            }

	            ++j;
	         }
	      }

	   }
	}