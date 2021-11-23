package net.programmer.igoodie.craftingblueprints.block.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.programmer.igoodie.craftingblueprints.block.entity.TileEntityManufacturingBench;
import org.jetbrains.annotations.NotNull;

public class RendererManufacturingBench extends TileEntityRenderer<TileEntityManufacturingBench> {

    public RendererManufacturingBench(TileEntityRendererDispatcher rendererDispatcher) {
        super(rendererDispatcher);
    }

    @Override
    public void render(@NotNull TileEntityManufacturingBench tileEntity, float partialTicks, @NotNull MatrixStack matrixStack, @NotNull IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        ItemStack blueprint = tileEntity.getBlueprint();

        if (blueprint != null) {
            matrixStack.push();

            World world = tileEntity.getWorld();
            BlockState blockState = world.getBlockState(tileEntity.getPos());

            Direction direction = blockState.get(BlockStateProperties.HORIZONTAL_FACING);

            matrixStack.translate(0.5, 1.0125, 0.5);
            matrixStack.rotate(Vector3f.YN.rotationDegrees(direction.getHorizontalAngle()));
            matrixStack.rotate(Vector3f.YP.rotationDegrees(22f));
            matrixStack.scale(0.8f, 1f, 0.8f);

            renderItem(matrixStack, buffer, combinedLight, combinedOverlay, blueprint);
            matrixStack.pop();
        }
    }

    private void renderItem(MatrixStack matrixStack, IRenderTypeBuffer buffer, int lightLevel, int overlay, ItemStack itemStack) {
        Minecraft minecraft = Minecraft.getInstance();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        IBakedModel bakedModel = itemRenderer.getItemModelWithOverrides(itemStack, null, null);

        itemRenderer.renderItem(itemStack, ItemCameraTransforms.TransformType.NONE, true,
                matrixStack, buffer, lightLevel, overlay, bakedModel);
    }

}
