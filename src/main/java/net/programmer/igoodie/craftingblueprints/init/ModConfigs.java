package net.programmer.igoodie.craftingblueprints.init;

import net.minecraftforge.fml.loading.FMLPaths;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;
import net.programmer.igoodie.craftingblueprints.config.TexturesConfig;

import java.io.File;

public class ModConfigs {

    public static TexturesConfig TEXTURES = new TexturesConfig().readConfig(getConfigFile("textures.json"));

    private static File getConfigFile(String name) {
        return new File(FMLPaths.CONFIGDIR.get().toString()
                + File.separator + CraftingBlueprints.MOD_ID
                + File.separator + name);
    }

}
