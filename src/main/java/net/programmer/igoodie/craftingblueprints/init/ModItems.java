package net.programmer.igoodie.craftingblueprints.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.programmer.igoodie.craftingblueprints.CraftingBlueprints;
import net.programmer.igoodie.craftingblueprints.item.GroupBlueprints;
import net.programmer.igoodie.craftingblueprints.item.ItemCraftingBlueprint;

public class ModItems {

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CraftingBlueprints.MOD_ID);

    public static RegistryObject<ItemCraftingBlueprint> CRAFTING_BLUEPRINT
            = REGISTRY.register("crafting_blueprint", () -> new ItemCraftingBlueprint(new Item.Properties().group(GroupBlueprints.INSTANCE).maxStackSize(1).setNoRepair()));

}
