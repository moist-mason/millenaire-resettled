package com.github.moistmason.millenaire.data;

import com.github.moistmason.library.data.LibraryBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;

public class MillenaireBlockStateProvider extends LibraryBlockStateProvider {

    public MillenaireBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        block(PLAIN_TIMBER_FRAME);
        block(CROSS_TIMBER_FRAME);
        slabBlock(TIMBER_FRAME_SLAB, modBlock("plain_timber_frame"), modBlock("plain_timber_frame_side"), modBlock("plain_timber_frame"));
        stairsBlock(TIMBER_FRAME_STAIRS, modBlock("plain_timber_frame_side"), modBlock("plain_timber_frame"));
        axisBlock(THATCH, modBlock("thatch_side"), modBlock("thatch_end"));
        slabBlock(THATCH_SLAB, modBlock("thatch"), modBlock("thatch_side"), modBlock("thatch_end"));
        stairsBlock(THATCH_STAIRS, modBlock("thatch_side"), modBlock("thatch_end"));

        block(PLASTERED_MUD);
        block(PLASTERED_MUD_BRICKS);
        slabBlock(PLASTERED_MUD_BRICK_SLAB, modBlock("plastered_mud_bricks"));
        stairsBlock(PLASTERED_MUD_BRICK_STAIRS, modBlock("plastered_mud_bricks"));
        wallBlock(PLASTERED_MUD_BRICK_WALL, modBlock("plastered_mud_bricks"));
        block(DECORATED_PLASTERED_MUD_BRICKS);
        block(ORNAMENTED_PLASTERED_MUD_BRICK);
        block(ORNAMENTED_GOLD_BLOCK);
        block(BYZANTINE_MOSAIC);
        block(BYZANTINE_FRESCO);
        block(LIGHT_BLUE_CONCRETE_BRICKS);
        block(LIGHT_BLUE_CHISELED_CONCRETE);

        slabBlock(DIRT_SLAB, vanillaBlock("dirt"));
        block(DIRT_WALL);
        blockItem(DIRT_PATH_SLAB); // manually generated block models and block state files
    }
}
