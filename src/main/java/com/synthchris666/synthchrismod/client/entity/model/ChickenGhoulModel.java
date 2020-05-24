package com.synthchris666.synthchrismod.client.entity.model;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.synthchris666.synthchrismod.entities.ChickenGhoul;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ChickenGhoulModel<T extends ChickenGhoul> extends EntityModel<T> {
	private final ModelRenderer VoxelShapes;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer chin;
	private final ModelRenderer beak;

	public ChickenGhoulModel() {
		textureWidth = 64;
		textureHeight = 64;

		VoxelShapes = new ModelRenderer(this);
		VoxelShapes.setRotationPoint(2.0F, 24.0F, 0.0F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(-2.0F, -50.0F, 0.0F);
		VoxelShapes.addChild(body);
		body.setTextureOffset(16, 0).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-2.0F, -60.0F, 0.0F);
		VoxelShapes.addChild(head);
		head.setTextureOffset(16, 16).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(3.0F, -55.0F, 0.0F);
		VoxelShapes.addChild(rightArm);
		rightArm.setTextureOffset(24, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-7.0F, -55.0F, 0.0F);
		VoxelShapes.addChild(leftArm);
		leftArm.setTextureOffset(16, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(0.0F, -44.0F, 0.0F);
		VoxelShapes.addChild(rightLeg);
		rightLeg.setTextureOffset(8, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 44.0F, 2.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-4.0F, -44.0F, 0.0F);
		VoxelShapes.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 44.0F, 2.0F, 0.0F, false);

		chin = new ModelRenderer(this);
		chin.setRotationPoint(-2.0F, -60.0F, 0.0F);
		VoxelShapes.addChild(chin);
		chin.setTextureOffset(8, 4).addBox(-1.0F, 2.0F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		beak = new ModelRenderer(this);
		beak.setRotationPoint(-2.0F, -60.0F, 0.0F);
		VoxelShapes.addChild(beak);
		beak.setTextureOffset(8, 0).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		VoxelShapes.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.chin.rotateAngleX = this.head.rotateAngleX;
		this.chin.rotateAngleY = this.head.rotateAngleY;
		this.beak.rotateAngleX = this.head.rotateAngleX;
		this.beak.rotateAngleY = this.head.rotateAngleY;
		//this.Body.rotateAngleZ = ((float)Math.PI / 2F);
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
}