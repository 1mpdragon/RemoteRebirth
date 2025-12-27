package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.rebirthinc.init.RebirthIncModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class FolhaComandoProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		ItemStack folha = ItemStack.EMPTY;
		folha = new ItemStack(RebirthIncModItems.FOLHA.get()).copy();
		folha.getOrCreateTag().putString("text", (StringArgumentType.getString(arguments, "text")));
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player) {
			ItemStack _setstack = folha.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
