package hippofatale.chocolatechickenmod.datagen;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.item.ModItems;
import hippofatale.chocolatechickenmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ChocolateChickenMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CHOCOLATE_FOOD)
                .add(ModItems.CHOCOLATE_CHICKEN.get())
                .add(ModItems.CHOCOLATE_MUTTON.get())
                .add(ModItems.CHOCOLATE_PORK.get())
                .add(ModItems.CHOCOLATE_STEAK.get());
    }
}
