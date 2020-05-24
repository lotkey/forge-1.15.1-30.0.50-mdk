package com.synthchris666.synthchrismod.container;

import java.util.Objects;

import com.synthchris666.synthchrismod.init.ModContainerTypes;
import com.synthchris666.synthchrismod.init.ObjectInitNew;
import com.synthchris666.synthchrismod.tileentity.EggChestTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class EggChestContainer extends net.minecraft.inventory.container.Container{

	public final EggChestTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public EggChestContainer(final int windowId, final PlayerInventory playerInventory, final EggChestTileEntity tileEntity) {
		super(ModContainerTypes.EGG_CHEST.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		
		//Main Inventory
		int startX = 8;
		int startY = 18;
		int slotSizePlus2 = 18;
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 13; col++) {
				this.addSlot(new Slot(tileEntity, (row * 13) + col, startX + (col * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}
		
		//Main Player Inventory
		int startPlayerInvY = startY * 9 + 12;
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + col, startX + (col * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
			}
		}
		
		//Hotbar
		int hotbarY = startPlayerInvY + (startPlayerInvY/2) - 29;
		for(int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInventory, col, startX + (col * slotSizePlus2), hotbarY));
		}
	}
	
	private static EggChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "Player inventory cannot be null.");
		Objects.requireNonNull(data, "Data cannot be null.");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if(tileAtPos instanceof EggChestTileEntity) {
			return (EggChestTileEntity)tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct: " + tileAtPos);
	}
	
	public EggChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, ObjectInitNew.EGG_CHEST.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot!=null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			if(index < 104) {
				if(!this.mergeItemStack(itemStack1, 104, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			}
			else if(!this.mergeItemStack(itemStack1, 0, 104, false)) {
				return ItemStack.EMPTY;
			}
			
			if(itemStack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			}
			else {
				slot.onSlotChanged();
			}
		}
		return itemStack;
	}
}
