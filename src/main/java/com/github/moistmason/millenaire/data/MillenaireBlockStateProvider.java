package com.github.moistmason.millenaire.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.util.ResourceProvider.modBlock;
import static com.github.moistmason.millenaire.util.ResourceProvider.vanillaBlock;
import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;

public class MillenaireBlockStateProvider extends BlockStateProvider {

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
        block(PLASTERED_MUD_BRICK);
        slabBlock(PLASTERED_MUD_BRICK_SLAB, modBlock("plastered_mud_brick"));
        stairsBlock(PLASTERED_MUD_BRICK_STAIRS, modBlock("plastered_mud_brick"));
        wallBlock(PLASTERED_MUD_BRICK_WALL, modBlock("plastered_mud_brick"));
        block(DECORATED_PLASTERED_MUD_BRICK);
        block(ORNAMENTED_PLASTERED_MUD_BRICK);
        block(GOLD_ORNAMENT);
        block(BYZANTINE_MOSAIC);
        block(BYZANTINE_FRESCO);
        block(LIGHT_BLUE_CONCRETE_BRICK);
        block(LIGHT_BLUE_CHISELED_CONCRETE);

        slabBlock(DIRT_SLAB, vanillaBlock("dirt"));
        block(DIRT_PATH_WALL, vanillaBlock("dirt_path_top"));
        slabBlock(DIRT_PATH_SLAB, vanillaBlock("dirt_path"), vanillaBlock("dirt_path_side"), vanillaBlock("dirt"), vanillaBlock("dirt_path_top"));
    }

    private <T extends Block> void block(DeferredBlock<T> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private <T extends Block> void block(DeferredBlock<T> block, ResourceLocation parentTexture) {
        simpleBlockWithItem(block.get(), models().singleTexture(block.getId().getPath(), vanillaBlock("cube_all"), "all", parentTexture));
    }

    private <T extends RotatedPillarBlock> void axisBlock(DeferredBlock<T> block, ResourceLocation side, ResourceLocation end) {
        axisBlock(block.get(), side, end);
        blockItem(block);
    }

    private <T extends SlabBlock> void slabBlock(DeferredBlock<T> block, ResourceLocation parent) {
        slabBlock(block, parent, parent, parent, parent);
    }

    private <T extends SlabBlock> void slabBlock(DeferredBlock<T> block, ResourceLocation doubleSlab, ResourceLocation side, ResourceLocation end) {
        slabBlock(block, doubleSlab, side, end, end);
    }

    private <T extends SlabBlock> void slabBlock(DeferredBlock<T> block, ResourceLocation doubleSlab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        slabBlock(block.get(), doubleSlab, side, bottom, top);
        blockItem(block);
    }

    private <T extends StairBlock> void stairsBlock(DeferredBlock<T> block, ResourceLocation texture) {
        stairsBlock(block, texture, texture, texture);
    }

    private <T extends StairBlock> void stairsBlock(DeferredBlock<T> block, ResourceLocation side, ResourceLocation end) {
        stairsBlock(block, side, end, end);
    }

    private <T extends StairBlock> void stairsBlock(DeferredBlock<T> block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        stairsBlock(block.get(), side, bottom, top);
        blockItem(block);
    }

    private <T extends WallBlock> void wallBlock(DeferredBlock<T> block, ResourceLocation texture) {
        wallBlock(block.get(), texture);
        models().wallInventory(block.getId().getPath() + "_inventory", texture);
        blockItem(block, "inventory");
    }

    private <T extends Block> void blockItem(DeferredBlock<T> block) {
        blockItem(block, null);
    }

    private <T extends Block> void blockItem(DeferredBlock<T> block, String appendix) {
        String id = appendix != null ? block.getId().getPath() + "_" + appendix : block.getId().getPath();
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(modBlock(id)));
    }
}
