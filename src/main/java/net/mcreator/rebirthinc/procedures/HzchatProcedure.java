package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;
import net.mcreator.rebirthinc.RebirthIncMod;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class HzchatProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		execute(null, world, x, y, z, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		ArrayList<Object> Demiurgo = new ArrayList<>();
		ArrayList<Object> Donatelo = new ArrayList<>();
		String newText = "";
		String CompletText = "";
		double TextIndexN = 0;
		if (event != null && event.isCancelable()) {
			event.setCanceled(true);
		}
		TextIndexN = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).Hz == (entityiterator.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RebirthIncModVariables.PlayerVariables())).Hz) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw " + entityiterator.getDisplayName().getString() + " " + CompletText));
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + (text).length())), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + new Object() {
						private int returnSize(String text, String separator) {
							String[] resultTxt = (text).split(separator);
							return resultTxt.length;
						}
					}.returnSize(text, " "))), false);
				while (TextIndexN < new Object() {
					private int returnSize(String text, String separator) {
						String[] resultTxt = (text).split(separator);
						return resultTxt.length;
					}
				}.returnSize(text, " ")) {
					if ((new Object() {
						private String returnValue(String string, int Index, String sep) {
							try {
								return ((string).split(sep)[Index]);
								// Utilisez account ici
							} catch (ArrayIndexOutOfBoundsException e) {
								// Gérer l'erreur ici, par exemple :
								System.out.println("Valeur null !");
								return "";
							}
						}
					}.returnValue(text, ((int) TextIndexN), " ")).length() > 5) {
						if ((TextIndexN + 1) % 5 == 0) {
							CompletText = CompletText + "\",\"color\":\"green\"},{\"text\":\"ERROR \",\"color\":\"red\"},{\"text\":\" \\n";
						} else {
							CompletText = CompletText + "\",\"color\":\"green\"},{\"text\":\"ERROR \",\"color\":\"red\"},{\"text\":\"";
						}
					} else {
						if ((TextIndexN + 1) % 5 == 0) {
							CompletText = CompletText + (new Object() {
								private String returnValue(String string, int Index, String sep) {
									try {
										return ((string).split(sep)[Index]);
										// Utilisez account ici
									} catch (ArrayIndexOutOfBoundsException e) {
										// Gérer l'erreur ici, par exemple :
										System.out.println("Valeur null !");
										return "";
									}
								}
							}.returnValue(text, ((int) TextIndexN), " ") + " \\n");
						} else {
							CompletText = CompletText + (new Object() {
								private String returnValue(String string, int Index, String sep) {
									try {
										return ((string).split(sep)[Index]);
										// Utilisez account ici
									} catch (ArrayIndexOutOfBoundsException e) {
										// Gérer l'erreur ici, par exemple :
										System.out.println("Valeur null !");
										return "";
									}
								}
							}.returnValue(text, ((int) TextIndexN), " ") + " ");
						}
					}
					TextIndexN = TextIndexN + 1;
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw " + entityiterator.getDisplayName().getString() + " [{\"text\":\""
									+ ("<" + "Hz: " + (entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).Hz + "> \\n" + CompletText) + "\",\"color\":\"green\"}]"));
				{
					double _setval = 0;
					entityiterator.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChatDelay = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
			}
		}
		RebirthIncMod.LOGGER.info("gamer moment" + "Dev" + " [{\"text\":\""
				+ ("<" + "Hz: " + (entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).Hz + "> \\n" + CompletText) + "\",\"color\":\"\"green\"}]");
	}
}
