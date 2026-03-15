package com.github.moistmason.millenaire.data;

import com.github.moistmason.millenaire.world.block.FarmSlabBlock;
import com.github.moistmason.millenaire.world.block.PaintedBrickSet;
import com.mojang.datafixers.kinds.Const;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetEnchantmentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;

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
        dropSelf(PLASTERED_MUD_BRICKS.get());
        dropSlab(PLASTERED_MUD_BRICK_SLAB.get());
        dropSelf(PLASTERED_MUD_BRICK_STAIRS.get());
        dropSelf(PLASTERED_MUD_BRICK_WALL.get());
        dropSelf(DECORATED_PLASTERED_MUD_BRICKS.get());
        dropSelf(ORNAMENTED_PLASTERED_MUD_BRICK.get());
        dropSelf(ORNAMENTED_GOLD_BLOCK.get());
        dropSelf(BYZANTINE_MOSAIC.get());
        dropSelf(BYZANTINE_FRESCO.get());
        dropSelf(LIGHT_BLUE_CONCRETE_BRICKS.get());
        dropSelf(LIGHT_BLUE_CHISELED_CONCRETE.get());
        dropSlab(DIRT_SLAB.get());
        dropSelf(DIRT_WALL.get());
        dropPathSlab(DIRT_PATH_SLAB.get());
        dropWhenSilkTouch(WHITE_STAINED_GLASS_WINDOWS.get());
        dropWhenSilkTouch(YELLOW_STAINED_GLASS_WINDOWS.get());
        dropWhenSilkTouch(YELLOW_AND_RED_STAINED_GLASS_WINDOWS.get());
        dropWhenSilkTouch(RED_AND_BLUE_STAINED_GLASS_WINDOWS.get());
        dropWhenSilkTouch(GREEN_AND_BLUE_STAINED_GLASS_WINDOWS.get());

        for (PaintedBrickSet set : paintedBricksList) {
            dropSelf(set.getBlock().get());
            dropSlab(set.getSlabBlock().get());
            dropSelf(set.getStairBlock().get());
            dropSelf(set.getWallBlock().get());
            dropSelf(set.getDecoratedBlock().get());
        }


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MILLENAIRE_BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected void dropSlab(SlabBlock slab) {
        add(slab, block -> createSlabItemTable(slab));
    }

    /**
     * Slab paths require some additional fuckery to ensure double slab drops are correct and that silk touch works.
     * Path slabs (any type) always drop dirt unless using silk touch.
     */
    protected void dropPathSlab(FarmSlabBlock slab) {
        add(slab, LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(
                                                applyExplosionDecay(
                                                        slab,
                                                        LootItem.lootTableItem(slab))
                                                        .when(hasSilkTouch())
                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                                .when(
                                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(slab)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))
                                                                )
                                                        )
                                                        .otherwise(
                                                                applyExplosionDecay(
                                                                        slab,
                                                                        LootItem.lootTableItem(DIRT_SLAB))
                                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                                                .when(
                                                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(slab)
                                                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))
                                                                                )
                                                                        )
                                                        )
                                        )
                        )
                );
    }
}
