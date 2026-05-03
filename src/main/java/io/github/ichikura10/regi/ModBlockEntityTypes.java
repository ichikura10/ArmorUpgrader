package io.github.ichikura10.regi;

import io.github.ichikura10.ArmorUpgrader;
import io.github.ichikura10.block.entity.BlockEntityArmorUpgrader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArmorUpgrader.MOD_ID);

    public static final RegistryObject<BlockEntityType<@org.jetbrains.annotations.NotNull BlockEntityArmorUpgrader>> ARMOR_UPGRADER = BLOCK_ENTITY_TYPES.register("armor_upgrader", () -> set(BlockEntityArmorUpgrader::new, ModBlocks.blocks.ARMOR_UPGRADER.get()));

    private static <T extends BlockEntity> BlockEntityType<T> set(BlockEntityType.BlockEntitySupplier<T> entity, Block block) {
        return BlockEntityType.Builder.of(entity, block).build(null);
    }
}
