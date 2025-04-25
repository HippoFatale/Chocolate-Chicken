package hippofatale.chocolatechickenmod.datagen;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChocolateChickenMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        horizontalBlock(ModBlocks.CHOCOLATE_SYRUP_CRATE.get(), models().orientableWithBottom("chocolate_syrup_crate", modLoc("block/chocolate_syrup_crate_side"), modLoc("block/chocolate_syrup_crate_front"), modLoc("block/chocolate_syrup_crate_side"), modLoc("block/chocolate_syrup_crate_top")));
        simpleBlockItem(ModBlocks.CHOCOLATE_SYRUP_CRATE.get(), models().orientableWithBottom("chocolate_syrup_crate", modLoc("block/chocolate_syrup_crate_side"), modLoc("block/chocolate_syrup_crate_front"), modLoc("block/chocolate_syrup_crate_side"), modLoc("block/chocolate_syrup_crate_top")));
    }

//    private void blockWithItem(DeferredBlock<?> deferredBlock) {
//        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
//    }
}
