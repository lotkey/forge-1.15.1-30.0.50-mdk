package com.synthchris666.synthchrismod.util;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void RegisterDimensions(final RegisterDimensionsEvent event) {
		if(DimensionType.byName(SynthChrisMod.CHICKEN_DIM_TYPE) == null) {
			DimensionManager.registerDimension(SynthChrisMod.CHICKEN_DIM_TYPE, DimensionInit.CHICKEN_DIM.get(), null, true);
		}
		if(DimensionType.byName(SynthChrisMod.HELL_DIM_TYPE) == null) {
			DimensionManager.registerDimension(SynthChrisMod.HELL_DIM_TYPE, DimensionInit.HELL.get(), null, true);
		}
		
		SynthChrisMod.LOGGER.info("Dimensions registered");
	}
}
