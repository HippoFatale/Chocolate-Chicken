package hippofatale.chocolatechickenmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
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

}
