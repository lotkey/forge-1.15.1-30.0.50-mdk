package com.synthchris666.synthchrismod.world.dimension;

import javax.annotation.Nullable;

import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.MusicTicker.MusicType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IRenderHandler;

public class HellDimension extends Dimension{

	public HellDimension(World world, DimensionType type) {
		super(world, type, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new HellChunkGenerator(world, new HellBiomeProvider(), new HellGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
	      return null;
	    }

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
	      return null;
	   }
	
	@Override
	public boolean hasSkyLight() {
		return false;
	}
	
	@Override
	public void setSkyRenderer(IRenderHandler skyRenderer) {
		// TODO Auto-generated method stub
		super.setSkyRenderer(skyRenderer);
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.5f;
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return new Vec3d(0, 0, 0);
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}
	
	@Override
	public int getActualHeight() {
		return 256;
	}
	
	@Override
	public float getCloudHeight() {
		return 70;
	}
	/*
	@SubscribeEvent
	public void onPlayerWakeUpEvent( PlayerWakeUpEvent event )
	{
	    setWorldTime(0);
	}
	*/
	
	@Nullable
    @OnlyIn(Dist.CLIENT)
	public  MusicTicker.MusicType getMusicType()
    {
        return MusicType.NETHER;
    }
}
