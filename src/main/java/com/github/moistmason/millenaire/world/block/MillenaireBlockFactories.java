package com.github.moistmason.millenaire.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MillenaireBlockFactories {

    /* Full blocks */
    @FunctionalInterface
    public interface BlockFactory<T extends Block> {
        T create(BlockBehaviour.Properties properties);
    }

    /* Stairs */
    @FunctionalInterface
    public interface StairBlockFactory<T extends StairBlock> {
        T create(BlockState defaultState, BlockBehaviour.Properties properties);
    }
}
