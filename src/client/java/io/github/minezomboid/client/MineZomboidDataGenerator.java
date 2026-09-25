package io.github.minezomboid.client;

import io.github.minezomboid.data.ModLanguageProvider;
import io.github.minezomboid.data.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MineZomboidDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLanguageProvider::new);
	}
}
