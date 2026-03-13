package com.github.moistmason.millenaire.data;

import com.github.moistmason.library.data.LibraryBlockStateProvider;
import com.github.moistmason.millenaire.world.block.DecoratedBrickBlock;
import com.github.moistmason.millenaire.world.block.PaintedBrickSet;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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

        for (PaintedBrickSet set : paintedBricksList) {
            block(set.getBlock());
            slabBlock(set.getSlabBlock(), modBlock(set.getColorName() + "_painted_bricks"));
            stairsBlock(set.getStairBlock(), modBlock(set.getColorName() + "_painted_bricks"));
            wallBlock(set.getWallBlock(), modBlock(set.getColorName() + "_painted_bricks"));
            decoratedBrickBlock(set.getDecoratedBlock(), set.getColorName(), set.getSecondaryColorName());
        }
    }

    private void decoratedBrickBlock(DeferredBlock<DecoratedBrickBlock> block, String color, String secondaryColor) {
        String name = color + "_decorated_bricks";
        String paintedName = color + "_painted_bricks";
        String secondaryPaintedName = secondaryColor + "_painted_bricks";

        ConfiguredModel[] bottom = new ConfiguredModel[]{new ConfiguredModel(models().cubeBottomTop(name + "_bottom", modBlock(name + "_bottom"), modBlock(secondaryPaintedName), modBlock(paintedName)))};
        ConfiguredModel[] middle = new ConfiguredModel[]{new ConfiguredModel(models().cubeColumn(name + "_middle", modBlock(name + "_middle"), modBlock(paintedName)))};
        ConfiguredModel[] top = new ConfiguredModel[]{new ConfiguredModel(models().cubeBottomTop(name + "_top", modBlock(name + "_top"), modBlock(paintedName), modBlock(secondaryPaintedName)))};

        getVariantBuilder(block.get()).forAllStates(state -> {
           if (DecoratedBrickBlock.onlyAbove(state) || DecoratedBrickBlock.neither(state)) {
               return bottom;
           } else if (DecoratedBrickBlock.aboveAndBelow(state)) {
               return middle;
           } else { // only below.
               return top;
           }
        });

        simpleBlockItem(block.get(), models().cubeAll(name + "_middle", modBlock(name + "_middle")));
    }
}
