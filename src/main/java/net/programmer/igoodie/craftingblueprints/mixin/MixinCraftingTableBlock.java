package net.programmer.igoodie.craftingblueprints.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.programmer.igoodie.craftingblueprints.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CraftingTableBlock.class)
public class MixinCraftingTableBlock {

    @Inject(method = "onBlockActivated", cancellable = true, at = @At(value = "HEAD"))
    public void onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit, CallbackInfoReturnable<ActionResultType> cir) {
        if (!world.isRemote) {
            ItemStack heldItem = player.getHeldItem(hand);
            if (heldItem.getItem() == ModItems.CRAFTING_BLUEPRINT.get()) {
                cir.setReturnValue(ActionResultType.PASS);
            }
        }
    }

}
