package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.BufferBuilder;

public class HzWaveProcedure {
	private static BufferBuilder bufferBuilder = null;
	private static VertexBuffer vertexBuffer = null;
	private static VertexFormat.Mode mode = null;
	private static VertexFormat format = null;

	private static void add(double x, double y, double z, int color) {
		add(x, y, z, 0.0F, 0.0F, color);
	}

	private static void add(double x, double y, double z, float u, float v, int color) {
		if (bufferBuilder == null || !bufferBuilder.building())
			return;
		if (format == DefaultVertexFormat.POSITION_COLOR) {
			bufferBuilder.vertex(x, y, z).color(color).endVertex();
		} else if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
			bufferBuilder.vertex(x, y, z).uv(u, v).color(color).endVertex();
		}
	}

	private static boolean begin(VertexFormat.Mode mode, VertexFormat format, boolean update) {
		if (HzWaveProcedure.bufferBuilder == null || !HzWaveProcedure.bufferBuilder.building()) {
			if (update)
				clear();
			if (HzWaveProcedure.vertexBuffer == null) {
				if (format == DefaultVertexFormat.POSITION_COLOR) {
					HzWaveProcedure.mode = mode;
					HzWaveProcedure.format = format;
					HzWaveProcedure.bufferBuilder = Tesselator.getInstance().getBuilder();
					HzWaveProcedure.bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_COLOR);
					return true;
				} else if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
					HzWaveProcedure.mode = mode;
					HzWaveProcedure.format = format;
					HzWaveProcedure.bufferBuilder = Tesselator.getInstance().getBuilder();
					HzWaveProcedure.bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_TEX_COLOR);
					return true;
				}
			}
		}
		return false;
	}

	private static void clear() {
		if (vertexBuffer != null) {
			vertexBuffer.close();
			vertexBuffer = null;
		}
	}

	private static void end() {
		if (bufferBuilder == null || !bufferBuilder.building())
			return;
		if (vertexBuffer != null)
			vertexBuffer.close();
		vertexBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
		vertexBuffer.bind();
		vertexBuffer.upload(bufferBuilder.end());
		VertexBuffer.unbind();
	}

	private static VertexBuffer shape() {
		return vertexBuffer;
	}

	public static VertexBuffer execute(Entity entity) {
		return execute(null, entity);
	}

	private static VertexBuffer execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return null;
		double L = 0;
		double Frequency = 0;
		double repeat = 0;
		if (begin(VertexFormat.Mode.DEBUG_LINE_STRIP, DefaultVertexFormat.POSITION_COLOR, true)) {
			repeat = 100;
			Frequency = (entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).Hz / 60;
			L = 0;
			for (int index0 = 0; index0 < (int) repeat; index0++) {
				add((L - repeat), (0.5 * Math.sin(Frequency * L - entity.tickCount * Frequency)), 0, 255 << 24 | 255 << 16 | 255 << 8 | 255);
				L = 2 + L;
			}
			end();
		}
		return shape();
	}
}
