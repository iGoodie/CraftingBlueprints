package net.programmer.igoodie.craftingblueprints.block.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.programmer.igoodie.craftingblueprints.block.entity.TileEntityManufacturingBench;
import org.jetbrains.annotations.NotNull;

public class RendererManufacturingBench extends TileEntityRenderer<TileEntityManufacturingBench> {

    public RendererManufacturingBench(TileEntityRendererDispatcher rendererDispatcher) {
        super(rendererDispatcher);
    }

    @Override
    public void render(@NotNull TileEntityManufacturingBench tileEntity, float partialTicks, @NotNull MatrixStack matrixStack, @NotNull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {

    }

}
