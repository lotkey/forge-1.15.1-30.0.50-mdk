package com.synthchris666.synthchrismod.world.feature;

import java.util.Random;

import com.synthchris666.synthchrismod.init.ObjectInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class CherryTree extends Tree {

	public static final TreeFeatureConfig CHERRY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ObjectInitNew.CHERRY_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(ObjectInitNew.CHERRY_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(1, 1))).baseHeight(10).heightRandA(3).foliageHeight(3).ignoreVines()
					.setSapling((IPlantable) ObjectInitNew.CHERRY_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(CHERRY_TREE_CONFIG);
	}
}
