package com.github.moistmason.millenaire.data;

import com.github.moistmason.library.data.LibraryRecipeProvider;
import com.github.moistmason.millenaire.world.block.DyedBlockSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;
import static com.github.moistmason.millenaire.world.item.MillenaireItems.*;
import static net.minecraft.world.item.Items.*;

public class MillenaireRecipeProvider extends LibraryRecipeProvider implements IConditionBuilder {
    public MillenaireRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, MILLENAIRE_ITEMS);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        buildBlockCraftingRecipes(output);
        buildItemCraftingRecipes(output);
        buildSmeltingRecipes(output);
        buildStonecutterRecipes(output);
    }

    protected void buildBlockCraftingRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, PLAIN_TIMBER_FRAME)
                .pattern("AAA")
                .pattern("BBB")
                .pattern("AAA")
                .define('A', STICK)
                .define('B', ItemTags.LOGS)
                .unlockedBy("has_any_log", has(ItemTags.LOGS)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CROSS_TIMBER_FRAME)
                .pattern("BAB")
                .pattern("ABA")
                .pattern("BAB")
                .define('A', STICK)
                .define('B', ItemTags.LOGS)
                .unlockedBy("has_any_log", has(ItemTags.LOGS)).save(output);

        slabRecipe(output, PLAIN_TIMBER_FRAME, TIMBER_FRAME_SLAB);
        stairRecipe(output, PLAIN_TIMBER_FRAME, TIMBER_FRAME_STAIRS);

        twoSquaredRecipe(output, RecipeCategory.BUILDING_BLOCKS, WHEAT, THATCH);
        slabRecipe(output, THATCH, THATCH_SLAB);
        stairRecipe(output, THATCH, THATCH_STAIRS);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD)
                .requires(LIME_PLASTER_BUCKET)
                .requires(MUD)
                .unlockedBy("has_lime_plaster_bucket", has(LIME_PLASTER_BUCKET))
                .unlockedBy(hasName(MUD), has(MUD)).save(output);

        twoSquaredRecipe(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD, PLASTERED_MUD_BRICKS, 4);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICKS)
                .requires(LIME_PLASTER_BUCKET)
                .requires(Blocks.MUD_BRICKS)
                .unlockedBy(hasName(LIME_PLASTER_BUCKET), has(LIME_PLASTER_BUCKET))
                .unlockedBy(hasName(MUD_BRICKS), has(MUD_BRICKS)).save(output, ResourceLocation.fromNamespaceAndPath(MOD_ID, "plastered_mud_brick_from_mud_brick"));

        slabRecipe(output, PLASTERED_MUD_BRICKS, PLASTERED_MUD_BRICK_SLAB);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_SLAB)
                .requires(LIME_PLASTER_BUCKET)
                .requires(Blocks.MUD_BRICK_SLAB)
                .unlockedBy(hasName(LIME_PLASTER_BUCKET), has(LIME_PLASTER_BUCKET))
                .unlockedBy(hasName(MUD_BRICK_SLAB), has(MUD_BRICK_SLAB)).save(output, modResource("plastered_mud_brick_slab_from_mud_brick_slab"));

        stairRecipe(output, PLASTERED_MUD_BRICKS, PLASTERED_MUD_BRICK_STAIRS);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_STAIRS)
                .requires(LIME_PLASTER_BUCKET)
                .requires(Blocks.MUD_BRICK_STAIRS)
                .unlockedBy(hasName(LIME_PLASTER_BUCKET), has(LIME_PLASTER_BUCKET))
                .unlockedBy(hasName(MUD_BRICK_STAIRS), has(MUD_BRICK_STAIRS)).save(output, modResource("plastered_mud_brick_stairs_from_mud_brick_stairs"));

        wallRecipe(output, PLASTERED_MUD_BRICKS, PLASTERED_MUD_BRICK_WALL);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_WALL)
                .requires(LIME_PLASTER_BUCKET)
                .requires(Blocks.MUD_BRICK_WALL)
                .unlockedBy(hasName(LIME_PLASTER_BUCKET), has(LIME_PLASTER_BUCKET))
                .unlockedBy("has_mud_brick_wall", has(MUD_BRICK_WALL)).save(output, modResource("plastered_mud_brick_wall_from_mud_brick_wall"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DECORATED_PLASTERED_MUD_BRICKS)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', DIAMOND)
                .define('B', PLASTERED_MUD_BRICKS)
                .unlockedBy(hasName(PLASTERED_MUD_BRICKS), has(PLASTERED_MUD_BRICKS)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ORNAMENTED_PLASTERED_MUD_BRICK)
                .pattern(" A ")
                .pattern(" A ")
                .define('A', PLASTERED_MUD_BRICK_SLAB)
                .unlockedBy(hasName(PLASTERED_MUD_BRICK_SLAB), has(PLASTERED_MUD_BRICK_SLAB)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ORNAMENTED_GOLD_BLOCK)
                .pattern("BAB")
                .pattern("ACA")
                .pattern("BAB")
                .define('A', REDSTONE)
                .define('B', LAPIS_LAZULI)
                .define('C', GOLD_BLOCK)
                .unlockedBy(hasName(GOLD_BLOCK), has(GOLD_BLOCK)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BYZANTINE_MOSAIC)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', REDSTONE)
                .define('B', GOLD_BLOCK)
                .unlockedBy(hasName(GOLD_BLOCK), has(GOLD_BLOCK)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BYZANTINE_FRESCO)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', LAPIS_LAZULI)
                .define('B', GOLD_BLOCK)
                .unlockedBy(hasName(GOLD_BLOCK), has(GOLD_BLOCK)).save(output);

        twoSquaredRecipe(output, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_CONCRETE, LIGHT_BLUE_CONCRETE_BRICKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_CHISELED_CONCRETE)
                .pattern("A")
                .pattern("A")
                .define('A', LIGHT_BLUE_CONCRETE)
                .unlockedBy(hasName(LIGHT_BLUE_CONCRETE), has(LIGHT_BLUE_CONCRETE)).save(output);

        slabRecipe(output, DIRT, DIRT_SLAB);
        twoSquaredRecipe(output, RecipeCategory.BUILDING_BLOCKS, DIRT, DIRT_WALL);
        slabRecipe(output, DIRT_PATH, DIRT_PATH_SLAB);

        for (DyedBlockSet set : paintedBricksList) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.getBlock())
                    .requires(PLASTERED_MUD_BRICKS)
                    .requires(set.getDyeItem())
                    .unlockedBy(hasName(PLASTERED_MUD_BRICKS), has(PLASTERED_MUD_BRICKS))
                    .unlockedBy(hasName(set.getDyeItem()), has(set.getDyeItem())).save(output);

            slabRecipe(output, set.getBlock(), set.getSlabBlock());
            stairRecipe(output, set.getBlock(), set.getStairBlock());
            wallRecipe(output, set.getBlock(), set.getWallBlock());

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.getSlabBlock())
                    .requires(PLASTERED_MUD_BRICK_SLAB)
                    .requires(set.getDyeItem())
                    .unlockedBy(hasName(PLASTERED_MUD_BRICK_SLAB), has(PLASTERED_MUD_BRICK_SLAB))
                    .unlockedBy(hasName(set.getDyeItem()), has(set.getDyeItem()))
                    .save(output, modResource(set.getSlabBlock().getId().getPath() + "_from_" + set.getColorName() + "_dye"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.getStairBlock())
                    .requires(PLASTERED_MUD_BRICK_STAIRS)
                    .requires(set.getDyeItem())
                    .unlockedBy(hasName(PLASTERED_MUD_BRICK_STAIRS), has(PLASTERED_MUD_BRICK_STAIRS))
                    .unlockedBy(hasName(set.getDyeItem()), has(set.getDyeItem()))
                    .save(output, modResource(set.getStairBlock().getId().getPath() + "_from_" + set.getColorName() + "_dye"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.getWallBlock())
                    .requires(PLASTERED_MUD_BRICK_WALL)
                    .requires(set.getDyeItem())
                    .unlockedBy(hasName(PLASTERED_MUD_BRICK_WALL), has(PLASTERED_MUD_BRICK_WALL))
                    .unlockedBy(hasName(set.getDyeItem()), has(set.getDyeItem()))
                    .save(output, modResource(set.getWallBlock().getId().getPath() + "_from_" + set.getColorName() + "_dye"));
        }
    }

    protected void buildItemCraftingRecipes(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LIME_PLASTER_BUCKET)
                .requires(WATER_BUCKET)
                .requires(Blocks.SAND)
                .requires(LIME_DUST.get())
                .unlockedBy("has_lime_dust", has(LIME_DUST.get())).save(output);
    }

    protected void buildSmeltingRecipes(RecipeOutput output) {
        simpleSmeltingRecipe(output, RecipeCategory.MISC, CALCITE, LIME_DUST);
    }

    protected void buildStonecutterRecipes(RecipeOutput output) {
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICKS, PLASTERED_MUD);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_SLAB, PLASTERED_MUD, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_SLAB, PLASTERED_MUD_BRICKS, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_STAIRS, PLASTERED_MUD);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_STAIRS, PLASTERED_MUD_BRICKS);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_WALL, PLASTERED_MUD);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, PLASTERED_MUD_BRICK_WALL, PLASTERED_MUD_BRICKS);
    }

    // TODO: Remove after Library update.
    private static ResourceLocation modResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
