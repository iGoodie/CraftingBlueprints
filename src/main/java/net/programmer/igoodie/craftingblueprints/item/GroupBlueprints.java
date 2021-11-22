package net.programmer.igoodie.craftingblueprints.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;
import net.programmer.igoodie.craftingblueprints.init.ModIcons;
import net.programmer.igoodie.craftingblueprints.init.ModItems;
import org.jetbrains.annotations.NotNull;

public class GroupBlueprints extends ItemGroup {

    public static final GroupBlueprints INSTANCE = new GroupBlueprints();
    private static final ResourceLocation BACKGROUND_TEXTURE = CraftingBlueprints.id("textures/gui/container/group/blueprints_background.png");
    private static final ResourceLocation TABS_TEXTURE = CraftingBlueprints.id("textures/gui/container/group/blueprints_tabs.png");

    private GroupBlueprints() {
        super(CraftingBlueprints.MOD_ID + ".blueprints");
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public @NotNull ItemStack createIcon() {
        ItemStack itemStack = new ItemStack(ModItems.CRAFTING_BLUEPRINT.get());
        return ItemCraftingBlueprint.setIcon(itemStack, ModIcons.PICKAXE);
    }

    @Override
    public @NotNull ResourceLocation getBackgroundImage() {
        return BACKGROUND_TEXTURE;
    }

    @Override
    public @NotNull ResourceLocation getTabsImage() {
        return TABS_TEXTURE;
    }

    @Override
    public int getLabelColor() {
        return 0xFF_C9D5F0;
    }

}
