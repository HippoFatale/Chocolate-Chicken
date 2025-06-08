package hippofatale.chocolatechickenmod.block.entity;

import hippofatale.chocolatechickenmod.item.ModItems;
import hippofatale.chocolatechickenmod.recipe.ChocolateRecipe;
import hippofatale.chocolatechickenmod.recipe.ChocolateRecipeInput;
import hippofatale.chocolatechickenmod.recipe.ModRecipes;
import hippofatale.chocolatechickenmod.screen.custom.ChocolateDoubleBoilerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChocolateDoubleBoilerBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemStackHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    //private static final int COCOA_BEANS_INPUT_SLOT = 2;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public ChocolateDoubleBoilerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.CHOCOLATE_DOUBLE_BOILER_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ChocolateDoubleBoilerBlockEntity.this.progress;
                    case 1 -> ChocolateDoubleBoilerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: ChocolateDoubleBoilerBlockEntity.this.progress = value;
                    case 1: ChocolateDoubleBoilerBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.chocolatechickenmod.chocolate_double_boiler");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new ChocolateDoubleBoilerMenu(containerId, playerInventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemStackHandler.serializeNBT(registries));
        tag.putInt("chocolate_double_boiler.progress", progress);
        tag.putInt("chocolate_double_boiler.max_progress", maxProgress);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        itemStackHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("chocolate_double_boiler.progress");
        maxProgress = tag.getInt("chocolate_double_boiler.max_progress");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        //TODO
        //chocolate crafting
        if (hasRecipe() /*&& hasEnoughChocolate()*/) {
            progress++;
            setChanged(level, blockPos, blockState);

            if (this.progress >= this.maxProgress) {
                craftItem();
                progress = 0;
                //consumeChocolate();
            }
        }
        else {
            progress = 0;
        }

        //chocolate smelting
    }

    private void craftItem() {
        Optional<RecipeHolder<ChocolateRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        itemStackHandler.extractItem(INPUT_SLOT, 1, false);
        itemStackHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(), itemStackHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<ChocolateRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemInOutputSlot(output);
    }

    private Optional<RecipeHolder<ChocolateRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager().getRecipeFor(ModRecipes.CHOCOLATE_RECIPE_TYPE.get(), new ChocolateRecipeInput(itemStackHandler.getStackInSlot(INPUT_SLOT)), level);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemStackHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemStackHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemStackHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    private boolean canInsertItemInOutputSlot(ItemStack output) {
        return itemStackHandler.getStackInSlot(OUTPUT_SLOT).isEmpty()
                || itemStackHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }




    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


}
