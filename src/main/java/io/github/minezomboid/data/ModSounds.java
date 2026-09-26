package io.github.minezomboid.data;

import io.github.minezomboid.utils.constants.MineZomboidConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final ResourceKey<SoundEvent> MEDICAL_KIT_USE_KEY = ResourceKey.create(Registries.SOUND_EVENT, MineZomboidConstants.id("medical_kit_use"));
    public static SoundEvent MEDICAL_KIT_USE;

    public static void registerModSounds() {
        MEDICAL_KIT_USE = Registry.register(
            BuiltInRegistries.SOUND_EVENT,
            MEDICAL_KIT_USE_KEY,
            SoundEvent.createVariableRangeEvent(
                MEDICAL_KIT_USE_KEY.location()
            )
        );
    }
}
