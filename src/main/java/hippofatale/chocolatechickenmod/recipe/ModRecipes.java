package hippofatale.chocolatechickenmod.recipe;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, ChocolateChickenMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, ChocolateChickenMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ChocolateRecipe>> CHOCOLATE_RECIPE_SERIALIZER =
            SERIALIZERS.register("chocolate", ChocolateRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<ChocolateRecipe>> CHOCOLATE_RECIPE_TYPE =
            TYPES.register("chocolate", () -> new RecipeType<ChocolateRecipe>() {
                @Override
                public String toString() {
                    return "chocolate";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
