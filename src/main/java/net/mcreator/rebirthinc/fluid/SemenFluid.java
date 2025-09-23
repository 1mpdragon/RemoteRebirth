
package net.mcreator.rebirthinc.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.rebirthinc.init.RebirthIncModItems;
import net.mcreator.rebirthinc.init.RebirthIncModFluids;
import net.mcreator.rebirthinc.init.RebirthIncModFluidTypes;
import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

public abstract class SemenFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> RebirthIncModFluidTypes.SEMEN_TYPE.get(), () -> RebirthIncModFluids.SEMEN.get(), () -> RebirthIncModFluids.FLOWING_SEMEN.get())
			.explosionResistance(100f).bucket(() -> RebirthIncModItems.SEMEN_BUCKET.get()).block(() -> (LiquidBlock) RebirthIncModBlocks.SEMEN.get());

	private SemenFluid() {
		super(PROPERTIES);
	}

	public static class Source extends SemenFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SemenFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
