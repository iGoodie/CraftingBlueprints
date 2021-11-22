package net.programmer.igoodie.craftingblueprints.item;

import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.programmer.igoodie.craftingblueprints.init.ModIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemCraftingBlueprint extends Item {

    public ItemCraftingBlueprint(Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemGroup(@NotNull ItemGroup group, @NotNull NonNullList<ItemStack> items) {
        for (ResourceLocation textureLocation : ModIcons.REGISTRY.values()) {
            items.add(setIcon(new ItemStack(this), textureLocation));
        }
    }

    @Override
    public @NotNull ITextComponent getDisplayName(@NotNull ItemStack stack) {
        IFormattableTextComponent displayName = (IFormattableTextComponent) super.getDisplayName(stack);
        displayName.setStyle(Style.EMPTY.setColor(Color.fromInt(0xFF_BDCDF2)));
        return displayName;
    }

    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World worldIn, @NotNull List<ITextComponent> tooltip, @NotNull ITooltipFlag flag) {
        CompoundNBT nbt = stack.getOrCreateTag();
        ResourceLocation iconLocation = getIconLocation(nbt);
        String iconName = ModIcons.getNameOf(iconLocation);

        if (iconName != null && flag.isAdvanced()) {
            tooltip.add(new StringTextComponent("Icon: " + iconName));
        }

        super.addInformation(stack, worldIn, tooltip, flag);
    }

    /* ---------------------- */

    public static ResourceLocation getIconLocation(CompoundNBT nbt) {
        if (nbt == null) {
            return MissingTextureSprite.getLocation();
        }

        String resourceName = nbt.getString("blueprint_icon");

        if (resourceName.isEmpty()) {
            return MissingTextureSprite.getLocation();
        }

        return new ResourceLocation(resourceName);
    }

    public static ItemStack setIcon(ItemStack itemStack, ResourceLocation iconLocation) {
        CompoundNBT nbt = itemStack.getOrCreateTag();
        nbt.putString("blueprint_icon", iconLocation.toString());
        itemStack.setTag(nbt);
        return itemStack;
    }

}
