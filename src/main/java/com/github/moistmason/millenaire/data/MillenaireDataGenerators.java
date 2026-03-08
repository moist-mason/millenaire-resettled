package com.github.moistmason.millenaire.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class MillenaireDataGenerators {

    @SubscribeEvent
    public static void gather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput out = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new MillenaireBlockTagsProvider(out, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new LootTableProvider(out, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(MillenaireBlockLootProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(event.includeClient(), new MillenaireBlockStateProvider(out, fileHelper));
        generator.addProvider(event.includeClient(), new MillenaireItemModelProvider(out, fileHelper));
    }
}
