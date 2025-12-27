package net.mcreator.rebirthinc.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.rebirthinc.block.model.RadioBlockModel;
import net.mcreator.rebirthinc.block.entity.RadioTileEntity;

public class RadioTileRenderer extends GeoBlockRenderer<RadioTileEntity> {
	public RadioTileRenderer() {
		super(new RadioBlockModel());
	}

	@Override
	public RenderType getRenderType(RadioTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
