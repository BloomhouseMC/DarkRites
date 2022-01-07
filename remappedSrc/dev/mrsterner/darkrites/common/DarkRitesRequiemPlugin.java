package dev.mrsterner.darkrites.common;

import ladysnake.requiem.api.v1.RequiemPlugin;
import ladysnake.requiem.api.v1.event.requiem.PossessionStartCallback;
import moriyashiine.bewitchment.common.registry.BWComponents;
import net.minecraft.nbt.NbtCompound;

public class DarkRitesRequiemPlugin implements RequiemPlugin {
    @Override
    public void onRequiemInitialize() {
        PossessionStartCallback.EVENT.register(DarkRites.id("allow_familiars"), (target, possessor, simulate) -> {
            NbtCompound entityTag = new NbtCompound();
            target.saveSelfNbt(entityTag);

            if (entityTag.contains("Owner") && possessor.getUuid().equals(entityTag.getUuid("Owner"))) {
                if (BWComponents.FAMILIAR_COMPONENT.get(target).isFamiliar()) {
                    return PossessionStartCallback.Result.ALLOW;
                }
            }
            return PossessionStartCallback.Result.PASS;
        });
    }
}
