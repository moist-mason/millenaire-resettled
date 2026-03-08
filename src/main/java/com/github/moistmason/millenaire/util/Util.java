package com.github.moistmason.millenaire.util;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Util {
    public static <T> List<T> registryAsList(DeferredRegister<T> registry) {
        return registryAsList(registry, null);
    }

    public static <T> List<T> registryAsList(DeferredRegister<T> register, Predicate<T> predicate) {
        List<T> list = new LinkedList<>();

        for (DeferredHolder<T, ? extends T> entry : register.getEntries()) {
            list.add(entry.get());
        }

        if (predicate != null) {
            list = list.stream().filter(predicate).toList();
        }

        return list;
    }
}
