package net.programmer.igoodie.craftingblueprints.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.programmer.igoodie.craftingblueprints.init.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class BlockManufacturingBench extends AbstractFacingBlock {

    public BlockManufacturingBench() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(2.5F)
                .sound(SoundType.WOOD));
    }

    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootContext.@NotNull Builder builder) {
        List<ItemStack> drops = new LinkedList<>();
        drops.add(new ItemStack(Blocks.CRAFTING_TABLE));
        return drops;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModBlocks.TE_MANUFACTURING_BENCH.get().create();
    }

}
