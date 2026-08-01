package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MagneticCoreAtractionProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double DeltaX = 0;
		double DeltaY = 0;
		double DeltaZ = 0;
		double Distance = 0;
		double NormX = 0;
		double NormY = 0;
		double NormZ = 0;
		double VelocityX = 0;
		double VelocityY = 0;
		double VelocityZ = 0;
		double NForce = 0;
		ItemStack EntityMadeItem = ItemStack.EMPTY;
		if (Items.IRON_HELMET == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("minecraft:item")
				|| ((entity instanceof LivingEntity _entity) ? _entity.isHolding(Items.IRON_INGOT) : false)) {
			int horizontalRadiusSphere = (int) 20 - 1;
			int verticalRadiusSphere = (int) 20 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == RebirthIncModBlocks.MAGNETIC_CORE.get()) {
								if ((entity instanceof LivingEntity _entity) ? _entity.isHolding(Items.IRON_INGOT) : false) {
									if (entity instanceof Player _player_) {
										if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
											_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), true);
											_player_.getMainHandItem().shrink(1);
											_player_.getInventory().setChanged();
										}
									}
								} else {
									DeltaX = x + xi - x;
									DeltaY = y + i - y;
									DeltaZ = z + zi - z;
									Distance = Math.sqrt(Math.pow(DeltaX, 2) + Math.pow(DeltaY, 2) + Math.pow(DeltaZ, 2));
									NormX = DeltaX / Distance;
									NormY = DeltaY / Distance;
									NormZ = DeltaZ / Distance;
									NForce = Math.min(0.3, Math.max(0.3 - Distance / 40, 0));
									VelocityX = NormX * NForce;
									VelocityY = NormY * NForce;
									VelocityZ = NormZ * NForce;
									entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + VelocityX), (entity.getDeltaMovement().y() + VelocityY), (entity.getDeltaMovement().z() + VelocityZ)));
								}
							}
						}
					}
				}
			}
		}
	}
}
