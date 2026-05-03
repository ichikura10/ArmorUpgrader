package io.github.ichikura10.block.gui.screen;

import io.github.ichikura10.ArmorUpgrader;
import io.github.ichikura10.block.gui.container.MenuArmorUpgrader;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ScreenArmorUpgrader extends AbstractContainerScreen<MenuArmorUpgrader> {
    private static final ResourceLocation ARMOR_UPGRADER_TEXTURE = new ResourceLocation(ArmorUpgrader.MOD_ID, "textures/gui/container/armor_upgrader.png");

    private static final Component INVENTORY_TITLE = Component.translatable("container." + ArmorUpgrader.MOD_ID + ".inventory");

    public ScreenArmorUpgrader(MenuArmorUpgrader pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int setW = (this.width - this.imageWidth) / 2;
        int setH = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(ARMOR_UPGRADER_TEXTURE, setW, setH, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        pGuiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        pGuiGraphics.drawString(this.font, INVENTORY_TITLE, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
