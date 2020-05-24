package com.synthchris666.synthchrismod.util;

import javax.annotation.Nullable;

import com.synthchris666.synthchrismod.init.DimensionInit;

import net.minecraft.world.World;
import net.minecraftforge.common.ModDimension;

public final class MusicUtil {
	public static boolean isModDimension(@Nullable World world) {
		if(world == null) return false;
		ModDimension modDim = world.dimension.getType().getModType();
		return modDim == DimensionInit.CHICKEN_DIM.get() || modDim == DimensionInit.HELL.get();
	}
}
