package com.synthchris666.synthchrismod.client.entity.render;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.client.entity.model.RoosterEntityModel;
import com.synthchris666.synthchrismod.entities.RoosterEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RoosterEntityRender extends MobRenderer<RoosterEntity, RoosterEntityModel<RoosterEntity>>{

	protected static final ResourceLocation TEXTURE = new ResourceLocation(SynthChrisMod.MOD_ID, "textures/entity/rooster_entity.png");

	public RoosterEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RoosterEntityModel<RoosterEntity>(), 0.3f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(RoosterEntity entity) {
		return TEXTURE;
	}
	
	protected float handleRotationFloat(RoosterEntity livingBase, float partialTicks) {
	      float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
	      float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
	      return (MathHelper.sin(f) + 1.0F) * f1;
	   }
}
