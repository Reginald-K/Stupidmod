package net.reginald.stupidmod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.reginald.stupidmod.StupidMod;

@Mod.EventBusSubscriber(modid = StupidMod.MODID)
public class ForgeEvents {
    @SubscribeEvent
    public static void onFillBucket(FillBucketEvent event){
        HitResult target = event.getTarget();

        if (!(target instanceof BlockHitResult blockHit)) {
            return;
        }

        BlockPos pos = blockHit.getBlockPos();

        Level level = event.getLevel();

        FluidState fluid = level.getFluidState(pos);
        if(fluid.is(FluidTags.LAVA)){
            event.setCanceled(true);
        }
    }
}
