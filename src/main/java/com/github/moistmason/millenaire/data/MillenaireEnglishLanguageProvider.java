package com.github.moistmason.millenaire.data;

import com.github.moistmason.library.data.LibraryEnglishLanguageProvider;
import com.github.moistmason.library.registry.RegistryUtil;
import com.github.moistmason.millenaire.world.block.MillenaireBlocks;
import com.github.moistmason.millenaire.world.item.MillenaireItems;
import com.github.moistmason.millenaire.world.item.group.MillenaireCreativeTabs;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Predicate;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;

public class MillenaireEnglishLanguageProvider extends LibraryEnglishLanguageProvider {
    public MillenaireEnglishLanguageProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    @Override
    protected void addTranslations() {
        add(MillenaireItems.MILLENAIRE_ITEMS, "item", (item) -> !(item instanceof BlockItem));
        add(MillenaireBlocks.MILLENAIRE_BLOCKS, "block", excludedBlockPredicate());
        addBlock(MillenaireBlocks.ORNAMENTED_GOLD_BLOCK, "Ornamented Block of Gold");

        addCreativeTab(MillenaireCreativeTabs.BLOCK_TAB, "Millénaire Blocks");
        addCreativeTab(MillenaireCreativeTabs.ITEM_TAB, "Millénaire Items");
    }

    public <T extends Block> Predicate<T> excludedBlockPredicate() {
        List<String> toExclude = List.of("ornamented_gold_block");
        return block -> !RegistryUtil.getId(MillenaireBlocks.MILLENAIRE_BLOCKS, block).equals(toExclude.stream().findAny().get());
    }
}
