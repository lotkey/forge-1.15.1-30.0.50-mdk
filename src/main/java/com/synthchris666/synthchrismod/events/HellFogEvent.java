package com.synthchris666.synthchrismod.events;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.world.dimension.HellDimension;

import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.FORGE)
public class HellFogEvent {
	@SubscribeEvent
	public static void onFogDensityEvent(EntityViewRenderEvent.FogDensity event) {
		if(event.getRenderer().getActiveRenderInfo().getRenderViewEntity().getEntityWorld().dimension instanceof HellDimension) {
			//System.out.println("Event succesfully fired");
			event.setDensity(.2F);
			event.setCanceled(true);
		}
		else {
			
		}
	}
}
