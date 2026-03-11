package com.github.moistmason.millenaire.data;

import com.github.moistmason.millenaire.MillenaireResettled;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.github.moistmason.millenaire.world.item.MillenaireItems.LIME_DUST;
import static com.github.moistmason.millenaire.world.item.MillenaireItems.LIME_PLASTER_BUCKET;

public class MillenaireItemModelProvider extends ItemModelProvider {
    public MillenaireItemModelProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, MillenaireResettled.MOD_ID, fileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(LIME_DUST.asItem());
        basicItem(LIME_PLASTER_BUCKET.asItem());
    }
}
