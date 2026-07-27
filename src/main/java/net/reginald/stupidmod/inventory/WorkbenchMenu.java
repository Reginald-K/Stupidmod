package net.reginald.stupidmod.inventory;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.reginald.stupidmod.block.ModBlocks;

import java.util.Optional;

public class WorkbenchMenu extends CraftingMenuClone {
    public WorkbenchMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(id, inventory, access);
    }

    public WorkbenchMenu(int pContainerId, Inventory pPlayerInventory) {
        super(pContainerId, pPlayerInventory);
    }

    @Override
    protected boolean craftingAllowed(ItemStack itemstack, Level pLevel) {
        return (super.craftingAllowed(itemstack, pLevel) && !itemstack.is(Items.DIAMOND_PICKAXE));
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, ModBlocks.WORKBENCH.get());
    }
}
