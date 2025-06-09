package hippofatale.comapt;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.recipe.ChocolateRecipe;
import hippofatale.chocolatechickenmod.recipe.ModRecipes;
import hippofatale.chocolatechickenmod.screen.custom.ChocolateDoubleBoilerScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIChocolateChickenModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ChocolateRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<ChocolateRecipe> chocolateRecipes = recipeManager.getAllRecipesFor(ModRecipes.CHOCOLATE_RECIPE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(ChocolateRecipeCategory.CHOCOLATE_RECIPE_RECIPE_TYPE, chocolateRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ChocolateDoubleBoilerScreen.class, 74, 30, 22, 20, ChocolateRecipeCategory.CHOCOLATE_RECIPE_RECIPE_TYPE);
    }
}
