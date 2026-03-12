package com.github.moistmason.millenaire.world.block;

import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.github.moistmason.library.registry.BlockRegistrySuppliers.*;

/**
 * Represents a set of dyed blocks, including subtypes like stairs, slabs, and walls.
 */
public enum DyedBlockSet {
    WHITE(DyeColor.WHITE, Items.WHITE_DYE),
    ORANGE(DyeColor.ORANGE, Items.ORANGE_DYE),
    MAGENTA(DyeColor.MAGENTA, Items.MAGENTA_DYE),
    LIGHT_BLUE(DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE),
    YELLOW(DyeColor.YELLOW, Items.YELLOW_DYE),
    LIME(DyeColor.LIME, Items.LIME_DYE),
    PINK(DyeColor.PINK, Items.PINK_DYE),
    GRAY(DyeColor.GRAY, Items.GRAY_DYE),
    LIGHT_GRAY(DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE),
    CYAN(DyeColor.CYAN, Items.CYAN_DYE),
    PURPLE(DyeColor.PURPLE, Items.PURPLE_DYE),
    BLUE(DyeColor.BLUE, Items.BLUE_DYE),
    BROWN(DyeColor.BROWN, Items.BROWN_DYE),
    GREEN(DyeColor.GREEN, Items.GREEN_DYE),
    RED(DyeColor.RED, Items.RED_DYE),
    BLACK(DyeColor.BLACK, Items.BLACK_DYE);

    private final DyeColor color;
    private final String colorName;
    private final Item dyeItem;

    private DeferredBlock<Block> block;
    private DeferredBlock<SlabBlock> slabBlock;
    private DeferredBlock<StairBlock> stairBlock;
    private DeferredBlock<WallBlock> wallBlock;

    DyedBlockSet(DyeColor color, Item dyeItem) {
        this.color = color;
        this.colorName = color.getName();
        this.dyeItem = dyeItem;
    }

    public DyeColor getColor() {
        return color;
    }

    public String getColorName() {
        return colorName;
    }

    public Item getDyeItem() {
        return dyeItem;
    }

    public MapColor getMapColor() {
        return color.getMapColor();
    }

    public void registerBlock(DeferredRegister.Blocks registry, String baseName, Properties properties, MapColor mapColor) {
        this.block = registry.register(colorName + "_" + baseName, supply(properties.mapColor(mapColor)));
        MillenaireItems.registerBlockItem(block);
    }

    public void registerBlockPlural(DeferredRegister.Blocks registry, String baseName, Properties properties, MapColor mapColor) {
        registerBlock(registry, baseName + "s", properties, mapColor);
    }

    public void registerSlabBlock(DeferredRegister.Blocks registry, String baseName, Properties properties) {
        this.slabBlock = registry.register(colorName + "_" + baseName + "_slab", supply(SlabBlock::new, properties));
        MillenaireItems.registerBlockItem(slabBlock);
    }

    public void registerStairBlock(DeferredRegister.Blocks registry, String baseName, DeferredBlock<?> parent, Properties properties) {
        this.stairBlock = registry.register(colorName + "_" + baseName + "_stairs", supplyStairs(StairBlock::new, parent, properties));
        MillenaireItems.registerBlockItem(stairBlock);
    }

    public void registerWallBlock(DeferredRegister.Blocks registry, String baseName, Properties properties) {
        this.wallBlock = registry.register(colorName + "_" + baseName + "_wall", supply(WallBlock::new, properties));
        MillenaireItems.registerBlockItem(wallBlock);
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
}
