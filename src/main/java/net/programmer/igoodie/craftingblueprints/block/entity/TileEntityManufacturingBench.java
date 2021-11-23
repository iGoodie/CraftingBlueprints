package net.programmer.igoodie.craftingblueprints.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.programmer.igoodie.craftingblueprints.init.ModBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TileEntityManufacturingBench extends TileEntity {

    @Nullable
    protected ItemStack blueprint;

    public TileEntityManufacturingBench() {
        super(ModBlocks.TE_MANUFACTURING_BENCH.get());
    }

    public @Nullable ItemStack getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(@Nullable ItemStack blueprint) {
        this.blueprint = blueprint;
    }

    @Override
    public @NotNull CompoundNBT write(@NotNull CompoundNBT nbt) {
        if (blueprint != null) {
            nbt.put("Blueprint", blueprint.write(new CompoundNBT()));
        }
        return super.write(nbt);
    }

    @Override
    public void read(@NotNull BlockState state, @NotNull CompoundNBT nbt) {
        if (nbt.contains("Blueprint", Constants.NBT.TAG_COMPOUND)) {
            this.blueprint = ItemStack.read(nbt.getCompound("Blueprint"));
        }
        super.read(state, nbt);
    }

    @Override
    public @NotNull CompoundNBT getUpdateTag() {
        CompoundNBT nbt = super.getUpdateTag();
        if (blueprint != null) {
            nbt.put("Blueprint", blueprint.write(new CompoundNBT()));
        }
        return nbt;
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT nbt) {
        if (nbt.contains("Blueprint", Constants.NBT.TAG_COMPOUND)) {
            this.blueprint = ItemStack.read(nbt.getCompound("Blueprint"));
        }
        super.handleUpdateTag(state, nbt);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT tag = pkt.getNbtCompound();
        handleUpdateTag(getBlockState(), tag);
    }

}
