package com.github.moistmason.millenaire.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;

public class MillenaireBlockModelProvider extends BlockModelProvider {
    public MillenaireBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    protected void slabBottom() {

    }
}
