package com.synthchris666.synthchrismod.init;

import java.util.function.Supplier;

import com.synthchris666.synthchrismod.SynthChrisMod;
import com.synthchris666.synthchrismod.SynthChrisMod.SynthChrisItemGroup;
import com.synthchris666.synthchrismod.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = SynthChrisMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(SynthChrisMod.MOD_ID)
public class ItemInit 
{
	public static final Item god_egg = null;
	public static final Item special_egg = null;
	public static final Item egg_ingot = null;
	
	//tools
	public static final Item egg_sword = null;
	public static final Item egg_pickaxe = null;
	public static final Item egg_axe = null;
	public static final Item egg_shovel = null;
	public static final Item egg_hoe = null;
	
	//armor
	public static final Item egg_helmet = null;
	public static final Item egg_chestplate = null;
	public static final Item egg_leggings = null;
	public static final Item egg_boots = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new Item(new Item.Properties().group(SynthChrisItemGroup.instance).food(new Food.Builder().hunger(7).setAlwaysEdible().effect(new EffectInstance(Effects.SPEED, 6000, 255), 1f).effect(new EffectInstance(Effects.RESISTANCE, 6000, 255), 1f).effect(new EffectInstance(Effects.JUMP_BOOST, 6000, 255), 1f).build())).setRegistryName("god_egg"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("special_egg"));
		event.getRegistry().register(new Item(new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_ingot"));
		
		//tools
		event.getRegistry().register(new SwordItem(ModItemTier.EGG,20,10.0f,new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.EGG,4,5.0f,new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.EGG,2,5.0f,new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.EGG,11,3.0f,new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.EGG,5.0f,new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_hoe"));
	
		//armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EGG, EquipmentSlotType.HEAD, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EGG, EquipmentSlotType.CHEST, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EGG, EquipmentSlotType.LEGS, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.EGG, EquipmentSlotType.FEET, new Item.Properties().group(SynthChrisItemGroup.instance)).setRegistryName("egg_boots"));
	}
	
	public enum ModItemTier implements IItemTier
	{
		EGG(4,2031,15.0f,7.0f,250,() -> {
			return Ingredient.fromItems(ItemInit.god_egg);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMaterial.getValue();
		}
	}
	
	public enum ModArmorMaterial implements IArmorMaterial
	{
		EGG(SynthChrisMod.MOD_ID + ":egg", 5, new int[] {6,12,16,6}, 420, SoundEvents.field_226142_fM_, 6.9f, () -> {
			return Ingredient.fromItems(ItemInit.god_egg);
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn)
		{
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return  MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
