package io.github.ichikura10.block;

import io.github.ichikura10.block.entity.BlockEntityArmorUpgrader;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class BlockArmorUpgrader extends BaseEntityBlock {
    public BlockArmorUpgrader() {
        super(Properties.of().strength(3.0F, 1500F));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        BlockEntityArmorUpgrader armorUpgrader = (BlockEntityArmorUpgrader) blockEntity;

        if (pPlayer.isSteppingCarefully()) {
            if (!pLevel.isClientSide) {
                pPlayer.displayClientMessage(Component.literal("Count:" + armorUpgrader.getCount()), true);
            }
        } else {
            armorUpgrader.increment();
            if (!pLevel.isClientSide) {
                MenuProvider provider = this.getMenuProvider(pState, pLevel, pPos);
                pPlayer.openMenu(provider);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        BlockEntity te = pLevel.getBlockEntity(pPos);
        BlockEntityArmorUpgrader entity = (BlockEntityArmorUpgrader) te;
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        Containers.dropContents(pLevel, pPos, entity);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BlockEntityArmorUpgrader(blockPos, blockState);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
