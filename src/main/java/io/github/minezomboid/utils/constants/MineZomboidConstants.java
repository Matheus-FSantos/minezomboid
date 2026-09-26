package io.github.minezomboid.utils.constants;

import net.minecraft.resources.ResourceLocation;

public class MineZomboidConstants {
    public static final String MOD_ID = "minezomboid";

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
