package com.github.moistmason.millenaire.world.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class MillenaireBlockProperties {
    public static final Properties WOOD_DECORATION_PROPERTIES = Properties.of()
            .strength(2, 5)
            .sound(SoundType.WOOD);

    public static final Properties STONE_DECORATION_PROPERTIES = Properties.of()
            .strength(1.5F, 10)
            .sound(SoundType.STONE);
}
