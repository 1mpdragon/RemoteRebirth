package net.mcreator.rebirthinc.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.block.entity.RadioTileEntity;

public class RadioBlockModel extends GeoModel<RadioTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(RadioTileEntity animatable) {
		return new ResourceLocation("rebirth_inc", "animations/radio_frequency.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RadioTileEntity animatable) {
		return new ResourceLocation("rebirth_inc", "geo/radio_frequency.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RadioTileEntity animatable) {
		return new ResourceLocation("rebirth_inc", "textures/block/radio.png");
	}
}
