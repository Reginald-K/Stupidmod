package net.reginald.stupidmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reginald.stupidmod.StupidMod;
import net.reginald.stupidmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StupidMod.MODID);

    public static final RegistryObject<CreativeModeTab> STUPIDMOD_TAB =
            CREATIVE_MODE_TABS.register(
                    "stupidmod_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.IRON_BRICK.get()))
                            .title(Component.translatable("creativetab.stupidmod_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.IRON_BRICK.get());
                                pOutput.accept(Items.IRON_INGOT);
                                pOutput.accept(ModBlocks.IRON_BRICKS.get());
                            })
                            .build()
            );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
