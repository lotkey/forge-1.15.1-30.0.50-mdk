package com.synthchris666.synthchrismod.client.entity.render;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.client.entity.model.ThiccenEntityModel;
import com.synthchris666.synthchrismod.entities.ThiccenEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ThiccenEntityRender extends MobRenderer<ThiccenEntity, ThiccenEntityModel<ThiccenEntity>>{

	protected static final ResourceLocation TEXTURE = new ResourceLocation(SynthChrisMod.MOD_ID, "textures/entity/thiccen_entity.png");

	public ThiccenEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ThiccenEntityModel<ThiccenEntity>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(ThiccenEntity entity) {
		return TEXTURE;
	}
}
