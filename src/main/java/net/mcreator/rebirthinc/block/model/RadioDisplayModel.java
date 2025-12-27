package net.mcreator.rebirthinc.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.block.display.RadioDisplayItem;

public class RadioDisplayModel extends GeoModel<RadioDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(RadioDisplayItem animatable) {
		return new ResourceLocation("rebirth_inc", "animations/radio_frequency.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RadioDisplayItem animatable) {
		return new ResourceLocation("rebirth_inc", "geo/radio_frequency.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RadioDisplayItem entity) {
		return new ResourceLocation("rebirth_inc", "textures/block/radio.png");
	}
}
