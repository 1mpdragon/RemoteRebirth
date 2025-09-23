
package net.mcreator.rebirthinc.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.rebirthinc.init.RebirthIncModFluids;

public class SemenBlock extends LiquidBlock {
	public SemenBlock() {
		super(() -> RebirthIncModFluids.SEMEN.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
