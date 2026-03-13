package com.github.moistmason.millenaire.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class DecoratedBrickBlock extends Block {
    public static final BooleanProperty BRICK_ABOVE = BooleanProperty.create("brick_above");
    public static final BooleanProperty BRICK_BELOW = BooleanProperty.create("brick_below");

    public DecoratedBrickBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(BRICK_ABOVE, true)
                .setValue(BRICK_BELOW, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BRICK_ABOVE, BRICK_BELOW);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState stateAbove = level.getBlockState(pos.above());
        BlockState stateBelow = level.getBlockState(pos.below());

        return defaultBlockState()
                .setValue(BRICK_ABOVE, isThis(stateAbove))
                .setValue(BRICK_BELOW, isThis(stateBelow));
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);

        boolean brickAbove = isThis(level.getBlockState(pos.above()));
        boolean brickBelow = isThis(level.getBlockState(pos.below()));

        if (state.getValue(BRICK_ABOVE) != brickAbove || state.getValue(BRICK_BELOW) != brickBelow) {
            BlockState newState = state.setValue(BRICK_ABOVE, brickAbove).setValue(BRICK_BELOW, brickBelow);
            level.removeBlock(pos, false);
            level.setBlock(pos, newState, 1);
        }
    }

    public static boolean onlyAbove(BlockState state) {
        return state.getValue(BRICK_ABOVE).equals(true)
                && state.getValue(BRICK_BELOW).equals(false);
    }

    public static boolean aboveAndBelow(BlockState state) {
        return state.getValue(BRICK_ABOVE).equals(true)
                && state.getValue(BRICK_BELOW).equals(true);
    }

    public static boolean neither(BlockState state) {
        return state.getValue(BRICK_ABOVE).equals(false)
                && state.getValue(BRICK_BELOW).equals(false);
    }
    /**
     * @param state The current block state.
     * @return {@code true} if the provided state is an instance of the decorated brick block.
     */
    private boolean isThis(BlockState state) {
        return state.getBlock() instanceof DecoratedBrickBlock;
    }
}
