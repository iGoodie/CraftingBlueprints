package net.programmer.igoodie.craftingblueprints.item.model;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.client.model.data.IModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class ReplacementItemModel extends DynamicItemModel {

    @FunctionalInterface
    public interface ModelGenerator {
        DynamicItemModel generate(IBakedModel baseModel, CompoundNBT stackNBT);
    }

    protected ModelGenerator modelGenerator;

    public ReplacementItemModel(@NotNull IBakedModel baseModel, ModelGenerator modelGenerator) {
        super(baseModel, new CompoundNBT());
        this.modelGenerator = modelGenerator;
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand) {
        throw new AssertionError("ReplacementItemModel::getQuads should never be called");
    }

    @NotNull
    @Override
    public IModelData getModelData(@NotNull IBlockDisplayReader world, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull IModelData tileData) {
        throw new AssertionError("ReplacementItemModel::getModelData should never be called");
    }

    @Override
    public @NotNull ItemOverrideList getOverrides() {
        return new ItemOverrideList() {
            @Nullable
            @Override
            public IBakedModel getOverrideModel(@NotNull IBakedModel model, @NotNull ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity livingEntity) {
                @Nullable CompoundNBT tag = stack.getTag();
                return modelGenerator.generate(getBaseModel(), tag != null ? tag : new CompoundNBT());
            }
        };
    }

}