package hippofatale.chocolatechickenmod.item;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChocolateChickenMod.MOD_ID);

    public static final DeferredItem<Item> CHOCOLATE_SYRUP = ITEMS.register("chocolate_syrup",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
