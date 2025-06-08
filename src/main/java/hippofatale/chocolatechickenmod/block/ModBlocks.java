package hippofatale.chocolatechickenmod.block;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.block.custom.ChocolateDoubleBoilerBlock;
import hippofatale.chocolatechickenmod.block.custom.CrateBlock;
import hippofatale.chocolatechickenmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ChocolateChickenMod.MOD_ID);

    public static final DeferredBlock<Block> CHOCOLATE_SYRUP_CRATE = registerBlock("chocolate_syrup_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.WOOD)
            )
    );
    public static final DeferredBlock<Block> BLUE_CURACAO_SYRUP_CRATE = registerBlock("blue_curacao_syrup_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<Block> CHOCOLATE_DOUBLE_BOILER = registerBlock("chocolate_double_boiler",
            () -> new ChocolateDoubleBoilerBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.METAL)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
