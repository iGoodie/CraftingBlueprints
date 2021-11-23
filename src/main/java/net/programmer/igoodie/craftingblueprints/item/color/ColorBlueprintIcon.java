package net.programmer.igoodie.craftingblueprints.item.color;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.programmer.igoodie.craftingblueprints.init.ModItems;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ColorBlueprintIcon extends ModColor {

    public static final ColorBlueprintIcon INSTANCE = new ColorBlueprintIcon();

    private ColorBlueprintIcon() {}

    @Override
    public IItemProvider[] appliedItems() {
        return new IItemProvider[]{
                () -> ModItems.CRAFTING_BLUEPRINT.get()
        };
    }

    @Override
    public int getColor(@NotNull ItemStack itemStack, int tintIndex) {
//        System.out.println("Tint index " + tintIndex + " for stack -> " + itemStack);
//        return (int) (System.currentTimeMillis());
        return 0xFF_FFFFFF;
    }

}
