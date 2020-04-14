package com.synthchris666.synthchrismod.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SpecialBlock extends Block
{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(7, 0, 7, 9, 8, 9),
			Block.makeCuboidShape(6, 8, 6, 10, 14, 9),
			Block.makeCuboidShape(6, 10, 4, 10, 12, 6),
			Block.makeCuboidShape(7, 8, 5, 9, 10, 6)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(7, 0, 7, 9, 8, 9),
			Block.makeCuboidShape(7, 8, 6, 10, 14, 10),
			Block.makeCuboidShape(10, 10, 6, 12, 12, 10),
			Block.makeCuboidShape(10, 8, 7, 11, 10, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(7, 0, 7, 9, 8, 9),
			Block.makeCuboidShape(6, 8, 7, 10, 14, 10),
			Block.makeCuboidShape(6, 10, 10, 10, 12, 12),
			Block.makeCuboidShape(7, 8, 10, 9, 10, 11)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();;
	
	public static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(7, 0, 7, 9, 8, 9),
			Block.makeCuboidShape(6, 8, 6, 9, 14, 10),
			Block.makeCuboidShape(4, 10, 6, 6, 12, 10),
			Block.makeCuboidShape(5, 8, 7, 6, 10, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public SpecialBlock(Properties properties)
	{
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) 
	{
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn)
	{
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
		if(!worldIn.isRemote()) 
		{
			ServerWorld serverWorld = (ServerWorld)worldIn;
			LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
			serverWorld.addLightningBolt(entity);
		}
		return ActionResultType.SUCCESS;
	}
}
