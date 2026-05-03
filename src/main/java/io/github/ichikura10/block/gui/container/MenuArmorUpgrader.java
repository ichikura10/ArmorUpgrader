package io.github.ichikura10.block.gui.container;

import io.github.ichikura10.regi.ModContainerTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MenuArmorUpgrader extends AbstractContainerMenu {
    private final Container container;

    public MenuArmorUpgrader(int a, Inventory inventory) {
        this(a, inventory, new SimpleContainer(3));
    }

    public MenuArmorUpgrader(int a, Inventory inventory, Container container) {
        super(ModContainerTypes.ARMOR_UPGRADER.get(), a);
        this.container = container;
        checkContainerSize(container, 3);
        container.startOpen(inventory.player);

        this.addSlot(new Slot(container, 0, 53, 35));
        this.addSlot(new Slot(container, 1, 80, 13));
        this.addSlot(new Slot(container, 2, 111, 35));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.addSlot(new Slot(inventory, j + 9 + i * 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; k++) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int a) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(a);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();
            if (a < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemStack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;

    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }
}
