package com.github.moistmason.millenaire.world.event;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

import static com.github.moistmason.millenaire.MillenaireResettled.MOD_ID;
import static com.github.moistmason.millenaire.world.block.MillenaireBlocks.*;

@EventBusSubscriber(modid = MOD_ID)
public class MillenaireBlockEvents {

    /** Turns a dirt slab into a dirt path slab when interacted with a shovel. */
    @SubscribeEvent
    public static void onDirtPathSlabInteract(BlockEvent.BlockToolModificationEvent event) {
        Level level = (Level) event.getLevel();
        Player player = event.getPlayer();
        BlockState state = event.getState();
        ItemStack held = event.getHeldItemStack();
        BlockPos pos = event.getPos();

        if (state.is(DIRT_SLAB.get()) && held.getItem() instanceof ShovelItem) {
            level.removeBlock(pos, false);
            level.setBlockAndUpdate(pos, DIRT_PATH_SLAB.get().defaultBlockState());
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS);
        }
    }
}
