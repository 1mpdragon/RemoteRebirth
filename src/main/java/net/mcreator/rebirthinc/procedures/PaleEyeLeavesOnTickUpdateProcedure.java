package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

import java.util.Map;

public class PaleEyeLeavesOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean CheckPode = false;
		boolean CheckPlaced = false;
		BlockState LocalBlock = Blocks.AIR.defaultBlockState();
		double HeightCheck = 0;
		double LeaveHeight = 0;
		assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:firtsTest
		if (Math.random() < (1) / ((float) 1000)
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("persistent") instanceof BooleanProperty _getbp2 && (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp2)) == false) {
			assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:firtsTest
			HeightCheck = 1;
			while (HeightCheck < 8 && !CheckPode && !CheckPlaced) {
				assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:While
				LocalBlock = (world.getBlockState(BlockPos.containing(x, y - HeightCheck, z)));
				if (LocalBlock.isCollisionShapeFullBlock(world, BlockPos.containing(0, 0, 0))) {
					assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:IFGAMER
					CheckPode = true;
				} else if (LocalBlock.getBlock() == RebirthIncModBlocks.PALE_EYE_LEAVE_LAYER.get()) {
					assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:IFSURUBA
					if ((LocalBlock.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6 ? LocalBlock.getValue(_getip6) : -1) == 6) {
						assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:IFSURUBA2
						{
							BlockPos _bp = BlockPos.containing(x, y - HeightCheck, z);
							BlockState _bs = RebirthIncModBlocks.PALE_EYE_LEAVES.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _pos = BlockPos.containing(x, y - HeightCheck, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("persistent") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
						CheckPlaced = true;
					} else {
						assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:IFSURUBA3
						{
							int _value = (int) ((LocalBlock.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? LocalBlock.getValue(_getip9) : -1) + 1);
							BlockPos _pos = BlockPos.containing(x, y - HeightCheck, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						CheckPlaced = true;
					}
				} else if (LocalBlock.getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, (y - HeightCheck) - 1, z))).isCollisionShapeFullBlock(world, BlockPos.containing(0, 0, 0))
						&& !((world.getBlockState(BlockPos.containing(x, (y - HeightCheck) - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
								&& !((world.getBlockState(BlockPos.containing(x, (y - HeightCheck) - 1, z))).getBlock().getStateDefinition().getProperty("persistent") instanceof BooleanProperty _getbp17
										&& (world.getBlockState(BlockPos.containing(x, (y - HeightCheck) - 1, z))).getValue(_getbp17)))) {
					assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:IFPUNHETA
					world.setBlock(BlockPos.containing(x, y - HeightCheck, z), RebirthIncModBlocks.PALE_EYE_LEAVE_LAYER.get().defaultBlockState(), 3);
					CheckPlaced = true;
				} else {
					assert Boolean.TRUE; //#dbg:PaleEyeLeavesOnTickUpdate:ELSEGAMER
					HeightCheck = HeightCheck + 1;
				}
			}
		}
	}
}
