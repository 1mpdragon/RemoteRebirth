package net.mcreator.rebirthinc.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.block.display.MetallurgicSmelterDisplayItem;

public class MetallurgicSmelterDisplayModel extends GeoModel<MetallurgicSmelterDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MetallurgicSmelterDisplayItem animatable) {
		return new ResourceLocation("rebirth_inc", "animations/smelter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MetallurgicSmelterDisplayItem animatable) {
		return new ResourceLocation("rebirth_inc", "geo/smelter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MetallurgicSmelterDisplayItem entity) {
		return new ResourceLocation("rebirth_inc", "textures/block/smelter_0.png");
	}
}
