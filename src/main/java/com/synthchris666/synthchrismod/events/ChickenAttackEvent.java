package com.synthchris666.synthchrismod.events;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.entities.ThiccenEntity;
import com.synthchris666.synthchrismod.init.BiomeInit;
import com.synthchris666.synthchrismod.init.ModEntityTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.FORGE)
public class ChickenAttackEvent 
{
	@SubscribeEvent
	public static void testAttackEvent(LivingHurtEvent event) 
	{
		//SynthChrisMod.LOGGER.info("testJumpEvent fired.");
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		Entity attacker = event.getSource().getTrueSource();
		//livingEntity.setRevengeTarget((LivingEntity) event.getSource().getImmediateSource());
		if(livingEntity instanceof ChickenEntity && world.getBiome(livingEntity.getPosition()) == BiomeInit.CHICKEN_BIOME.get() && (!(attacker instanceof ThiccenEntity))) {
			 livingEntity.startSpinAttack(100);
			 livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 999999, 255, true, false, false));
			 if(attacker instanceof LivingEntity) {
				 ServerWorld serverWorld = (ServerWorld)world;
				 LightningBoltEntity entity = new LightningBoltEntity(world, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), false);
				 serverWorld.addLightningBolt(entity);		
			 }
		}
		//livingEntity.getAttackingEntity();
		//world.setBlockState(livingEntity.getPosition().add(0,-1,0), ObjectInit.egg_ore.getDefaultState());
		//livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,600,5));
		//livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE,600,255));
		//livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED,600,2));
		//livingEntity.addPotionEffect(new EffectInstance(Effects.LEVITATION,20,2));	
		//livingEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING,600,2));
		SynthChrisMod.LOGGER.info("Attacked: " + livingEntity.toString());
		//SynthChrisMod.LOGGER.info("Attackee: " + event.getSource().getLivingEntity().toString());
	}
}
