package com.synthchris666.synthchrismod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.synthchris666.synthchrismod.client.entity.render.RoosterEntityRender;
import com.synthchris666.synthchrismod.client.entity.render.ThiccenEntityRender;
import com.synthchris666.synthchrismod.client.gui.EggChestScreen;
import com.synthchris666.synthchrismod.init.BiomeInit;
import com.synthchris666.synthchrismod.init.DimensionInit;
import com.synthchris666.synthchrismod.init.ItemInit;
import com.synthchris666.synthchrismod.init.ItemInitNew;
import com.synthchris666.synthchrismod.init.ModContainerTypes;
import com.synthchris666.synthchrismod.init.ModEntityTypes;
import com.synthchris666.synthchrismod.init.ModTileEntityTypes;
import com.synthchris666.synthchrismod.init.ObjectInitNew;
import com.synthchris666.synthchrismod.init.SoundInit;
import com.synthchris666.synthchrismod.objects.blocks.CherryCrop;
import com.synthchris666.synthchrismod.world.gen.ModOreGen;

import net.minecraft.block.ComposterBlock;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;


@Mod("synthchrismod")
@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.MOD)
public class SynthChrisMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "synthchrismod";
    public static SynthChrisMod instance;
    public static final ResourceLocation CHICKEN_DIM_TYPE = new ResourceLocation(MOD_ID, "chicken");
    public static final ResourceLocation HELL_DIM_TYPE = new ResourceLocation(MOD_ID, "hell");
    
    public SynthChrisMod() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        //modEventBus.addListener(this::doClientStuff);
        
        SoundInit.SOUNDS.register(modEventBus);
        ItemInitNew.ITEMS.register(modEventBus);
        ObjectInitNew.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        DimensionInit.MOD_DIMENSIONS.register(modEventBus);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	ObjectInitNew.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof CherryCrop)).map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(SynthChrisItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered BlockItems!");
    }    
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    	BiomeInit.registerBiomes();
    }
  
	private void setup(final FMLCommonSetupEvent event)
    {
    	ComposterBlock.registerCompostable(0.3f, ObjectInitNew.CHERRY_LEAVES.get());
    	ComposterBlock.registerCompostable(0.3f, ObjectInitNew.MAGIC_LEAVES.get());
    	ComposterBlock.registerCompostable(0.3f, ObjectInitNew.CHERRY_SAPLING.get());
    	ComposterBlock.registerCompostable(0.3f, ObjectInitNew.MAGIC_SAPLING.get());
    	ModEntityTypes.registerPlacementTypes();
    	registerEntityWorldSpawn(ModEntityTypes.ROOSTER_ENTITY.get(), 2500000, 50, 100, BiomeInit.CHICKEN_BIOME.get());
    	registerEntityWorldSpawn(ModEntityTypes.THICCEN_ENTITY.get(), 2500000, 5, 10, BiomeInit.CHICKEN_BIOME.get());
    	registerEntityWorldSpawn(ModEntityTypes.CHICKEN_GHOUL.get(), 3, 200, 1000, BiomeInit.HELL.get());
    }

    /*@SubscribeEvent
    private void doClientStuff(final FMLClientSetupEvent event)
    {
    }*/
	
	private static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroupIn, int maxGroupIn, Biome... biomes) {
		for(Biome biome : biomes) {
			if(biome != null) {
				biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, minGroupIn, maxGroupIn));
			}
		}
	}
    

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	ModOreGen.generateOre();
    }
    
    public static class SynthChrisItemGroup extends ItemGroup
    {
    	public static final SynthChrisItemGroup instance = new SynthChrisItemGroup(ItemGroup.GROUPS.length, "synthchristab");
    	private SynthChrisItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(ItemInit.special_egg);
    	}
    }
}
