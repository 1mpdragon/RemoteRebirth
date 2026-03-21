package net.mcreator.rebirthinc.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.entity.PedradogritoEntity;

public class PedradogritoModel extends GeoModel<PedradogritoEntity> {
	@Override
	public ResourceLocation getAnimationResource(PedradogritoEntity entity) {
		return new ResourceLocation("rebirth_inc", "animations/pedra_do_grito.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PedradogritoEntity entity) {
		return new ResourceLocation("rebirth_inc", "geo/pedra_do_grito.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PedradogritoEntity entity) {
		return new ResourceLocation("rebirth_inc", "textures/entities/" + entity.getTexture() + ".png");
	}

}
