package net.programmer.igoodie.craftingblueprints.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldUtils {

    public static <T extends TileEntity> T getTileEntity(Class<T> type, World world, BlockPos blockPos) {
        TileEntity tileEntity = world.getTileEntity(blockPos);

        if (tileEntity == null) {
            return null;
        }

        Class<? extends TileEntity> tileEntityClass = tileEntity.getClass();

        if (type.isAssignableFrom(tileEntityClass)) {
            return type.cast(tileEntity);
        }

        return null;
    }

}
