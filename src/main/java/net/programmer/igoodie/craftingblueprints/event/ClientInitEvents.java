package net.programmer.igoodie.craftingblueprints.event;

import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;
import net.programmer.igoodie.craftingblueprints.init.ModModels;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientInitEvents {

    @SubscribeEvent
    public static void onColorHandlerRegister(ColorHandlerEvent.Item event) {
        ModModels.ItemColors.register(event.getItemColors());
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {
        ModModels.BakedModels.register(event.getModelRegistry());
    }

    @SubscribeEvent
    public static void onTextureStitchEvent(TextureStitchEvent.Pre event) {
        if (event.getMap().getTextureLocation() == AtlasTexture.LOCATION_BLOCKS_TEXTURE) {
            event.addSprite(CraftingBlueprints.id("item/blueprint/icon/igoodie"));
            event.addSprite(CraftingBlueprints.id("item/blueprint/icon/sword"));
            event.addSprite(CraftingBlueprints.id("item/blueprint/icon/pickaxe"));
            event.addSprite(CraftingBlueprints.id("item/blueprint/icon/asteriks"));
        }

    }

}