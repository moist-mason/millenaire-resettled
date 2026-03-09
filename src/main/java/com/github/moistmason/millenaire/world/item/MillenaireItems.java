package com.github.moistmason.millenaire.world.item;

import com.github.moistmason.millenaire.util.RegistryUtil;
import net.minecraft.core.Holder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;

public class MillenaireItems {
    public static final DeferredRegister.Items MILLENAIRE_ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> LIME_DUST = registerSimple("lime_dust");
    public static final DeferredItem<Item> LIME_PLASTER_BUCKET = registerSimple("lime_plaster_bucket", new Item.Properties().stacksTo(1));

    private static DeferredItem<Item> registerSimple(String id) {
        return MILLENAIRE_ITEMS.registerSimpleItem(id);
    }

    private static DeferredItem<Item> registerSimple(String id, Item.Properties properties) {
        return MILLENAIRE_ITEMS.registerSimpleItem(id, properties);
    }

    public static void registerBlockItem(Holder<Block> block) {
        MILLENAIRE_ITEMS.registerSimpleBlockItem(block);
    }

    public static List<Item> list() {
        return RegistryUtil.toList(MILLENAIRE_ITEMS, item -> !(item instanceof BlockItem));
    }
}
