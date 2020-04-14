package com.synthchris666.synthchrismod;
import com.synthchris666.synthchrismod.SynthChrisMod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.synthchris666.synthchrismod.init.ItemInit;
import com.synthchris666.synthchrismod.world.gen.ModOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("synthchrismod")
@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.MOD)
public class SynthChrisMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "synthchrismod";
    public static SynthChrisMod instance;
    
    public SynthChrisMod() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    	
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
    		return new ItemStack(ItemInit.test_item);
    	}
    }
}
