package io.github.minezomboid.data;

import io.github.minezomboid.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.PLASTIC_BOTTLE_ITEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WATER_BOTTLE_ITEM, ModelTemplates.FLAT_ITEM);
    }
}
