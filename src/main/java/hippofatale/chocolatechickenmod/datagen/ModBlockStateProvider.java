package hippofatale.chocolatechickenmod.datagen;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChocolateChickenMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //chocolate syrup crate
        ModelFile chocolateSyrupCrateModel = models().orientableWithBottom("chocolate_syrup_crate",
                modLoc("block/chocolate_syrup_crate_side"),
                modLoc("block/chocolate_syrup_crate_front"),
                modLoc("block/chocolate_syrup_crate_side"),
                modLoc("block/chocolate_syrup_crate_top")
        );
        horizontalBlock(ModBlocks.CHOCOLATE_SYRUP_CRATE.get(), chocolateSyrupCrateModel);
        simpleBlockItem(ModBlocks.CHOCOLATE_SYRUP_CRATE.get(), chocolateSyrupCrateModel);

        //blue curacao syrup crate
        ModelFile blueCuracaoSyrupCrateModel = models().orientableWithBottom("blue_curacao_syrup_crate",
                modLoc("block/blue_curacao_syrup_crate_side"),
                modLoc("block/blue_curacao_syrup_crate_front"),
                modLoc("block/blue_curacao_syrup_crate_side"),
                modLoc("block/blue_curacao_syrup_crate_top")
        );
        horizontalBlock(ModBlocks.BLUE_CURACAO_SYRUP_CRATE.get(), blueCuracaoSyrupCrateModel);
        simpleBlockItem(ModBlocks.BLUE_CURACAO_SYRUP_CRATE.get(), blueCuracaoSyrupCrateModel);
    }

}
