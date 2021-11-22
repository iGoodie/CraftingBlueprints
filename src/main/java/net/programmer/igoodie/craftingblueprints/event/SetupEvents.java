package net.programmer.igoodie.craftingblueprints.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.programmer.igoodie.craftingblueprints.init.ModModels;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents {

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        ModModels.TileEntityRenderers.register();
    }

}
