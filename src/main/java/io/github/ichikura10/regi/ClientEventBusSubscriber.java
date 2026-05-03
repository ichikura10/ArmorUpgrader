package io.github.ichikura10.regi;

import io.github.ichikura10.ArmorUpgrader;
import io.github.ichikura10.block.gui.screen.ScreenArmorUpgrader;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ArmorUpgrader.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        blockScreenRegister();
    }

    private static void blockScreenRegister() {
        MenuScreens.register(ModContainerTypes.ARMOR_UPGRADER.get(), ScreenArmorUpgrader::new);
    }
}
