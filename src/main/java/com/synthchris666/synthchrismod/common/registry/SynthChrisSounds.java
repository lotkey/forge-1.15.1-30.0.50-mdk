package com.synthchris666.synthchrismod.common.registry;

import com.synthchris666.synthchrismod.SynthChrisMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SynthChrisSounds {

	public static final SoundEvent MUSIC_CHICKEN = makeSoundEvent("music_chicken");
	public static final SoundEvent MUSIC_HELL = makeSoundEvent("music_hell");
	
	 @SubscribeEvent
	    public static void onRegisterSounds(RegistryEvent.Register<SoundEvent> event) {
	        event.getRegistry().registerAll(MUSIC_CHICKEN, MUSIC_HELL);
	 }
	
	
	private static SoundEvent makeSoundEvent(String name) {
        SoundEvent sound = new SoundEvent(new ResourceLocation(SynthChrisMod.MOD_ID, name));
        sound.setRegistryName(new ResourceLocation(SynthChrisMod.MOD_ID, name));
        return sound;
    }
	
}
