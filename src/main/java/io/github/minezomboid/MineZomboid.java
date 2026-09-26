package io.github.minezomboid;

import io.github.minezomboid.data.ModSounds;
import io.github.minezomboid.init.ModItems;
import io.github.minezomboid.utils.constants.MineZomboidConstants;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineZomboid implements ModInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(MineZomboid.class);

	@Override
	public void onInitialize() {
		MineZomboid.LOGGER.info("{} - onInitialize - message: hello fabric world!", getClass().getSimpleName());
		ModItems.registerModItems();
		ModSounds.registerModSounds();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MineZomboidConstants.MOD_ID, path);
	}
}
