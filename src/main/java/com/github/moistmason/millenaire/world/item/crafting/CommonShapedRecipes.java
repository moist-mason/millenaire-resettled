package com.github.moistmason.millenaire.world.item.crafting;

import com.github.moistmason.millenaire.util.RegistryUtil;
import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;
import java.util.Optional;

/**
 * Utility class for common shaped recipe building.
 * There are already builder shortcuts in the RecipeProvider class, but they still require some additional setup, which I don't like.
 * This class makes the whole process easier.
 * @author moist-mason
 */
public class CommonShapedRecipes {
    public static void twoSquaredRecipe(RecipeOutput output, ItemLike base, ItemLike result) {
        twoSquaredRecipe(output, base, result, 1);
    }

    public static void twoSquaredRecipe(RecipeOutput output, ItemLike base, ItemLike result, int count) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                .pattern("## ")
                .pattern("## ")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base)).save(output);
    }

    public static <T extends SlabBlock> void slabRecipe(RecipeOutput output, DeferredBlock<?> base, DeferredBlock<T> result) {
        slabRecipe(output, base.get(), result);
    }

    public static <T extends SlabBlock> void slabRecipe(RecipeOutput output, ItemLike base, DeferredBlock<T> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base)).save(output);
    }

    public static <T extends StairBlock> void stairRecipe(RecipeOutput output, DeferredBlock<?> base, DeferredBlock<T> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base)).save(output);
    }

    public static <T extends WallBlock> void wallRecipe(RecipeOutput output, DeferredBlock<?> base, DeferredBlock<T> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .pattern("###")
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base)).save(output);
    }

    /**
     * Partly on net/minecraft/data/recipes/RecipeProvider
     * @see net.minecraft.data.recipes.RecipeProvider
     */
    private static String getHasName(ItemLike item) {
        String name;

        // check if the item is vanilla, if not check the mod registry.
        if (BuiltInRegistries.ITEM.containsValue(item.asItem())) {
            name = BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
        } else {
            name = RegistryUtil.getId(MillenaireItems.MILLENAIRE_ITEMS, item.asItem());
        }

        return "has_" + name;
    }

    /**
     * Single-item criterion trigger. Based on net/minecraft/data/recipes/RecipeProvider
     * @see net.minecraft.data.recipes.RecipeProvider
     */
    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        ItemPredicate predicate = ItemPredicate.Builder.item().of(itemLike).build();
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(predicate)));
    }
}
