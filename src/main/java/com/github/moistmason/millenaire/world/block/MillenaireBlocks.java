package com.github.moistmason.millenaire.world.block;

import com.github.moistmason.millenaire.util.Util;
import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

import static com.github.moistmason.millenaire.world.block.MillenaireBlockFactories.*;
import static com.github.moistmason.millenaire.world.block.MillenaireBlockProperties.*;
import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;

public class MillenaireBlocks {
    public static final DeferredRegister.Blocks MILLENAIRE_BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    /** Wood decorations **/
    public static final DeferredBlock<Block> PLAIN_TIMBER_FRAME = register("plain_timber_frame", supply(WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN)); // 4096/0
    public static final DeferredBlock<Block> CROSS_TIMBER_FRAME = register("cross_timber_frame", supply(WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN)); // 4096/1
    public static final DeferredBlock<SlabBlock> TIMBER_FRAME_SLAB = register("timber_frame_slab", supply(SlabBlock::new, WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN)); // 4181
    public static final DeferredBlock<StairBlock> TIMBER_FRAME_STAIRS = register("timber_frame_stairs", supplyStairs(StairBlock::new, PLAIN_TIMBER_FRAME, WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN)); // 4186
    public static final DeferredBlock<RotatedPillarBlock> THATCH = register("thatch", supply(RotatedPillarBlock::new, WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN));
    public static final DeferredBlock<SlabBlock> THATCH_SLAB = register("thatch_slab", supply(SlabBlock::new, WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN));
    public static final DeferredBlock<StairBlock> THATCH_STAIRS = register("thatch_stairs", supplyStairs(StairBlock::new, THATCH, WOOD_DECORATION_PROPERTIES, MapColor.COLOR_BROWN));

    /** Stone decorations **/
    public static final DeferredBlock<Block> PLASTERED_MUD = register("plastered_mud", supply(STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> PLASTERED_MUD_BRICK = register("plastered_mud_brick", supply(STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<SlabBlock> PLASTERED_MUD_BRICK_SLAB = register("plastered_mud_brick_slab", supply(SlabBlock::new, STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<StairBlock> PLASTERED_MUD_BRICK_STAIRS = register("plastered_mud_brick_stairs", supplyStairs(StairBlock::new, PLASTERED_MUD_BRICK, STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<WallBlock> PLASTERED_MUD_BRICK_WALL = register("plastered_mud_brick_wall", supply(WallBlock::new, STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> DECORATED_PLASTERED_MUD_BRICK = register("decorated_plastered_mud_brick", supply(STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> ORNAMENTED_PLASTERED_MUD_BRICK = register("ornamented_plastered_mud_brick", supply(STONE_DECORATION_PROPERTIES, MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> GOLD_ORNAMENT = register("gold_ornament", supply(STONE_DECORATION_PROPERTIES, MapColor.GOLD));
    public static final DeferredBlock<Block> BYZANTINE_MOSAIC = register("byzantine_mosaic", supply(STONE_DECORATION_PROPERTIES, MapColor.COLOR_RED));
    public static final DeferredBlock<Block> BYZANTINE_FRESCO = register("byzantine_fresco", supply(STONE_DECORATION_PROPERTIES, MapColor.COLOR_BLUE));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_BRICK = register("light_blue_concrete_brick", supply(STONE_DECORATION_PROPERTIES, MapColor.COLOR_LIGHT_BLUE));
    public static final DeferredBlock<Block> LIGHT_BLUE_CHISELED_CONCRETE = register("light_blue_chiseled_concrete", supply(STONE_DECORATION_PROPERTIES, MapColor.COLOR_LIGHT_BLUE));

    /** Dirt paths **/
    public static final DeferredBlock<SlabBlock> DIRT_SLAB = register("dirt_slab", supply(SlabBlock::new, Blocks.DIRT));
    public static final DeferredBlock<Block> DIRT_PATH_WALL = register("dirt_path_wall", supply(Blocks.DIRT_PATH));
    public static final DeferredBlock<FarmSlabBlock> DIRT_PATH_SLAB = register("dirt_path_slab", supply(FarmSlabBlock::new, Blocks.DIRT_PATH));

    private static <T extends Block> DeferredBlock<T> register(String id, Supplier<T> data) {
        DeferredBlock<T> block = MILLENAIRE_BLOCKS.register(id, data);
        MillenaireItems.registerBlockItem(block);
        return block;
    }

    private static Supplier<Block> supply(Block parent) {
        return supply(Block::new, Properties.ofFullCopy(parent));
    }

    private static Supplier<Block> supply(Properties properties, MapColor color) {
        return supply(Block::new, properties, color);
    }

    private static <T extends Block> Supplier<T> supply(BlockFactory<T> factory, Properties properties) {
        return () -> factory.create(properties);
    }

    private static <T extends Block> Supplier<T> supply(BlockFactory<T> factory, Block parent) {
        return () -> factory.create(Properties.ofFullCopy(parent));
    }

    private static <T extends Block> Supplier<T> supply(BlockFactory<T> factory, Properties properties, MapColor color) {
        return () -> factory.create(properties.mapColor(color));
    }

    private static <T extends StairBlock> Supplier<T> supplyStairs(StairBlockFactory<T> factory, DeferredBlock<? extends Block> base, Properties properties, MapColor color) {
        return () -> factory.create(base.get().defaultBlockState(), properties.mapColor(color));
    }

    public static List<Block> list() {
        return Util.registryAsList(MILLENAIRE_BLOCKS);
    }
}
