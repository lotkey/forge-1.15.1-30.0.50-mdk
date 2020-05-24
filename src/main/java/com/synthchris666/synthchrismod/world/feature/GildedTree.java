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

public class GildedTree extends BigTree {

	public static final HugeTreeFeatureConfig GILDED_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ObjectInitNew.GILDED_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ObjectInitNew.GILDED_LEAVES.get().getDefaultState()))).baseHeight(30)
					.crownHeight(30).heightInterval(5).setSapling((IPlantable)ObjectInitNew.GILDED_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return null;
	}

	@Override
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return Feature.DARK_OAK_TREE.withConfiguration(GILDED_TREE_CONFIG);
	}
}
//new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DARK_OAK_LOG), new SimpleBlockStateProvider(DARK_OAK_LEAVES))).baseHeight(6).setSapling((net.minecraftforge.common.IPlantable)Blocks.DARK_OAK_SAPLING).build();