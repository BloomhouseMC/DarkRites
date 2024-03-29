package mrsterner.darkrites.common.registry;

import mrsterner.darkrites.common.ritualfunction.DecayRitualFunction;
import mrsterner.darkrites.common.util.RegistryUtils;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import moriyashiine.bewitchment.common.registry.BWRegistries;

public class DRRitualFunctions {

    public static final RitualFunction DECAY = new DecayRitualFunction();

    public static void init() {
        register("decay", DECAY);
    }

    private static void register(String name, RitualFunction ritualFunction) {
        RegistryUtils.register(BWRegistries.RITUAL_FUNCTIONS, name, ritualFunction);
    }
}
