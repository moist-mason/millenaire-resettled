package com.github.moistmason.millenaire.util;

import net.minecraft.resources.ResourceLocation;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static net.minecraft.resources.ResourceLocation.DEFAULT_NAMESPACE;

public class ResourceProvider {
    public static ResourceLocation vanillaBlock(String id) {
        return vanilla("block/" + id);
    }

    public static ResourceLocation modBlock(String id) {
        return mod("block/" + id);
    }

    private static ResourceLocation vanilla(String id) {
        return ResourceLocation.fromNamespaceAndPath(DEFAULT_NAMESPACE, id);
    }

    private static ResourceLocation mod(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}
