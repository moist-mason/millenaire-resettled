package com.github.moistmason.millenaire.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FarmSlabBlock extends SlabBlock {
    private static final VoxelShape BOTTOM_SHAPE = Block.box(0, 0, 0, 16, 7, 16);
    private static final VoxelShape TOP_SHAPE = Block.box(0, 8, 0, 16, 15, 16);
    private static final VoxelShape DOUBLE_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);

    public FarmSlabBlock(Properties properties) {
        super(properties);
    }

    /* Single slab shape is one pixel shorter than a regular slab. */
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        SlabType type = state.getValue(TYPE);

        return switch (type) {
            case DOUBLE -> DOUBLE_SHAPE;
            case BOTTOM -> BOTTOM_SHAPE;
            case TOP -> TOP_SHAPE;
        };
    }
}
