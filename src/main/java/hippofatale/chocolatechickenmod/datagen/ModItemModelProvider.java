package hippofatale.chocolatechickenmod.datagen;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChocolateChickenMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CHOCOLATE_SYRUP.get());

        basicItem(ModItems.CHOCOLATE_CHICKEN.get());
        basicItem(ModItems.CHOCOLATE_MUTTON.get());
        basicItem(ModItems.CHOCOLATE_PORK.get());
        basicItem(ModItems.CHOCOLATE_STEAK.get());
    }
}
