package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DebugCommandProcedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		if (DoubleArgumentType.getDouble(arguments, "number_who") == 1) {
			RebirthIncModVariables.MapVariables.get(world).test_number = DoubleArgumentType.getDouble(arguments, "number");
			RebirthIncModVariables.MapVariables.get(world).syncData(world);
		} else if (DoubleArgumentType.getDouble(arguments, "number_who") == 2) {
			RebirthIncModVariables.MapVariables.get(world).test_number_1 = DoubleArgumentType.getDouble(arguments, "number");
			RebirthIncModVariables.MapVariables.get(world).syncData(world);
		} else if (DoubleArgumentType.getDouble(arguments, "number_who") == 3) {
			RebirthIncModVariables.MapVariables.get(world).test_number_2 = DoubleArgumentType.getDouble(arguments, "number");
			RebirthIncModVariables.MapVariables.get(world).syncData(world);
		} else if (DoubleArgumentType.getDouble(arguments, "number_who") == 4) {
			RebirthIncModVariables.MapVariables.get(world).test_number_3 = DoubleArgumentType.getDouble(arguments, "number");
			RebirthIncModVariables.MapVariables.get(world).syncData(world);
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + DoubleArgumentType.getDouble(arguments, "number"))), false);
	}
}
