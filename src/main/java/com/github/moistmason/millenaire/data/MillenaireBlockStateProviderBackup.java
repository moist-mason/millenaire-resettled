package com.github.moistmason.millenaire.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;

/*
public class MillenaireBlockStateProviderBackup extends BlockStateProvider {

    public MillenaireBlockStateProviderBackup(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        block(PLAIN_TIMBER_FRAME);
        block(CROSS_TIMBER_FRAME);
        slabBlock(TIMBER_FRAME_SLAB, "plain_timber_frame", "plain_timber_frame_side", "plain_timber_frame");
        stairsBlock(TIMBER_FRAME_STAIRS, "plain_timber_frame_side", "plain_timber_frame");
        axisBlock(THATCH, "thatch_side", "thatch_end");
        slabBlock(THATCH_SLAB, "thatch", "thatch_side", "thatch_end");
        stairsBlock(THATCH_STAIRS, "thatch_side", "thatch_end");

        block(PLASTERED_MUD);
        block(PLASTERED_MUD_BRICK);
        slabBlock(PLASTERED_MUD_BRICK_SLAB, "plastered_mud_brick");
        stairsBlock(PLASTERED_MUD_BRICK_STAIRS, "plastered_mud_brick");
        wallBlock(PLASTERED_MUD_BRICK_WALL, "plastered_mud_brick");
        block(DECORATED_PLASTERED_MUD_BRICK);
        block(ORNAMENTED_PLASTERED_MUD_BRICK);
        block(GOLD_ORNAMENT);
        block(BYZANTINE_MOSAIC);
        block(BYZANTINE_FRESCO);
        block(LIGHT_BLUE_CONCRETE_BRICK);
        block(LIGHT_BLUE_CHISELED_CONCRETE);
        vanillaSlabBlock(DIRT_SLAB, "dirt");
        block(DIRT_PATH_WALL);
        vanillaSlabBlock(DIRT_PATH_SLAB, "dirt", "dirt", "dirt", "dirt_path");
    }

    private void block(DeferredBlock<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void block(DeferredBlock<Block> block, String texture) {

    }

    private <T extends SlabBlock> void vanillaSlabBlock(DeferredBlock<T> block, String texture) {
        vanillaSlabBlock(block, texture, texture, texture);
    }

    private <T extends SlabBlock> void vanillaSlabBlock(DeferredBlock<T> block, String doubleSlab, String side, String end) {
        vanillaSlabBlock(block, doubleSlab, side, end, end);
    }

    private <T extends SlabBlock> void vanillaSlabBlock(DeferredBlock<T> block, String doubleSlab, String side, String bottom, String top) {
        slabBlock(block.get(), mcPath(doubleSlab), mcPath(side), mcPath(bottom), mcPath(top));
        blockItem(block);
    }

    private <T extends SlabBlock> void slabBlock(DeferredBlock<T> block, String texture) {
        slabBlock(block, texture, texture, texture);
    }

    private <T extends SlabBlock> void slabBlock(DeferredBlock<T> block, String doubleSlab, String side, String end) {
        slabBlock(block.get(), modLoc(doubleSlab), modPath(side), modPath(end), modPath(end));
        blockItem(block);
    }

    private <T extends WallBlock> void wallBlock(DeferredBlock<T> block, String texture) {
        wallBlock(block.get(), modPath(texture));
        blockItem(block);
    }

    private <T extends RotatedPillarBlock> void axisBlock(DeferredBlock<T> block, String side, String end) {
        axisBlock(block.get(), modPath(side), modPath(end));
        blockItem(block);
    }

    private void blockItem(DeferredBlock<?> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(modPath(block)));
    }

    private ResourceLocation modPath(DeferredBlock<?> block) {
        return modPath(block.getId().getPath());
    }

    private ResourceLocation modPath(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/" + id);
    }

    private ResourceLocation mcPath(String id) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + id);
    }
}

 */
