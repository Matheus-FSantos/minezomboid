package io.github.minezomboid.init;

import io.github.minezomboid.MineZomboid;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, MineZomboid.id(name));
    }
}
