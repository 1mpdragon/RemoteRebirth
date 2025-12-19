package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class BackpackBlockDestroyedByPlayerProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		BlockState gamer = Blocks.AIR.defaultBlockState();
		double itemQuantity = 0;
		double Slot = 0;
		String Commando = "";
		String Gamer = "";
		ItemStack ItemGamer = ItemStack.EMPTY;
		if (blockstate.getBlock() == RebirthIncModBlocks.BACKPACK.get()) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			Slot = 0;
			ItemGamer = new ItemStack(RebirthIncModBlocks.BACKPACK.get()).copy();
			ItemGamer.setHoverName(Component.literal("Gamer"));
			ItemGamer.getOrCreateTag().putUUID("Item", entity.getUUID());
			Commando = "summon item ~0.5 ~0.5 ~0.5 " + "{Item:{id:\"rebirth_inc:backpack\",Count:1b,tag:{BlockEntityTag:{Items:[";
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + new Object() {
					UUID getBlockNBTLiteralUUID(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getUUID(tag);
						return new UUID(0, 0);
					}
				}.getBlockNBTLiteralUUID(world, BlockPos.containing((int) x, (int) y, (int) z), "BlockEntityTag:"))), false);
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ItemGamer);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
