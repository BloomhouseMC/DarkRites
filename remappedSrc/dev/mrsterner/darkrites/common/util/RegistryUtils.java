package dev.mrsterner.darkrites.common.util;

import dev.mrsterner.darkrites.common.DarkRites;
import net.minecraft.util.registry.Registry;

public class RegistryUtils {
    public static <T> void register(Registry<? super T> registry, String name, T entry) {
        Registry.register(registry, DarkRites.id(name), entry);
    }
}
