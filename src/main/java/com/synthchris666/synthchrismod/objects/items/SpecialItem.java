package com.synthchris666.synthchrismod.objects.items;

import java.util.List;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.init.BiomeInit;
import com.synthchris666.synthchrismod.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class SpecialItem extends Item
{
	public SpecialItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if(KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("Might want this in a Chicken Forest ;)"));			
		}
		else
		{
			tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + " SHIFT " + "\u00A77" + "for more information."));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
		
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		//float rotationYaw = playerIn.rotationYaw;
		//float rotationPitch = playerIn.rotationPitch;
		Vec3d lookVector = playerIn.getLookVec();
		//worldIn.setRainStrength(1.0f);
		//worldIn.setThunderStrength(1.0f);
		if(worldIn.getBiome(playerIn.getPosition()) == BiomeInit.CHICKEN_BIOME.get()) {
			playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 5, 3, true, false, false));
			playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 45, 100, true, false, false));
			playerIn.addVelocity(
					(Math.cos((playerIn.rotationYaw+90) * 0.0174533) * Math.cos((playerIn.rotationPitch) * 0.0174533)) * 1.5, 
					(Math.sin((playerIn.rotationPitch+180) * 0.0174533)), 
					(Math.sin((playerIn.rotationYaw+90) * 0.0174533) * Math.cos((playerIn.rotationPitch) * 0.0174533)) * 1.5);
		}
		if(worldIn.getBiome(playerIn.getPosition()) == BiomeInit.HELL.get()) {
			playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 999999, 255, true, false, false));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 60000;
	}
}
