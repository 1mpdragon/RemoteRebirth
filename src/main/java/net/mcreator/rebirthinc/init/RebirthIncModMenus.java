
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.rebirthinc.world.inventory.BackpackMenu;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RebirthIncMod.MODID);
	public static final RegistryObject<MenuType<BackpackMenu>> BACKPACK = REGISTRY.register("backpack", () -> IForgeMenuType.create(BackpackMenu::new));
}
