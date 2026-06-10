package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BreakingWoodProcedure {
	@SubscribeEvent
	public static void onComputeBreakSpeed(PlayerEvent.BreakSpeed event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			BlockState blockstate = event.getState();
			ItemStack itemstack = entity instanceof Player _plr ? _plr.getMainHandItem() : ItemStack.EMPTY;
			LevelAccessor world = entity.level();
			boolean iscorrecttool = itemstack.getItem().isCorrectToolForDrops(blockstate);
			float breakspeed = event.getOriginalSpeed();
			float hardness = blockstate.getDestroySpeed(world, BlockPos.containing(0, 0, 0));
			float breaktime = itemstack.getDestroySpeed(blockstate);
			if (iscorrecttool) {
				breaktime = 1.5f;
			} else {
				breaktime = 5f;
			}
			float toolfactor = (itemstack.getItem() instanceof TieredItem _item ? _item.getTier().getSpeed() : 1) / breaktime;
			if (iscorrecttool && (itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY)) != 0) {
				toolfactor = toolfactor + (float) (1 + Math.pow(itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY), 2));
			}
			breaktime = (int) Math.max(1, Math.ceil(breaktime * hardness * 20 / breakspeed));
			execute(event, blockstate, entity, breakspeed);
		}
	}

	public static void execute(BlockState blockstate, Entity entity, double breakspeed) {
		execute(null, blockstate, entity, breakspeed);
	}

	private static void execute(@Nullable Event event, BlockState blockstate, Entity entity, double breakspeed) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:axes")))) && blockstate.is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
			if (event instanceof PlayerEvent.BreakSpeed _speed) {
				_speed.setNewSpeed((float) (0.2 * breakspeed));
			}
		}
	}
}
