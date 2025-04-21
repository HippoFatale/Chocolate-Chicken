package hippofatale.chocolatechickenmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CHOCOLATE_CHICKEN = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(8f)
            .build();
}
