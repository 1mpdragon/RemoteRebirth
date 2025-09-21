package net.mcreator.rebirthinc.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.entity.VacadachuvaEntity;

public class VacadachuvaModel extends GeoModel<VacadachuvaEntity> {
	@Override
	public ResourceLocation getAnimationResource(VacadachuvaEntity entity) {
		return new ResourceLocation("rebirth_inc", "animations/pluviis_lemius.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VacadachuvaEntity entity) {
		return new ResourceLocation("rebirth_inc", "geo/pluviis_lemius.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VacadachuvaEntity entity) {
		return new ResourceLocation("rebirth_inc", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(VacadachuvaEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
