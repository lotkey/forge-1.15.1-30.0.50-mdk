package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.world.dimension.ChickenModDimension;
import com.synthchris666.synthchrismod.world.dimension.HellModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, SynthChrisMod.MOD_ID);
	
	public static final RegistryObject<ModDimension> CHICKEN_DIM = MOD_DIMENSIONS.register("chicken_dim", () -> new ChickenModDimension());
	public static final RegistryObject<ModDimension> HELL = MOD_DIMENSIONS.register("hell_dim", () -> new HellModDimension());
}
