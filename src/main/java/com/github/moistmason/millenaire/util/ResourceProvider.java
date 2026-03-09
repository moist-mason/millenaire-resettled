package com.github.moistmason.millenaire.util;

import net.minecraft.resources.ResourceLocation;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static net.minecraft.resources.ResourceLocation.DEFAULT_NAMESPACE;

public class ResourceProvider {
    public static ResourceLocation vanillaBlock(String id) {
        return vanillaResource("block/" + id);
    }

    public static ResourceLocation modBlock(String id) {
        return modResource("block/" + id);
    }

    private static ResourceLocation vanillaResource(String id) {
        return ResourceLocation.fromNamespaceAndPath(DEFAULT_NAMESPACE, id);
    }

    public static ResourceLocation modResource(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}
