package net.mcreator.rebirthinc.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.rebirthinc.block.model.MetallurgicSmelterBlockModel;
import net.mcreator.rebirthinc.block.entity.MetallurgicSmelterTileEntity;

public class MetallurgicSmelterTileRenderer extends GeoBlockRenderer<MetallurgicSmelterTileEntity> {
	public MetallurgicSmelterTileRenderer() {
		super(new MetallurgicSmelterBlockModel());
	}

	@Override
	public RenderType getRenderType(MetallurgicSmelterTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
