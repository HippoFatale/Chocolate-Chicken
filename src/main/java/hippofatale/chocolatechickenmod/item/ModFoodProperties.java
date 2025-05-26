package hippofatale.chocolatechickenmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    //citrus fruits
    public static final FoodProperties CITRUS_ORANGE = new FoodProperties.Builder()
        .nutrition(4)
        .saturationModifier(0.3f)
        .build();
    public static final FoodProperties CITRUS_LEMON = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .build();

    //chocolate
    //food
    public static final FoodProperties CHOCOLATE_BREAD = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.7f)
            .build();
    public static final FoodProperties CHOCOLATE_CHICKEN = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.7f)
            .build();
    public static final FoodProperties CHOCOLATE_MUTTON = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.7f)
            .build();
    public static final FoodProperties CHOCOLATE_PORK = new FoodProperties.Builder()
            .nutrition(12)
            .saturationModifier(0.9f)
            .build();
    public static final FoodProperties CHOCOLATE_STEAK = new FoodProperties.Builder()
            .nutrition(12)
            .saturationModifier(0.9f)
            .build();
    //tools
    public static final FoodProperties CHOCOLATE_SWORD = new FoodProperties.Builder()
            .nutrition(21)
            .saturationModifier(0.7f)
            .build();

}
