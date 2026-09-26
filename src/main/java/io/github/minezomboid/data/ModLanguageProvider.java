package io.github.minezomboid.data;

import io.github.minezomboid.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PLASTIC_ITEM, "Plastic");
        translationBuilder.add(ModItems.PLASTIC_BOTTLE_ITEM, "Plastic Bottle");
        translationBuilder.add(ModItems.WATER_BOTTLE_ITEM, "Water Bottle");
        translationBuilder.add(ModItems.DUCT_TAPE_ITEM, "Duct Tape");
        translationBuilder.add(ModItems.PAPER_ITEM, "Paper");
        translationBuilder.add(ModItems.MEDICAL_KIT_ITEM, "Medical Kit");
        translationBuilder.add(ModItems.EMPTY_METAL_BOX_ITEM, "Empty Metal Box");
    }
}
