package com.github.moistmason.millenaire.util;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Miscellaneous methods related to mod registries.
 * @author moist-mason
 */
public class RegistryUtil {

    /**
     * @return The given registry's components in a list format.
     */
    public static <T> List<T> toList(DeferredRegister<T> registry) {
        return toList(registry, null);
    }

    /**
     * @return The given registry's components in a list format, filtered based on the given predicate.
     */
    public static <T> List<T> toList(DeferredRegister<T> registry, Predicate<T> predicate) {
        List<T> list = new LinkedList<>();

        for (DeferredHolder<T, ? extends T> entry : registry.getEntries()) {
            list.add(entry.get());
        }

        if (predicate != null) {
            list = list.stream().filter(predicate).toList();
        }

        return list;
    }

    /**
     * @return The given registry's components in a map format, with keys being the components themselves, and the values being
     * the identifier/resource location.
     */
    public static <T> Map<T, String> toIdMap(DeferredRegister<T> registry) {
        Map<T, String> map = new LinkedHashMap<>();

        for (DeferredHolder<T, ? extends T> entry : registry.getEntries()) {
            map.put(entry.get(), entry.getId().getPath());
        }

        return map;
    }

    /**
     * @return the given entry's ID.
     */
    public static <T> String getId(DeferredRegister<T> registry, T entry) {
        Map<T, String> map = toIdMap(registry);

        if (!map.containsKey(entry)) {
            throw new IllegalArgumentException("Unfound entry " + entry.toString());
        }

        return map.get(entry);
    }
}
