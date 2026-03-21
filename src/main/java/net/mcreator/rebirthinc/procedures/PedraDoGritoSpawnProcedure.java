package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.MobSpawnEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;
import net.mcreator.rebirthinc.entity.PedradogritoEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PedraDoGritoSpawnProcedure {
	@SubscribeEvent
	public static void entitySpawns(MobSpawnEvent.PositionCheck event) {
		execute(event, event.getLevel(), event.getX(), event.getY(), event.getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean existe = false;
		if (entity instanceof PedradogritoEntity) {
			int horizontalRadiusSquare = (int) 2 - 1;
			int verticalRadiusSquare = (int) 1 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == RebirthIncModBlocks.PEDRITAS.get()) {
							existe = true;
						}
					}
				}
			}
			if (!existe) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
