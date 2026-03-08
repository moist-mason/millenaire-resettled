package com.github.moistmason.millenaire.data;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;

import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;

import java.util.Set;

public class MillenaireBlockLootProvider extends BlockLootSubProvider {
    protected MillenaireBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(PLAIN_TIMBER_FRAME.get());
        dropSelf(CROSS_TIMBER_FRAME.get());
        dropSlab(TIMBER_FRAME_SLAB.get());
        dropSelf(TIMBER_FRAME_STAIRS.get());
        dropSelf(THATCH.get());
        dropSlab(THATCH_SLAB.get());
        dropSelf(THATCH_STAIRS.get());
        dropSelf(PLASTERED_MUD.get());
        dropSelf(PLASTERED_MUD_BRICK.get());
        dropSlab(PLASTERED_MUD_BRICK_SLAB.get());
        dropSelf(PLASTERED_MUD_BRICK_STAIRS.get());
        dropSelf(PLASTERED_MUD_BRICK_WALL.get());
        dropSelf(DECORATED_PLASTERED_MUD_BRICK.get());
        dropSelf(ORNAMENTED_PLASTERED_MUD_BRICK.get());
        dropSelf(GOLD_ORNAMENT.get());
        dropSelf(BYZANTINE_MOSAIC.get());
        dropSelf(BYZANTINE_FRESCO.get());
        dropSelf(LIGHT_BLUE_CONCRETE_BRICK.get());
        dropSelf(LIGHT_BLUE_CHISELED_CONCRETE.get());
        dropSlab(DIRT_SLAB.get());
        dropSelf(DIRT_PATH_WALL.get());
        dropSlab(DIRT_PATH_SLAB.get());
        dropWhenSilkTouch(DIRT_PATH_SLAB.get());
        dropOther(DIRT_PATH_SLAB.get(), DIRT_SLAB.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MILLENAIRE_BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected void dropSlab(SlabBlock slab) {
        add(slab, block -> createSlabItemTable(slab));
    }
}
