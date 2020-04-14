package com.synthchris666.synthchrismod;

import com.synthchris666.synthchrismod.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class test 
{
	public test()
	{
		ResourceLocation testTagItem = new ResourceLocation(SynthChrisMod.MOD_ID, "testtagitem");
		Item item = ItemInit.test_item;
		boolean isInTag = ItemTags.getCollection().get(testTagItem).contains(item);
		if(isInTag)
		{
			item.setDamage(item.getDefaultInstance(), 15);
		}
	}
}
