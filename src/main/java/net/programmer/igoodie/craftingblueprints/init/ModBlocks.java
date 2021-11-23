package net.programmer.igoodie.craftingblueprints.init;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;
import net.programmer.igoodie.craftingblueprints.block.BlockManufacturingBench;
import net.programmer.igoodie.craftingblueprints.block.entity.TileEntityManufacturingBench;

public class ModBlocks {

    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CraftingBlueprints.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TE_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CraftingBlueprints.MOD_ID);

    /* Blocks ---------------------------------------- */

    public static RegistryObject<BlockManufacturingBench> MANUFACTURING_BENCH
            = REGISTRY.register("manufacturing_bench", BlockManufacturingBench::new);

    /* Tile Entities --------------------------------- */

    public static RegistryObject<TileEntityType<TileEntityManufacturingBench>> TE_MANUFACTURING_BENCH
            = TE_REGISTRY.register("te_manufacturing_bench", () -> TileEntityType.Builder.create(TileEntityManufacturingBench::new, MANUFACTURING_BENCH.get()).build(null));

}
