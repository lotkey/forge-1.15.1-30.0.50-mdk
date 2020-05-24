package com.synthchris666.synthchrismod.client;

import java.util.Arrays;

import javax.annotation.Nullable;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.common.registry.SynthChrisSounds;
import com.synthchris666.synthchrismod.init.BiomeInit;
import com.synthchris666.synthchrismod.util.MusicUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = SynthChrisMod.MOD_ID, value = Dist.CLIENT)
public class ClientEventHandler {
    private static final Minecraft CLIENT = Minecraft.getInstance();
    
    private static final long AMBIENT_SOUND_INTERVAL = 140;
    private static final int AMBIENT_SOUND_CHANCE = 120;

    private static long lastAmbientSoundTime;

    private static ISound playingMusic;
    public static float flicker;
    public static float prevFlicker;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            prevFlicker = flicker;

            double targetFlicker = Math.random();
            targetFlicker *= targetFlicker;

            flicker += (targetFlicker - flicker) * 0.5;
        }


        if (!CLIENT.isGamePaused()) {
            ClientPlayerEntity player = CLIENT.player;
            if (player == null) {
                return;
            }

            if (event.phase == TickEvent.Phase.END) {
                if (playingMusic != null && !CLIENT.getSoundHandler().isPlaying(playingMusic)) {
                    playingMusic = null;
                }
            }
        }
    }

    /*
    private static void playAmbientSounds(PlayerEntity player) {
        Random rand = player.world.rand;
        long worldTime = player.world.getGameTime();

        if (worldTime - lastAmbientSoundTime > AMBIENT_SOUND_INTERVAL && rand.nextInt(AMBIENT_SOUND_CHANCE) == 0) {
            ResourceLocation ambientSound = MidnightSounds.AMBIENT.getName();

            float volume = (rand.nextFloat() * 0.4F + 0.8F) * MidnightConfig.client.ambientVolume.get().floatValue();
            float pitch = rand.nextFloat() * 0.6F + 0.7F;

            float x = (float) (player.getPosX() + rand.nextFloat() - 0.5F);
            float y = (float) (player.getPosY() + rand.nextFloat() - 0.5F);
            float z = (float) (player.getPosZ() + rand.nextFloat() - 0.5F);

            ISound sound = new SimpleSound(ambientSound, SoundCategory.AMBIENT, volume, pitch, false, 0, ISound.AttenuationType.NONE, x, y, z, false);
            CLIENT.getSoundHandler().play(sound);

            lastAmbientSoundTime = worldTime;
        }
    }*/

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        if (!isMusicSound()) {
            return;
        }

        if (CLIENT.player != null && MusicUtil.isModDimension(CLIENT.player.world)) {
            SoundEvent sound = getMusicSound(CLIENT.player);
            if (sound == null || playingMusic != null) {
                event.setResultSound(null);
                return;
            }

            playingMusic = SimpleSound.music(sound);

            event.setResultSound(playingMusic);
        }
    }

    @Nullable
    private static SoundEvent getMusicSound(PlayerEntity player) {
        Biome biome = player.world.getBiome(player.getPosition());
        if (biome == BiomeInit.CHICKEN_BIOME.get()) {
            return SynthChrisSounds.MUSIC_CHICKEN;
        } else if (biome == BiomeInit.HELL.get()) {
            return SynthChrisSounds.MUSIC_HELL;
        }
        return SynthChrisSounds.MUSIC_CHICKEN;
    }

    private static boolean isMusicSound() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return Arrays.stream(stackTrace).anyMatch(e -> e.getClassName().equals(MusicTicker.class.getName()));
    }
}
