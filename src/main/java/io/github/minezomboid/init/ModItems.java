package io.github.minezomboid.init;

import io.github.minezomboid.utils.constants.MineZomboidConstants;
import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModItems {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModItems.class);

    public static final ResourceKey<Item> PLASTIC_BOTTLE_KEY = ModItemIds.create("plastic_bottle");
    public static final ResourceKey<Item> WATER_BOTTLE_KEY = ModItemIds.create("water_bottle");

    public static final Item PLASTIC_BOTTLE_ITEM = register(PLASTIC_BOTTLE_KEY, PlasticBottleItem::new, new Item.Properties());
    public static final Item WATER_BOTTLE_ITEM = register(WATER_BOTTLE_KEY, WaterBottleItem::new, new Item.Properties().stacksTo(1));

    public static void registerModItems() {
        ModItems.LOGGER.info("{} - registerModItems - message: registering mod item for {} project", ModItems.class.getSimpleName(), MineZomboidConstants.MOD_ID);

        ItemGroupEvents
            .modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
            .register(entries -> {
                entries.accept(PLASTIC_BOTTLE_ITEM);
                entries.accept(WATER_BOTTLE_ITEM);
            });
    }

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        Item item = itemFactory.apply(settings);
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
}
