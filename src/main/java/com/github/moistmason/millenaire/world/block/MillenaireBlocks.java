package com.github.moistmason.millenaire.world.block;

import com.github.moistmason.millenaire.util.RegistryUtil;
import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.block.MillenaireBlockFactories.BlockFactory;
import static com.github.moistmason.millenaire.world.block.MillenaireBlockFactories.StairBlockFactory;
import static net.minecraft.world.level.block.Blocks.*;

public class MillenaireBlocks {
    public static final DeferredRegister.Blocks MILLENAIRE_BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    /** Wood decorations **/
    public static final DeferredBlock<Block> PLAIN_TIMBER_FRAME = register("plain_timber_frame", supply(OAK_PLANKS.properties(), MapColor.COLOR_BROWN)); // 4096/0
    public static final DeferredBlock<Block> CROSS_TIMBER_FRAME = register("cross_timber_frame", supply(OAK_PLANKS.properties(), MapColor.COLOR_BROWN)); // 4096/1
    public static final DeferredBlock<SlabBlock> TIMBER_FRAME_SLAB = register("timber_frame_slab", supply(SlabBlock::new, OAK_SLAB.properties(), MapColor.COLOR_BROWN)); // 4181
    public static final DeferredBlock<StairBlock> TIMBER_FRAME_STAIRS = register("timber_frame_stairs", supplyStairs(StairBlock::new, PLAIN_TIMBER_FRAME, OAK_STAIRS.properties(), MapColor.COLOR_BROWN)); // 4186
    public static final DeferredBlock<RotatedPillarBlock> THATCH = register("thatch", supply(RotatedPillarBlock::new, HAY_BLOCK.properties(), MapColor.COLOR_BROWN));
    public static final DeferredBlock<SlabBlock> THATCH_SLAB = register("thatch_slab", supply(SlabBlock::new, HAY_BLOCK.properties(), MapColor.COLOR_BROWN));
    public static final DeferredBlock<StairBlock> THATCH_STAIRS = register("thatch_stairs", supplyStairs(StairBlock::new, THATCH, HAY_BLOCK.properties(), MapColor.COLOR_BROWN));

    /** Stone decorations **/
    public static final DeferredBlock<Block> PLASTERED_MUD = register("plastered_mud", supply(PACKED_MUD.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> PLASTERED_MUD_BRICKS = register("plastered_mud_bricks", supply(MUD_BRICKS.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<SlabBlock> PLASTERED_MUD_BRICK_SLAB = register("plastered_mud_brick_slab", supply(SlabBlock::new, MUD_BRICK_SLAB.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<StairBlock> PLASTERED_MUD_BRICK_STAIRS = register("plastered_mud_brick_stairs", supplyStairs(StairBlock::new, PLASTERED_MUD_BRICKS, MUD_BRICK_STAIRS.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<WallBlock> PLASTERED_MUD_BRICK_WALL = register("plastered_mud_brick_wall", supply(WallBlock::new, MUD_BRICK_WALL.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> DECORATED_PLASTERED_MUD_BRICKS = register("decorated_plastered_mud_bricks", supply(MUD_BRICKS.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> ORNAMENTED_PLASTERED_MUD_BRICK = register("ornamented_plastered_mud_bricks", supply(MUD_BRICKS.properties(), MapColor.TERRACOTTA_WHITE));
    public static final DeferredBlock<Block> ORNAMENTED_GOLD_BLOCK = register("ornamented_gold_block", supply(GOLD_BLOCK.properties(), MapColor.GOLD));
    public static final DeferredBlock<Block> BYZANTINE_MOSAIC = register("byzantine_mosaic", supply(GOLD_BLOCK.properties(), MapColor.COLOR_RED));
    public static final DeferredBlock<Block> BYZANTINE_FRESCO = register("byzantine_fresco", supply(GOLD_BLOCK.properties(), MapColor.COLOR_BLUE));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_BRICKS = register("light_blue_concrete_bricks", supply(LIGHT_BLUE_CONCRETE.properties(), MapColor.COLOR_LIGHT_BLUE));
    public static final DeferredBlock<Block> LIGHT_BLUE_CHISELED_CONCRETE = register("light_blue_chiseled_concrete", supply(LIGHT_BLUE_CONCRETE.properties(), MapColor.COLOR_LIGHT_BLUE));

    /** Dirt paths **/
    public static final DeferredBlock<SlabBlock> DIRT_SLAB = register("dirt_slab", supply(SlabBlock::new, DIRT.properties()));
    public static final DeferredBlock<Block> DIRT_WALL = register("dirt_wall", supply(DIRT.properties()));
    public static final DeferredBlock<FarmSlabBlock> DIRT_PATH_SLAB = register("dirt_path_slab", supply(FarmSlabBlock::new, DIRT_PATH.properties()));

    private static <T extends Block> DeferredBlock<T> register(String id, Supplier<T> data) {
        DeferredBlock<T> block = MILLENAIRE_BLOCKS.register(id, data);
        MillenaireItems.registerBlockItem(block);
        return block;
    }

    private static Supplier<Block> supply(Properties properties) {
        return supply(Block::new, properties);
    }

    private static Supplier<Block> supply(Properties properties, MapColor color) {
        return supply(Block::new, properties, color);
    }

    private static <T extends Block> Supplier<T> supply(BlockFactory<T> factory, Properties properties) {
        return () -> factory.create(properties);
    }

    private static <T extends Block> Supplier<T> supply(BlockFactory<T> factory, Properties properties, MapColor color) {
        return () -> factory.create(properties.mapColor(color));
    }

    private static <T extends StairBlock> Supplier<T> supplyStairs(StairBlockFactory<T> factory, DeferredBlock<? extends Block> base, Properties properties, MapColor color) {
        return () -> factory.create(base.get().defaultBlockState(), properties.mapColor(color));
    }

    public static List<Block> list() {
        return RegistryUtil.toList(MILLENAIRE_BLOCKS);
    }
}
