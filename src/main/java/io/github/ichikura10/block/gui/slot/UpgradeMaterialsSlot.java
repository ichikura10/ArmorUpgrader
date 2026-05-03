package io.github.ichikura10.block.gui.slot;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class UpgradeMaterialsSlot extends Slot {
    public static final TagKey<Item> UPGRADE_MATERIALS =
            TagKey.create(Registries.ITEM, new ResourceLocation("armorupgrader", "upgrade_materials"));

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return pStack.is(UPGRADE_MATERIALS);
    }

    public UpgradeMaterialsSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }
}
