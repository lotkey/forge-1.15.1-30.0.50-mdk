package com.synthchris666.synthchrismod.client.entity.render;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.client.entity.model.ChickenGhoulModel;
import com.synthchris666.synthchrismod.entities.ChickenGhoul;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ChickenGhoulRender extends MobRenderer<ChickenGhoul, ChickenGhoulModel<ChickenGhoul>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(SynthChrisMod.MOD_ID,
			"textures/entity/chicken_ghoul.png");
	
	public ChickenGhoulRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ChickenGhoulModel<ChickenGhoul>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(ChickenGhoul entity) {
		return TEXTURE;
	}
}