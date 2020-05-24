package com.synthchris666.synthchrismod.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.synthchris666.synthchrismod.entities.RoosterEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoosterEntityModel<T extends RoosterEntity> extends AgeableModel<T> {
	   private final ModelRenderer head;
	   private final ModelRenderer body;
	   private final ModelRenderer rightLeg;
	   private final ModelRenderer leftLeg;
	   private final ModelRenderer rightWing;
	   private final ModelRenderer leftWing;
	   private final ModelRenderer bill;
	   private final ModelRenderer chin;
	   private final ModelRenderer tail;
	   private final ModelRenderer mohawk;

	public RoosterEntityModel() {
	      int i = 16;
	      this.head = new ModelRenderer(this, 0, 0);
	      this.head.addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, 0.0F);
	      this.head.setRotationPoint(0.0F, 15.0F, -4.0F);
	      this.bill = new ModelRenderer(this, 14, 0);
	      this.bill.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F);
	      this.bill.setRotationPoint(0.0F, 15.0F, -4.0F);
	      this.chin = new ModelRenderer(this, 14, 4);
	      this.chin.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F);
	      this.chin.setRotationPoint(0.0F, 15.0F, -4.0F);
	      this.body = new ModelRenderer(this, 0, 9);
	      this.body.addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F);
	      this.body.setRotationPoint(0.0F, 16.0F, 0.0F);
	      this.rightLeg = new ModelRenderer(this, 26, 0);
	      this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F);
	      this.rightLeg.setRotationPoint(-2.0F, 19.0F, 1.0F);
	      this.leftLeg = new ModelRenderer(this, 26, 0);
	      this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F);
	      this.leftLeg.setRotationPoint(1.0F, 19.0F, 1.0F);
	      this.rightWing = new ModelRenderer(this, 24, 13);
	      this.rightWing.addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F);
	      this.rightWing.setRotationPoint(-4.0F, 13.0F, 0.0F);
	      this.leftWing = new ModelRenderer(this, 24, 13);
	      this.leftWing.addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F);
	      this.leftWing.setRotationPoint(4.0F, 13.0F, 0.0F);
	      this.tail = new ModelRenderer(this, 45, 11);
	      this.tail.setRotationPoint(0F, 0F, 0F);
	      this.tail.addBox(0.0F, 10.0F, 2.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
	      this.mohawk = new ModelRenderer(this);
	      this.mohawk.setTextureOffset(51, 22).addBox(0.0F, -6.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
	      this.mohawk.setRotationPoint(0.0f, 13.0f, -4.0f);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
	      return ImmutableList.of(this.head, this.bill, this.chin, this.mohawk);
	   }

	   protected Iterable<ModelRenderer> getBodyParts() {
		   return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing, this.tail);
	   }
	   
	   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		   if(entityIn.isSitting()) {
			   this.head.setRotationPoint(0.0F, 20.0F, -4.0F);
			   this.bill.setRotationPoint(0.0F, 20.0F, -4.0F);
			   this.chin.setRotationPoint(0.0F, 20.0F, -4.0F);
			   this.body.setRotationPoint(0, 21, 0);
			   this.rightWing.setRotationPoint(-4.0F, 18.0F, 0.0F);
			   this.leftWing.setRotationPoint(4.0F, 18.0F, 0.0F);
			   this.tail.setRotationPoint(0F, 5F, 0F);
			   this.mohawk.setRotationPoint(0.0f, 18.0f, -4.0f);
		   }else {
			   this.head.setRotationPoint(0.0F, 15.0F, -4.0F);
			   this.bill.setRotationPoint(0.0F, 15.0F, -4.0F);
			   this.chin.setRotationPoint(0.0F, 15.0F, -4.0F);
			   this.body.setRotationPoint(0F, 16F, 0F);
			   this.rightWing.setRotationPoint(-4.0F, 13.0F, 0.0F);
			   this.leftWing.setRotationPoint(4.0F, 13.0F, 0.0F);
			   this.tail.setRotationPoint(0, 0, 0);
			   this.mohawk.setRotationPoint(0.0f, 13.0f, -4.0f);
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
		      this.mohawk.rotateAngleX = this.head.rotateAngleX;
		      this.mohawk.rotateAngleY = this.head.rotateAngleY;
		      this.body.rotateAngleX = ((float)Math.PI / 2F);
		      this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		      this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		      this.rightWing.rotateAngleZ = ageInTicks;
		      this.leftWing.rotateAngleZ = -ageInTicks;
	   }
}
