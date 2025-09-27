
package net.mcreator.rebirthinc.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.procedures.MinhocalhauPCDProcedure;

public class MinhocalhauBlock extends Block {
	public MinhocalhauBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRAVEL).strength(0.5f, 10f).randomTicks());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		MinhocalhauPCDProcedure.execute(world, x, y, z);
	}
}
