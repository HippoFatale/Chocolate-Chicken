package hippofatale.chocolatechickenmod.item;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChocolateChickenMod.MOD_ID);

    public static final Supplier<CreativeModeTab> CHOCOLATE_CHICKEN_ITEMS_TAB = CREATIVE_MODE_TAB.register("chocolate_chicken_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHOCOLATE_CHICKEN.get()))
                    .title(Component.translatable("creativetab.chocolatechickenmod.chocolate_chicken_items"))
                    .displayItems((parameters, output) -> {
                        //items
                        output.accept(ModItems.CHOCOLATE_SYRUP);

                        //blocks
                        output.accept(ModBlocks.CHOCOLATE_SYRUP_CRATE);

                        //food
                        output.accept(ModItems.CHOCOLATE_CHICKEN);
                        output.accept(ModItems.CHOCOLATE_MUTTON);
                        output.accept(ModItems.CHOCOLATE_PORK);
                        output.accept(ModItems.CHOCOLATE_STEAK);


                    })

                    .build());

//    public static final Supplier<CreativeModeTab> BLUE_LEMON_ITEMS_TAB = CREATIVE_MODE_TAB.register("blue_lemon_items_tab",
//            () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModItems.CHOCOLATE_SYRUP.get()))
//                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, "chocolate_chicken_items_tab"))
//                    .title(Component.translatable("creativetab.chocolatechickenmod.blue_lemon_items"))
//                    .displayItems((parameters, output) -> {
//                        //items
//
//                        //blocks
//
//                    })
//
//                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
