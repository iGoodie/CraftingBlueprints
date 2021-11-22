package net.programmer.igoodie.craftingblueprints;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.programmer.igoodie.craftingblueprints.init.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CraftingBlueprints.MOD_ID)
public class CraftingBlueprints {

    public static final String MOD_ID = "crafting_blueprints";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation id(String id) {
        return new ResourceLocation(MOD_ID, id);
    }

    /* --------------------------------- */

    public CraftingBlueprints() {
        registerDeferredRegistries();
    }

    private void registerDeferredRegistries() {
        ModItems.REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
