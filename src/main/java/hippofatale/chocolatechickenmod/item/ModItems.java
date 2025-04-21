package hippofatale.chocolatechickenmod.item;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChocolateChickenMod.MOD_ID);

    //items
    public static final DeferredItem<Item> CHOCOLATE_SYRUP = ITEMS.register("chocolate_syrup",
            () -> new Item(new Item.Properties()));

    //food
    public static final DeferredItem<Item> CHOCOLATE_CHICKEN = ITEMS.register("chocolate_chicken",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_CHICKEN)));

    public static final DeferredItem<Item> CHOCOLATE_MUTTON = ITEMS.register("chocolate_mutton",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_MUTTON)));

    public static final DeferredItem<Item> CHOCOLATE_PORK = ITEMS.register("chocolate_pork",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_PORK)));

    public static final DeferredItem<Item> CHOCOLATE_STEAK = ITEMS.register("chocolate_steak",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_STEAK)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
