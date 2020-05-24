package com.synthchris666.synthchrismod.init;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.tileentity.EggChestTileEntity;
import com.synthchris666.synthchrismod.tileentity.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, SynthChrisMod.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry",
			() -> TileEntityType.Builder.create(QuarryTileEntity::new, ObjectInitNew.QUARRY.get()).build(null));

	public static final RegistryObject<TileEntityType<EggChestTileEntity>> EGG_CHEST = TILE_ENTITY_TYPES.register(
			"egg_chest",
			() -> TileEntityType.Builder.create(EggChestTileEntity::new, ObjectInitNew.EGG_CHEST.get()).build(null));
}