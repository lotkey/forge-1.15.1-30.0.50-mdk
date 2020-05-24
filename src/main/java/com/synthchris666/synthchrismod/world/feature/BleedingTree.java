package com.synthchris666.synthchrismod.world.feature;

import java.util.Random;

import com.synthchris666.synthchrismod.init.ObjectInitNew;

import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.common.IPlantable;

public class BleedingTree extends BigTree {

	public static final HugeTreeFeatureConfig BLEEDING_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ObjectInitNew.BLEEDING_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ObjectInitNew.BLEEDING_LEAVES.get().getDefaultState()))).baseHeight(20)
					.crownHeight(20).heightInterval(5).setSapling((IPlantable)ObjectInitNew.BLEEDING_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return null;
	}

	@Override
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return Feature.MEGA_JUNGLE_TREE.withConfiguration(BLEEDING_TREE_CONFIG);
	}
}
//new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DARK_OAK_LOG), new SimpleBlockStateProvider(DARK_OAK_LEAVES))).baseHeight(6).setSapling((net.minecraftforge.common.IPlantable)Blocks.DARK_OAK_SAPLING).build();