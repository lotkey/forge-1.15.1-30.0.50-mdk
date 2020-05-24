package com.synthchris666.synthchrismod.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.synthchris666.synthchrismod.entities.ThiccenEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThiccenEntityModel<T extends ThiccenEntity> extends AgeableModel<T> {
	//private final ModelRenderer VoxelShapes;
	private final ModelRenderer head;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer bill;
	private final ModelRenderer chin;
	private final ModelRenderer rightWing;
	private final ModelRenderer leftWing;
	private final ModelRenderer body;

	public ThiccenEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		//VoxelShapes = new ModelRenderer(this);
		//VoxelShapes.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
	    head.setTextureOffset(14,28).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, 0.0F);
	    head.setRotationPoint(0.0F, 9.0F, -7.0F);
		//VoxelShapes.addChild(head);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(0.0F, 16.0F, 0.0F);
		//VoxelShapes.addChild(leftLeg);
		//leftLeg.setTextureOffset(28, 28).addBox(0.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		leftLeg.setTextureOffset(28, 28).addBox(-1.0F, 3.0F, -3.0F, 3.0F, 5.0F, 3.0F);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-3.0F, 16.0F, 0.0F);
		//VoxelShapes.addChild(rightLeg);
		//rightLeg.setTextureOffset(25, 36).addBox(-3.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		rightLeg.setTextureOffset(25, 36).addBox(-1.0F, 3.0F, -3.0F, 3.0F, 5.0F, 3.0F);

		bill = new ModelRenderer(this);
		bill.setRotationPoint(0.0F, 9.0F, -7.0F);
		//VoxelShapes.addChild(bill);
		bill.setTextureOffset(0, 10).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F);

		chin = new ModelRenderer(this);
		chin.setRotationPoint(0.0F, 9.0F, -7.0F);
		//VoxelShapes.addChild(chin);
		chin.setTextureOffset(8, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F);

		rightWing = new ModelRenderer(this);
		rightWing.setRotationPoint(0.0F, 24.0F, 0.0F); //16
		//VoxelShapes.addChild(rightWing); //-9
		rightWing.setTextureOffset(0, 28).addBox(-7.0F, -17.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(0.0F, 24.0F, 0.0F);
		//VoxelShapes.addChild(leftWing);
		leftWing.setTextureOffset(0, 0).addBox(6.0F, -17.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 10.0F, 0.0F); //16
		//VoxelShapes.addChild(body); //-9
		body.setTextureOffset(0, 0).addBox(-6.0F, -3.0F, -8.0F, 12.0F, 12.0F, 16.0F, 0.0F, false);
	}
	
	protected Iterable<ModelRenderer> getHeadParts() {
	      return ImmutableList.of(this.head, this.bill, this.chin);
	   }

	   protected Iterable<ModelRenderer> getBodyParts() {
		   return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
	   }
	   
	   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		   if(this.isChild) {
			    this.head.setRotationPoint(0.0F, 12.0F, -7.0F);	
				this.bill.setRotationPoint(0.0F, 12.0F, -7.0F);	
				this.chin.setRotationPoint(0.0F, 12.0F, -7.0F);				   
		   }
		   else {
			    this.head.setRotationPoint(0.0F, 9.0F, -7.0F);	
				this.bill.setRotationPoint(0.0F, 9.0F, -7.0F);	
				this.chin.setRotationPoint(0.0F, 9.0F, -7.0F);	   
		   }
	   }

	   /**
	    * Sets this entity's model rotation angles
	    */
	   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		   this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		      this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		      this.bill.rotateAngleX = this.head.rotateAngleX;
		      this.bill.rotateAngleY = this.head.rotateAngleY;
		      this.chin.rotateAngleX = this.head.rotateAngleX;
		      this.chin.rotateAngleY = this.head.rotateAngleY;
		      //this.body.rotateAngleX = ((float)Math.PI / 2F);
		      this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		      this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		      //this.rightWing.rotateAngleZ = -ageInTicks;
		      //this.leftWing.rotateAngleZ = -ageInTicks;
	   }

}
