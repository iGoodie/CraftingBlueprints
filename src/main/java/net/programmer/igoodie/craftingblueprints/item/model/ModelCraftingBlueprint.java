package net.programmer.igoodie.craftingblueprints.item.model;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.programmer.igoodie.craftingblueprints.item.ItemCraftingBlueprint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ModelCraftingBlueprint extends DynamicItemModel {

    public ModelCraftingBlueprint(IBakedModel baseModel, @NotNull CompoundNBT stackNBT) {
        super(baseModel, stackNBT);
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand) {
        List<BakedQuad> bakedQuads = super.getQuads(state, side, rand);

        if (side != null) {
            return bakedQuads;
        }

        TextureAtlasSprite iconSprite = getIconSprite();

        List<BakedQuad> generatedQuads = new LinkedList<>();

        for (BakedQuad bakedQuad : bakedQuads) {
            if (bakedQuad.getTintIndex() == 1) {
                TextureAtlasSprite sprite = iconSprite != null
                        ? iconSprite : bakedQuad.getSprite();

                generatedQuads.add(new BakedQuad(
                        updateTexture(bakedQuad.getVertexData(), sprite),
                        bakedQuad.getTintIndex(),
                        bakedQuad.getFace(),
                        sprite,
                        bakedQuad.applyDiffuseLighting()
                ));

            } else {
                generatedQuads.add(bakedQuad);
            }
        }

        return generatedQuads;
    }

    private int[] updateTexture(int[] vertexData, TextureAtlasSprite texture) {
        int[] updatedData = Arrays.copyOf(vertexData, 32);

        // Consider rotation (?)
        // 0, 0
        // 0, 16
        // 16, 16
        // 16, 0

        updatedData[4] = Float.floatToRawIntBits(texture.getInterpolatedU(0));
        updatedData[5] = Float.floatToRawIntBits(texture.getInterpolatedV(0));

        updatedData[12] = Float.floatToRawIntBits(texture.getInterpolatedU(0));
        updatedData[13] = Float.floatToRawIntBits(texture.getInterpolatedV(16));

        updatedData[20] = Float.floatToRawIntBits(texture.getInterpolatedU(16));
        updatedData[21] = Float.floatToRawIntBits(texture.getInterpolatedV(16));

        updatedData[28] = Float.floatToRawIntBits(texture.getInterpolatedU(16));
        updatedData[29] = Float.floatToRawIntBits(texture.getInterpolatedV(0));

        return updatedData;
    }

    private TextureAtlasSprite getIconSprite() {
        ResourceLocation iconLocation = ItemCraftingBlueprint.getIconLocation(getStackNBT());
        ModelLoader modelLoader = ModelLoader.instance();
        if (modelLoader == null) return null;
        AtlasTexture blocksStitchedTextures = modelLoader.getSpriteMap().getAtlasTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
        return blocksStitchedTextures.getSprite(iconLocation);
    }

}
