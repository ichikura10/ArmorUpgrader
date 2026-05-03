package io.github.ichikura10.block.entity;

import io.github.ichikura10.ArmorUpgrader;
import io.github.ichikura10.block.BlockArmorUpgrader;
import io.github.ichikura10.block.gui.container.MenuArmorUpgrader;
import io.github.ichikura10.regi.ModBlockEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityArmorUpgrader extends RandomizableContainerBlockEntity {
    private int count = 0;

    public BlockEntityArmorUpgrader(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntityTypes.ARMOR_UPGRADER.get(), pPos, pBlockState);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("t-count", count);
    }


    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.count = pTag.getInt("t-count");
    }

    public void increment() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {

    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container." + ArmorUpgrader.MOD_ID + ".armor_upgrader").withStyle(ChatFormatting.BOLD);
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new MenuArmorUpgrader(i, inventory, this);
    }
}
