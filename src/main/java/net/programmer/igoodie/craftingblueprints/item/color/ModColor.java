package net.programmer.igoodie.craftingblueprints.item.color;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.util.IItemProvider;

public abstract class ModColor implements IItemColor {

    public abstract IItemProvider[] appliedItems();

}
