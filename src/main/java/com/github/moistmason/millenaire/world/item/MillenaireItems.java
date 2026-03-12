package com.github.moistmason.millenaire.world.item;

import com.github.moistmason.library.registry.RegistryUtil;
import com.github.moistmason.library.world.item.ArmorProtectionMapBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

import static com.github.moistmason.millenaire.world.item.MillenaireItemProperties.*;
import static com.github.moistmason.library.registry.ItemRegistrySuppliers.supply;
import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;

public class MillenaireItems {
    public static final DeferredRegister.Items MILLENAIRE_ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> LIME_DUST = register("lime_dust", supply(new Item.Properties()));
    public static final DeferredItem<Item> LIME_PLASTER_BUCKET = register("lime_plaster_bucket", supply(LIME_BUCKET_PROPERTIES));

    private static <T extends Item> DeferredItem<T> register(String name, Supplier<T> data) {
        return MILLENAIRE_ITEMS.register(name, data);
    }

    public static void registerBlockItem(Holder<Block> block) {
        MILLENAIRE_ITEMS.registerSimpleBlockItem(block);
    }

    public static List<Item> list() {
        return RegistryUtil.toList(MILLENAIRE_ITEMS, item -> !(item instanceof BlockItem));
    }
}
