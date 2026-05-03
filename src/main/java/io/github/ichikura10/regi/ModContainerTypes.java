package io.github.ichikura10.regi;

import io.github.ichikura10.ArmorUpgrader;
import io.github.ichikura10.block.gui.container.MenuArmorUpgrader;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainerTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ArmorUpgrader.MOD_ID);

    public static final RegistryObject<MenuType<MenuArmorUpgrader>> ARMOR_UPGRADER = MENU_TYPES.register("aromor_upgrader", () -> set(MenuArmorUpgrader::new));
    private static <T extends AbstractContainerMenu> MenuType<T> set(MenuType.MenuSupplier<T> supplier) {
        return new MenuType<>(supplier, FeatureFlags.REGISTRY.allFlags());
    }
}
