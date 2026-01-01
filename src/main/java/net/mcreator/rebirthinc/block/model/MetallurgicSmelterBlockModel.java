package net.mcreator.rebirthinc.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.block.entity.MetallurgicSmelterTileEntity;

public class MetallurgicSmelterBlockModel extends GeoModel<MetallurgicSmelterTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MetallurgicSmelterTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("rebirth_inc", "animations/smelter.animation.json");
		return new ResourceLocation("rebirth_inc", "animations/smelter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MetallurgicSmelterTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("rebirth_inc", "geo/smelter.geo.json");
		return new ResourceLocation("rebirth_inc", "geo/smelter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MetallurgicSmelterTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("rebirth_inc", "textures/block/smelter_1.png");
		return new ResourceLocation("rebirth_inc", "textures/block/smelter_0.png");
	}
}
