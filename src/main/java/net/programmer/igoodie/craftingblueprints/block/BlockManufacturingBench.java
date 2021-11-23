package net.programmer.igoodie.craftingblueprints.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.programmer.igoodie.craftingblueprints.block.entity.TileEntityManufacturingBench;
import net.programmer.igoodie.craftingblueprints.init.ModBlocks;
import net.programmer.igoodie.craftingblueprints.util.WorldUtils;
import org.jetbrains.annotations.NotNull;

public class BlockManufacturingBench extends AbstractFacingBlock {

    public BlockManufacturingBench() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(2.5F)
                .sound(SoundType.WOOD)
                .notSolid());
    }

    @Override
    public void onBlockHarvested(@NotNull World world, @NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull PlayerEntity player) {
        super.onBlockHarvested(world, blockPos, state, player);

        TileEntityManufacturingBench tileEntity = WorldUtils.getTileEntity(TileEntityManufacturingBench.class, world, blockPos);
        if (tileEntity != null) {
            ItemStack blueprint = tileEntity.getBlueprint();
            if (blueprint != null) {
                spawnAsEntity(world, blockPos, blueprint);
            }
        }
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
