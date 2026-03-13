package com.github.moistmason.millenaire.world.block;

import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.github.moistmason.library.registry.BlockRegistrySuppliers.*;

/**
 * Represents a set of painted brick blocks, including subtypes like stairs, slabs, and walls.
 * Secondary colors only apply to the decorated brick blocks.
 */
public enum PaintedBrickSet {
    WHITE(DyeColor.WHITE, Items.WHITE_DYE, DyeColor.ORANGE),
    ORANGE(DyeColor.ORANGE, Items.ORANGE_DYE, DyeColor.ORANGE),
    MAGENTA(DyeColor.MAGENTA, Items.MAGENTA_DYE, DyeColor.GRAY),
    LIGHT_BLUE(DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE, DyeColor.LIGHT_BLUE),
    YELLOW(DyeColor.YELLOW, Items.YELLOW_DYE, DyeColor.WHITE),
    LIME(DyeColor.LIME, Items.LIME_DYE, DyeColor.YELLOW),
    PINK(DyeColor.PINK, Items.PINK_DYE, DyeColor.WHITE),
    GRAY(DyeColor.GRAY, Items.GRAY_DYE, DyeColor.ORANGE),
    LIGHT_GRAY(DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE, DyeColor.LIGHT_GRAY),
    CYAN(DyeColor.CYAN, Items.CYAN_DYE, DyeColor.CYAN),
    PURPLE(DyeColor.PURPLE, Items.PURPLE_DYE, DyeColor.PURPLE),
    BLUE(DyeColor.BLUE, Items.BLUE_DYE, DyeColor.BLUE),
    BROWN(DyeColor.BROWN, Items.BROWN_DYE, DyeColor.BROWN),
    GREEN(DyeColor.GREEN, Items.GREEN_DYE, DyeColor.YELLOW),
    RED(DyeColor.RED, Items.RED_DYE, DyeColor.YELLOW),
    BLACK(DyeColor.BLACK, Items.BLACK_DYE, DyeColor.YELLOW);

    private static final BlockBehaviour.Properties BRICK_PROPERTIES = Blocks.BRICKS.properties();

    private final DyeColor color;
    private final String colorName;
    private final DyeColor secondaryColor;
    private final String secondaryColorName;
    private final Item dyeItem;
    private final MapColor mapColor;

    private DeferredBlock<Block> block;
    private DeferredBlock<SlabBlock> slabBlock;
    private DeferredBlock<StairBlock> stairBlock;
    private DeferredBlock<WallBlock> wallBlock;
    private DeferredBlock<DecoratedBrickBlock> decoratedBlock;

    PaintedBrickSet(DyeColor color, Item dyeItem, DyeColor secondaryColor) {
        this.color = color;
        this.colorName = color.getName();
        this.dyeItem = dyeItem;
        this.secondaryColor = secondaryColor;
        this.secondaryColorName = secondaryColor.getName();
        this.mapColor = color.getMapColor();
    }

    public DyeColor getColor() {
        return color;
    }

    public String getColorName() {
        return colorName;
    }

    public DyeColor getSecondaryColor() {
        return secondaryColor;
    }

    public String getSecondaryColorName() {
        return secondaryColorName;
    }

    public Item getDyeItem() {
        return dyeItem;
    }

    public MapColor getMapColor() {
        return color.getMapColor();
    }

    public void registerBlock(DeferredRegister.Blocks registry) {
        this.block = registry.register(colorName + "_painted_bricks", supply(Blocks.BRICKS, mapColor));
        MillenaireItems.registerBlockItem(block);
    }

    public void registerSlabBlock(DeferredRegister.Blocks registry) {
        this.slabBlock = registry.register(colorName + "_painted_brick_slab", supply(SlabBlock::new, BRICK_PROPERTIES, mapColor));
        MillenaireItems.registerBlockItem(slabBlock);
    }

    public void registerStairBlock(DeferredRegister.Blocks registry, DeferredBlock<?> parent) {
        this.stairBlock = registry.register(colorName + "_painted_brick_stairs", supplyStairs(StairBlock::new, parent, BRICK_PROPERTIES, mapColor));
        MillenaireItems.registerBlockItem(stairBlock);
    }

    public void registerWallBlock(DeferredRegister.Blocks registry) {
        this.wallBlock = registry.register(colorName + "_painted_brick_wall", supply(WallBlock::new, BRICK_PROPERTIES, mapColor));
        MillenaireItems.registerBlockItem(wallBlock);
    }

    public void registerDecoratedBlock(DeferredRegister.Blocks registry) {
        this.decoratedBlock = registry.register(colorName + "_decorated_bricks", supply(DecoratedBrickBlock::new, BRICK_PROPERTIES, mapColor));
        MillenaireItems.registerBlockItem(decoratedBlock);
    }

    public DeferredBlock<Block> getBlock() {
        return block;
    }

    public DeferredBlock<SlabBlock> getSlabBlock() {
        return slabBlock;
    }

    public DeferredBlock<StairBlock> getStairBlock() {
        return stairBlock;
    }

    public DeferredBlock<WallBlock> getWallBlock() {
        return wallBlock;
    }

    public DeferredBlock<DecoratedBrickBlock> getDecoratedBlock() {
        return decoratedBlock;
    }
}
