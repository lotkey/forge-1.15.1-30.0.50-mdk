package com.synthchris666.synthchrismod.events;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.init.ObjectInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent 
{
	@SubscribeEvent
	public static void testJumpEvent(LivingJumpEvent event) 
	{
		SynthChrisMod.LOGGER.info("testJumpEvent fired.");
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		//world.setBlockState(livingEntity.getPosition().add(0,-1,0), ObjectInit.egg_ore.getDefaultState());
		//livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,600,5));
		//livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE,600,255));
		livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED,600,2));
		//livingEntity.addPotionEffect(new EffectInstance(Effects.LEVITATION,20,2));	
		//livingEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING,600,2));
	}
}
