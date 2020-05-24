package com.synthchris666.synthchrismod.events;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.entities.ChickenGhoul;
import com.synthchris666.synthchrismod.world.dimension.HellDimension;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.FORGE)
public class HellStormEvent {
	@SubscribeEvent
	public static void hellStormEvent(LivingEvent event) {
		int randInt = 0;
		int randX = (int) ((Math.random() * 100) % 7);
		int randZ = (int) ((Math.random() * 100) % 7);

		if (event.getEntity() instanceof LivingEntity) {
			if (event.getEntity() instanceof PlayerEntity) {
				randInt = (int) (Math.random() * 100);
			} else {
				randInt = (int) (int) (Math.random() * 1000);
			}
			if (randInt == 0 && !event.getEntity().getEntityWorld().isRemote()
					&& event.getEntity().getEntityWorld().getDimension() instanceof HellDimension
					&& (event.getEntity().getEntityWorld().getBlockState(
							event.getEntity().getPosition().down()) == Blocks.GRASS_BLOCK.getDefaultState())) {
				if (event.getEntityLiving().isInWater() && event.getEntityLiving() instanceof PlayerEntity) {
					event.getEntityLiving()
							.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 30, false, false));
				}

				LightningBoltEntity lightning = new LightningBoltEntity(event.getEntity().getEntityWorld(),
						event.getEntity().getPosX() + randX, event.getEntity().getPosY(),
						event.getEntity().getPosZ() + randZ, false);

				((ServerWorld) event.getEntity().getEntityWorld()).addLightningBolt(lightning);
				if (!(event.getEntity() instanceof PlayerEntity)) {
					event.getEntityLiving()
							.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 10, 5, false, false));
					event.getEntityLiving()
							.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 50, 255, false, false));
				}
			} else if (randInt % 20 == 1 && event.getEntity().getEntityWorld().getDimension() instanceof HellDimension) {
				SoundEvent sound;
				switch ((int) (Math.random() * 100) % 7) {
				case 0:
					sound = SoundEvents.ENTITY_ENDERMAN_SCREAM;
					break;
				case 1:
					sound = SoundEvents.ENTITY_ENDERMAN_HURT;
					break;
				case 2:
					sound = SoundEvents.ENTITY_GHAST_SCREAM;
					break;
				case 3:
					sound = SoundEvents.ENTITY_GHAST_HURT;
					break;
				case 4:
					sound = SoundEvents.BLOCK_METAL_PLACE;
					break;
				case 5:
					sound = SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE;
					break;
				case 6:
					sound = SoundEvents.ENTITY_GENERIC_EXPLODE;
					break;
				default:
					sound = SoundEvents.ENTITY_CHICKEN_HURT;
					break;
				}
				event.getEntityLiving().getEntityWorld().playSound(event.getEntityLiving().getPosX() + randX,
						event.getEntityLiving().getPosY(), event.getEntityLiving().getPosZ() + randZ, sound,
						SoundCategory.HOSTILE, .5f, 1.0f, false);
			}
		}

	}

}
