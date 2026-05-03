package io.github.ichikura10.regi;

import io.github.ichikura10.ArmorUpgrader;
import io.github.ichikura10.block.BlockArmorUpgrader;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static class blocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArmorUpgrader.MOD_ID);
    public static final RegistryObject<Block> ARMOR_UPGRADER = BLOCKS.register("armor_upgrader", BlockArmorUpgrader::new);
    }

    public static class BlockItems {
        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorUpgrader.MOD_ID);
        public static final RegistryObject<Item> ARMOR_UPGRADER = BLOCK_ITEMS.register("armor_upgrader"
                , () -> new BlockItem(blocks.ARMOR_UPGRADER.get(), new Item.Properties()));
    }
}
