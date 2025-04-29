package hippofatale.chocolatechickenmod.item;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChocolateChickenMod.MOD_ID);

    //items
    public static final DeferredItem<Item> CHOCOLATE_SYRUP = ITEMS.register("chocolate_syrup",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.chocolatechickenmod.chocolate_syrup"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //chocolate food
    public static final DeferredItem<Item> CHOCOLATE_BREAD = ITEMS.register("chocolate_bread",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_BREAD)));
    public static final DeferredItem<Item> CHOCOLATE_CHICKEN = ITEMS.register("chocolate_chicken",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_CHICKEN)));
    public static final DeferredItem<Item> CHOCOLATE_MUTTON = ITEMS.register("chocolate_mutton",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_MUTTON)));
    public static final DeferredItem<Item> CHOCOLATE_PORK = ITEMS.register("chocolate_pork",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_PORK)));
    public static final DeferredItem<Item> CHOCOLATE_STEAK = ITEMS.register("chocolate_steak",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_STEAK)));

    //chocolate tools
    public static final DeferredItem<SwordItem> CHOCOLATE_SWORD = ITEMS.register("chocolate_sword",
            () -> new SwordItem(ModToolTiers.CHOCOLATE,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(ModToolTiers.CHOCOLATE, 3, -2.4f))
                            .food(ModFoodProperties.CHOCOLATE_SWORD)
            )
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
