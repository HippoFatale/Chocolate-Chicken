package hippofatale.comapt;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.block.ModBlocks;
import hippofatale.chocolatechickenmod.recipe.ChocolateRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ChocolateRecipeCategory implements IRecipeCategory<ChocolateRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, "chocolate");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, "textures/gui/chocolate_double_boiler/chocolate_double_boiler_gui.png");

    public static final RecipeType<ChocolateRecipe> CHOCOLATE_RECIPE_RECIPE_TYPE = new RecipeType<>(UID, ChocolateRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ChocolateRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CHOCOLATE_DOUBLE_BOILER));
    }

    @Override
    public RecipeType<ChocolateRecipe> getRecipeType() {
        return CHOCOLATE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.chocolatechickenmod.chocolate_double_boiler");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ChocolateRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(recipe.getIngredients().getFirst());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(recipe.getResultItem(null));
    }
}
