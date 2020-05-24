package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.IExtensibleEnum;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, SynthChrisMod.MOD_ID);

	public static final RegistryObject<SoundEvent> ENTITY_THICCEN_AMBIENT = SOUNDS.register("entity.thiccen_entity.ambient", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.thiccen_entity.ambient")));
	public static final RegistryObject<SoundEvent> ENTITY_THICCEN_HURT = SOUNDS.register("entity.thiccen_entity.hurt", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.thiccen_entity.hurt")));
	
	public static final RegistryObject<SoundEvent> ENTITY_ROOSTER_AMBIENT = SOUNDS.register("entity.rooster_entity.ambient", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.rooster_entity.ambient")));
	public static final RegistryObject<SoundEvent> ENTITY_ROOSTER_HURT = SOUNDS.register("entity.rooster_entity.hurt", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.rooster_entity.hurt")));
	public static final RegistryObject<SoundEvent> ENTITY_ROOSTER_GROWL = SOUNDS.register("entity.rooster_entity.growl", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.rooster_entity.growl")));
	public static final RegistryObject<SoundEvent> ENTITY_ROOSTER_PANT = SOUNDS.register("entity.rooster_entity.pant", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.rooster_entity.pant")));
	public static final RegistryObject<SoundEvent> ENTITY_ROOSTER_WHINE = SOUNDS.register("entity.rooster_entity.whine", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.rooster_entity.whine")));
	
	public static final RegistryObject<SoundEvent> ENTITY_CHICKEN_GHOUL_AMBIENT = SOUNDS.register("entity.chicken_ghoul.ambient", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.chicken_ghoul.ambient")));
	public static final RegistryObject<SoundEvent> ENTITY_CHICKEN_GHOUL_HURT = SOUNDS.register("entity.chicken_ghoul.hurt", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.chicken_ghoul.hurt")));
	public static final RegistryObject<SoundEvent> ENTITY_CHICKEN_GHOUL_DEATH = SOUNDS.register("entity.chicken_ghoul.death", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "entity.chicken_ghoul.death")));
	
	public static final RegistryObject<SoundEvent> MUSIC_CHICKEN1 = SOUNDS.register("music.chicken.chicken1", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "music.chicken.chicken1")));
	public static final RegistryObject<SoundEvent> MUSIC_CHICKEN2 = SOUNDS.register("music.chicken.chicken2", () -> new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "music.chicken.chicken2")));

	public static final RegistryObject<SoundEvent> MUSIC_HELL1 = SOUNDS.register("music.hell.hell1", () ->  new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, "music.hell.hell1")));
	//EnumHelperClient.addMusicType("chicken", SoundInit.MUSIC_CHICKEN1, 0, 0);
	//IExtensibleEnum jeff = new IExtensibleEnum;
}
