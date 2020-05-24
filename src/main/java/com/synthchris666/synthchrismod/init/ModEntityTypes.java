package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.entities.ChickenGhoul;
import com.synthchris666.synthchrismod.entities.RoosterEntity;
import com.synthchris666.synthchrismod.entities.ThiccenEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			SynthChrisMod.MOD_ID);

	public static final RegistryObject<EntityType<ThiccenEntity>> THICCEN_ENTITY = ENTITY_TYPES
			.register("thiccen_entity",
					() -> EntityType.Builder.<ThiccenEntity>create(ThiccenEntity::new, EntityClassification.CREATURE)
							.size(0.9f, 1.3f)
							.build(new ResourceLocation(SynthChrisMod.MOD_ID, "thiccen_entity").toString()));

	public static final RegistryObject<EntityType<RoosterEntity>> ROOSTER_ENTITY = ENTITY_TYPES
			.register("rooster_entity",
					() -> EntityType.Builder.<RoosterEntity>create(RoosterEntity::new, EntityClassification.CREATURE)
							.size(0.9f, 1.3f)
							.build(new ResourceLocation(SynthChrisMod.MOD_ID, "rooster_entity").toString()));
	
	public static final RegistryObject<EntityType<ChickenGhoul>> CHICKEN_GHOUL = ENTITY_TYPES.register("chicken_ghoul",
			() -> EntityType.Builder.<ChickenGhoul>create(ChickenGhoul::new, EntityClassification.CREATURE)
					.size(0.6F, 4.0F).build(new ResourceLocation(SynthChrisMod.MOD_ID, "chicken_ghoul").toString()));

	public static void registerPlacementTypes() {
		registerPlacementType(THICCEN_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND);
		registerPlacementType(ROOSTER_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND);
		registerPlacementType(CHICKEN_GHOUL.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS);
	}

	
	public static void registerPlacementType(EntityType type,
			EntitySpawnPlacementRegistry.PlacementType spawnType) {
		EntitySpawnPlacementRegistry.register(type, spawnType, Heightmap.Type.WORLD_SURFACE,
				MonsterEntity::canMonsterSpawnInLight);
	}
}