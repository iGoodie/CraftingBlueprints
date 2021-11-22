package net.programmer.igoodie.craftingblueprints.init;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;

public class ModIcons {

    public static final BiMap<String, ResourceLocation> REGISTRY = HashBiMap.create();

    public static ResourceLocation IGOODIE = registerIcon("igoodie");
    public static ResourceLocation CUSTOM0 = registerIcon("custom0");
    public static ResourceLocation CUSTOM1 = registerIcon("custom1");
    public static ResourceLocation CUSTOM2 = registerIcon("custom2");
    public static ResourceLocation CUSTOM3 = registerIcon("custom3");
    public static ResourceLocation CUSTOM4 = registerIcon("custom4");
    public static ResourceLocation CUSTOM5 = registerIcon("custom5");
    public static ResourceLocation CUSTOM6 = registerIcon("custom6");
    public static ResourceLocation CUSTOM7 = registerIcon("custom7");
    public static ResourceLocation CUSTOM8 = registerIcon("custom8");
    public static ResourceLocation CUSTOM9 = registerIcon("custom9");
    public static ResourceLocation EMPTY = registerIcon("empty");
    public static ResourceLocation SWORD = registerIcon("sword");
    public static ResourceLocation PICKAXE = registerIcon("pickaxe");

    public static void stitchAll(TextureStitchEvent.Pre event) {
        for (ResourceLocation textureLocation : REGISTRY.values()) {
            event.addSprite(textureLocation);
        }
    }

    public static String getNameOf(ResourceLocation textureLocation) {
        return REGISTRY.inverse().get(textureLocation);
    }

    private static ResourceLocation registerIcon(String name) {
        ResourceLocation textureLocation = CraftingBlueprints.id("item/blueprint/icon/" + name);
        REGISTRY.put(name, textureLocation);
        return textureLocation;
    }

}
