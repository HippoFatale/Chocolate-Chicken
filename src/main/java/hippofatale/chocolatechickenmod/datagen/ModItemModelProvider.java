package hippofatale.chocolatechickenmod.datagen;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChocolateChickenMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CHOCOLATE_SYRUP.get());

        basicItem(ModItems.CHOCOLATE_BREAD.get());
        basicItem(ModItems.CHOCOLATE_CHICKEN.get());
        basicItem(ModItems.CHOCOLATE_MUTTON.get());
        basicItem(ModItems.CHOCOLATE_PORK.get());
        basicItem(ModItems.CHOCOLATE_STEAK.get());

        handheldItem(ModItems.CHOCOLATE_SWORD.get());
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
