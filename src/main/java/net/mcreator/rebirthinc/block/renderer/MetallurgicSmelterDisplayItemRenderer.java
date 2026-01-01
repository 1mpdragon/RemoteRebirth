package net.mcreator.rebirthinc.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.rebirthinc.block.model.MetallurgicSmelterDisplayModel;
import net.mcreator.rebirthinc.block.display.MetallurgicSmelterDisplayItem;

public class MetallurgicSmelterDisplayItemRenderer extends GeoItemRenderer<MetallurgicSmelterDisplayItem> {
	public MetallurgicSmelterDisplayItemRenderer() {
		super(new MetallurgicSmelterDisplayModel());
	}

	@Override
	public RenderType getRenderType(MetallurgicSmelterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
