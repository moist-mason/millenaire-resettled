package com.github.moistmason.millenaire.world.item.group;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.item.group.MillenaireCreativeTabBuilders.BLOCK_TAB_BUILDER;
import static com.github.moistmason.millenaire.world.item.group.MillenaireCreativeTabBuilders.ITEM_TAB_BUILDER;

public class MillenaireCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> MILLENAIRE_CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCK_TAB = register("millenaire_blocks", supply(BLOCK_TAB_BUILDER));
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEM_TAB = register("millenaire_items", supply(ITEM_TAB_BUILDER));

    public static <T extends CreativeModeTab> DeferredHolder<CreativeModeTab, T> register(String id, Supplier<T> data) {
        return MILLENAIRE_CREATIVE_MODE_TABS.register(id, data);
    }

    public static Supplier<CreativeModeTab> supply(CreativeModeTab.Builder builder) {
        return builder::build;
    }
}
