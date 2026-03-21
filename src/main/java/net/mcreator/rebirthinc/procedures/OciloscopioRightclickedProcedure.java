package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import com.mojang.blaze3d.platform.InputConstants;

public class OciloscopioRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean B = false;
		double set = 0;
		if (world instanceof Level _level) {
			if (_level.isClientSide()) {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.hat")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LSHIFT)) {
			set = 0.5;
		} else {
			set = 1;
		}
		if ((entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).Hz + set > 50) {
			{
				double _setval = 0;
				entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Hz = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = (entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).Hz + set;
				entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Hz = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
