package net.mcreator.rebirthinc.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.item.AcoraIraItem;

public class AcoraIraItemModel extends GeoModel<AcoraIraItem> {
	@Override
	public ResourceLocation getAnimationResource(AcoraIraItem animatable) {
		return new ResourceLocation("rebirth_inc", "animations/anchor_ira.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcoraIraItem animatable) {
		return new ResourceLocation("rebirth_inc", "geo/anchor_ira.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcoraIraItem animatable) {
		return new ResourceLocation("rebirth_inc", "textures/item/anchor_ira.png");
	}
}
