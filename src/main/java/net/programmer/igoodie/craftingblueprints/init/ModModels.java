package net.programmer.igoodie.craftingblueprints.init;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.programmer.igoodie.craftingblueprints.block.render.RendererManufacturingBench;
import net.programmer.igoodie.craftingblueprints.item.color.ColorBlueprintIcon;
import net.programmer.igoodie.craftingblueprints.item.model.ModelCraftingBlueprint;
import net.programmer.igoodie.craftingblueprints.item.model.ReplacementItemModel;

import java.util.Map;

public class ModModels {

    public static class TileEntityRenderers {
        public static void register() {
            ClientRegistry.bindTileEntityRenderer(ModBlocks.TE_MANUFACTURING_BENCH.get(), RendererManufacturingBench::new);
        }
    }

    public static class ItemColors {
        public static void register(net.minecraft.client.renderer.color.ItemColors colors) {
            colors.register(ColorBlueprintIcon.INSTANCE, ColorBlueprintIcon.INSTANCE.appliedItems());
        }
    }

    public static class BakedModels {
        public static void replaceModels(Map<ResourceLocation, IBakedModel> modelRegistry) {
            replaceBakedModel(modelRegistry,
                    new ModelResourceLocation(ModItems.CRAFTING_BLUEPRINT.getId(), "inventory"),
                    ModelCraftingBlueprint::new);
        }

        private static void replaceBakedModel(Map<ResourceLocation, IBakedModel> modelRegistry, ModelResourceLocation id, ReplacementItemModel.ModelGenerator modelGenerator) {
            IBakedModel existingModel = modelRegistry.get(id);

            if (existingModel == null) {
                throw new InternalError("Did not find expected vanilla baked model -> " + id);
            }

            if (existingModel instanceof ReplacementItemModel) {
                throw new InternalError("Tried to replace model twice -> " + id);
            }

            modelRegistry.put(id, new ReplacementItemModel(existingModel, modelGenerator));
        }
    }

}
