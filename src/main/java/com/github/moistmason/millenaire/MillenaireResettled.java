package com.github.moistmason.millenaire;

import com.github.moistmason.millenaire.world.block.MillenaireBlocks;
import com.github.moistmason.millenaire.world.item.group.MillenaireCreativeTabs;
import com.github.moistmason.millenaire.world.item.MillenaireItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

@Mod(value = MillenaireResettled.MOD_ID)
public class MillenaireResettled {
    public static final String MOD_ID = "millenaire";

    public MillenaireResettled(IEventBus bus) {
        registries().forEach(reg -> reg.register(bus));
    }

    private static List<DeferredRegister<?>> registries() {
        return List.of(
                MillenaireItems.MILLENAIRE_ITEMS, MillenaireBlocks.MILLENAIRE_BLOCKS,
                MillenaireCreativeTabs.CREATIVE_MODE_TABS
        );
    }
}
