package com.synthchris666.synthchrismod.util;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.client.entity.render.ChickenGhoulRender;
import com.synthchris666.synthchrismod.client.entity.render.RoosterEntityRender;
import com.synthchris666.synthchrismod.client.entity.render.ThiccenEntityRender;
import com.synthchris666.synthchrismod.client.gui.EggChestScreen;
import com.synthchris666.synthchrismod.init.ModContainerTypes;
import com.synthchris666.synthchrismod.init.ModEntityTypes;
import com.synthchris666.synthchrismod.init.ObjectInitNew;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void ClientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.EGG_CHEST.get(), EggChestScreen::new);
		RenderTypeLookup.setRenderLayer(ObjectInitNew.CHERRY_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.MAGIC_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.BLEEDING_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.GILDED_SAPLING.get(), RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(ObjectInitNew.CHERRY_CROP.get(), RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(ObjectInitNew.MAGIC_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.CHERRY_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.BLEEDING_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.GILDED_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.CHERRY_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.MAGIC_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.BLEEDING_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ObjectInitNew.GILDED_TRAPDOOR.get(), RenderType.getCutout());
		
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.THICCEN_ENTITY.get(), ThiccenEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROOSTER_ENTITY.get(), RoosterEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHICKEN_GHOUL.get(), ChickenGhoulRender::new);
	}
}