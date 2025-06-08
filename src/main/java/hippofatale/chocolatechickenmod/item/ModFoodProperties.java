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
            .nutrition(6)
            .saturationModifier(0.6f)
            .build();
    public static final FoodProperties CHOCOLATE_CHICKEN = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.6f)
            .build();
    public static final FoodProperties CHOCOLATE_MUTTON = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.8f)
            .build();
    public static final FoodProperties CHOCOLATE_PORK = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.8f)
            .build();
    public static final FoodProperties CHOCOLATE_STEAK = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.8f)
            .build();

    //blue curacao
    //food
    public static final FoodProperties BLUE_CHICKEN = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.6f)
            .build();
    public static final FoodProperties BLUE_MUTTON = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.8f)
            .build();
    public static final FoodProperties BLUE_PORK = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.8f)
            .build();
    public static final FoodProperties BLUE_STEAK = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.8f)
            .build();

    //tools
    public static final FoodProperties CHOCOLATE_SWORD = new FoodProperties.Builder()
            .nutrition(21)
            .saturationModifier(0.7f)
            .build();

}
