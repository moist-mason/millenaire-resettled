package com.github.moistmason.millenaire.data;

import com.github.moistmason.millenaire.world.block.MillenaireBlockProperties;
import com.github.moistmason.millenaire.world.block.MillenaireBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;


public class MillenaireBlockTagsProvider extends BlockTagsProvider {
    public MillenaireBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(PLAIN_TIMBER_FRAME.get(), CROSS_TIMBER_FRAME.get(), TIMBER_FRAME_SLAB.get(), TIMBER_FRAME_STAIRS.get(),
                        THATCH.get(), THATCH_SLAB.get(), THATCH_STAIRS.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(PLASTERED_MUD.get(), PLASTERED_MUD_BRICK.get(), PLASTERED_MUD_BRICK_SLAB.get(), PLASTERED_MUD_BRICK_STAIRS.get(),
                        PLASTERED_MUD_BRICK_WALL.get(), DECORATED_PLASTERED_MUD_BRICK.get(), ORNAMENTED_PLASTERED_MUD_BRICK.get(), GOLD_ORNAMENT.get(),
                        BYZANTINE_MOSAIC.get(), BYZANTINE_FRESCO.get(), LIGHT_BLUE_CONCRETE_BRICK.get(), LIGHT_BLUE_CHISELED_CONCRETE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(DIRT_SLAB.get(), DIRT_PATH_WALL.get(), DIRT_PATH_SLAB.get());
    }
}
