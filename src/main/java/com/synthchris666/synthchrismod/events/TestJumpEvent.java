package com.synthchris666.synthchrismod.events;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.init.BiomeInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
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
		//SynthChrisMod.LOGGER.info("testJumpEvent fired.");
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		if((livingEntity instanceof ChickenEntity && world.getBiome(livingEntity.getPosition()) == BiomeInit.CHICKEN_BIOME.get())) {
			livingEntity.addPotionEffect(new EffectInstance(Effects.LEVITATION, 15, 5, true, false, false));
			livingEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 20, 255, true, false, false));
			//ServerWorld serverWorld = (ServerWorld)world;
			livingEntity.addVelocity(
					(Math.cos((livingEntity.rotationYaw+90) * 0.0174533) * Math.cos((livingEntity.rotationPitch) * 0.0174533)) * 1.5, 
					(Math.sin((livingEntity.rotationPitch+180) * 0.0174533)) * 1.5, 
					(Math.sin((livingEntity.rotationYaw+90) * 0.0174533) * Math.cos((livingEntity.rotationPitch) * 0.0174533)) * 1.5);
		}		
	}
}
