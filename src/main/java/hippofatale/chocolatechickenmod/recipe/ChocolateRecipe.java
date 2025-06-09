package hippofatale.chocolatechickenmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record ChocolateRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ChocolateRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(ChocolateRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        return inputItem.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(ChocolateRecipeInput input, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CHOCOLATE_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CHOCOLATE_RECIPE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<ChocolateRecipe> {
        public static final MapCodec<ChocolateRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(ChocolateRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ChocolateRecipe::output)
        ).apply(inst, ChocolateRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ChocolateRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, ChocolateRecipe::inputItem,
                        ItemStack.STREAM_CODEC, ChocolateRecipe::output,
                        ChocolateRecipe::new);

        @Override
        public MapCodec<ChocolateRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ChocolateRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
