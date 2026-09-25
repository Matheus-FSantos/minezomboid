package io.github.minezomboid.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class WaterBottleItem extends Item {
    public WaterBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemsStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity user) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        if (!level.isClientSide() && user instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);

                if (stack.isEmpty()) {
                    return new ItemStack(ModItems.PLASTIC_BOTTLE_ITEM);
                }

                if (!player.getInventory().add(new ItemStack(ModItems.PLASTIC_BOTTLE_ITEM))) {
                    player.drop(new ItemStack(ModItems.PLASTIC_BOTTLE_ITEM), false);
                }
            }
        }

        return stack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }
}
