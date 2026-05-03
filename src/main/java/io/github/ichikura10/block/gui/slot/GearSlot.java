package io.github.ichikura10.block.gui.slot;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GearSlot extends Slot {
    public static final TagKey<Item> UPGRADABLE =
            TagKey.create(Registries.ITEM, new ResourceLocation("armorupgrader", "upgradable"));

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return pStack.is(UPGRADABLE);
    }

    public GearSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }
}
