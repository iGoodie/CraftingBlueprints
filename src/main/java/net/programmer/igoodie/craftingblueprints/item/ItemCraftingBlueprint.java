package net.programmer.igoodie.craftingblueprints.item;

import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;
import org.jetbrains.annotations.NotNull;

public class ItemCraftingBlueprint extends Item {

    public ItemCraftingBlueprint(Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemGroup(@NotNull ItemGroup group, @NotNull NonNullList<ItemStack> items) {
        items.add(setIcon(new ItemStack(this), CraftingBlueprints.id("item/blueprint/icon/igoodie")));
        items.add(setIcon(new ItemStack(this), CraftingBlueprints.id("item/blueprint/icon/sword")));
        items.add(setIcon(new ItemStack(this), CraftingBlueprints.id("item/blueprint/icon/pickaxe")));
        items.add(setIcon(new ItemStack(this), CraftingBlueprints.id("item/blueprint/icon/asteriks")));
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
