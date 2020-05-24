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

public class MagicTree extends Tree {

	public static final TreeFeatureConfig MAGIC_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ObjectInitNew.MAGIC_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(ObjectInitNew.MAGIC_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 3))).baseHeight(25).heightRandA(50).heightRandB(2).foliageHeight(1).ignoreVines()
					.setSapling((IPlantable) ObjectInitNew.MAGIC_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(MAGIC_TREE_CONFIG);
	}
}
