package com.github.moistmason.millenaire.world.item.group;

import com.github.moistmason.millenaire.world.block.MillenaireBlocks;
import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public class MillenaireCreativeTabBuilders {
    public static CreativeModeTab.Builder BLOCK_TAB_BUILDER = CreativeModeTab.builder()
            .icon(itemStack(MillenaireBlocks.PLAIN_TIMBER_FRAME))
            .title(Component.translatable("itemGroup.millenaire.millenaire_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                for (Block block : MillenaireBlocks.list()) {
                    output.accept(block);
                }
            });

    //TODO change icon to gold coin when added!
    public static CreativeModeTab.Builder ITEM_TAB_BUILDER = CreativeModeTab.builder()
            .icon(itemStack(MillenaireItems.LIME_DUST)) // change to gold when added!
            .title(Component.translatable("itemGroup.millenaire.millenaire_items"))
            .displayItems((itemDisplayParameters, output) -> {
                for (Item item : MillenaireItems.list()) {
                    output.accept(item);
                }
            });

    public static <T extends Block> Supplier<ItemStack> itemStack(DeferredBlock<T> block) {
        return () -> new ItemStack(block);
    }

    public static <T extends Item> Supplier<ItemStack> itemStack(DeferredItem<T> item) {
        return () -> new ItemStack(item.get());
    }
}
