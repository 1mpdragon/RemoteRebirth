
package net.mcreator.rebirthinc.world.inventory;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class BackpackMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public BackpackMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(RebirthIncModMenus.BACKPACK.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(54);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null)
					boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity != null)
					boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 7, 7) {
			private final int slot = 0;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 25, 7) {
			private final int slot = 1;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 43, 7) {
			private final int slot = 2;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 61, 7) {
			private final int slot = 3;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 79, 7) {
			private final int slot = 4;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 97, 7) {
			private final int slot = 5;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 115, 7) {
			private final int slot = 6;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 133, 7) {
			private final int slot = 7;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 151, 7) {
			private final int slot = 8;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 7, 25) {
			private final int slot = 9;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 25, 25) {
			private final int slot = 10;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 43, 25) {
			private final int slot = 11;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 61, 25) {
			private final int slot = 12;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 79, 25) {
			private final int slot = 13;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 97, 25) {
			private final int slot = 14;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 115, 25) {
			private final int slot = 15;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 133, 25) {
			private final int slot = 16;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 151, 25) {
			private final int slot = 17;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 7, 43) {
			private final int slot = 18;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 25, 43) {
			private final int slot = 19;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 43, 43) {
			private final int slot = 20;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 61, 43) {
			private final int slot = 21;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 79, 43) {
			private final int slot = 22;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 97, 43) {
			private final int slot = 23;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 115, 43) {
			private final int slot = 24;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 133, 43) {
			private final int slot = 25;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 151, 43) {
			private final int slot = 26;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 7, 61) {
			private final int slot = 27;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 25, 61) {
			private final int slot = 28;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 43, 61) {
			private final int slot = 29;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 61, 61) {
			private final int slot = 30;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 79, 61) {
			private final int slot = 31;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 97, 61) {
			private final int slot = 32;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 115, 61) {
			private final int slot = 33;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 133, 61) {
			private final int slot = 34;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 7, 79) {
			private final int slot = 36;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 25, 79) {
			private final int slot = 37;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 43, 79) {
			private final int slot = 38;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 61, 79) {
			private final int slot = 39;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 79, 79) {
			private final int slot = 40;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 97, 79) {
			private final int slot = 41;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 115, 79) {
			private final int slot = 42;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 133, 79) {
			private final int slot = 43;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 151, 79) {
			private final int slot = 44;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 7, 97) {
			private final int slot = 45;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 25, 97) {
			private final int slot = 46;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 43, 97) {
			private final int slot = 47;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 61, 97) {
			private final int slot = 48;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 79, 97) {
			private final int slot = 49;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 97, 97) {
			private final int slot = 50;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 115, 97) {
			private final int slot = 51;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 133, 97) {
			private final int slot = 52;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 151, 97) {
			private final int slot = 53;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 151, 61) {
			private final int slot = 35;
			private int x = BackpackMenu.this.x;
			private int y = BackpackMenu.this.y;
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, -1 + 8 + sj * 18, 38 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, -1 + 8 + si * 18, 38 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 54) {
				if (!this.moveItemStackTo(itemstack1, 54, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 54, false)) {
				if (index < 54 + 27) {
					if (!this.moveItemStackTo(itemstack1, 54 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 54, 54 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty()) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
					if (j <= maxSize) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						p_38904_.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (true) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					if (p_38904_.getCount() > slot1.getMaxStackSize()) {
						slot1.setByPlayer(p_38904_.split(slot1.getMaxStackSize()));
					} else {
						slot1.setByPlayer(p_38904_.split(p_38904_.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
