package dev.mrsterner.darkrites.common.mixin;

import ladysnake.requiem.core.remnant.MutableRemnantState;
import moriyashiine.bewitchment.common.registry.BWComponents;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MutableRemnantState.class, remap = false)
public class MutableRemnantStateMixin {
    @Inject(at = @At("HEAD"), method = "canDissociateFrom", cancellable = true)
    private void canDissociateFrom(MobEntity possessed, CallbackInfoReturnable<Boolean> callbackInfo) {
        if (BWComponents.FAMILIAR_COMPONENT.get(possessed).isFamiliar()) {
            callbackInfo.setReturnValue(true);
        }
    }
}
