package io.github.minezomboid.init;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class PlasticBottleItem extends Item {
    public PlasticBottleItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (hitResult.getType() != HitResult.Type.BLOCK) return InteractionResultHolder.pass(itemStack);

        if (!level.isClientSide()) {
            BlockPos blockPos = hitResult.getBlockPos();

            if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);

                ItemStack waterBottleStack = new ItemStack(ModItems.WATER_BOTTLE_ITEM);
                return InteractionResultHolder.success(ItemUtils.createFilledResult(itemStack, player, waterBottleStack));
            }
        }

        return InteractionResultHolder.pass(itemStack);
    }
}
