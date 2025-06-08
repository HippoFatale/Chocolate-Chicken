package hippofatale.chocolatechickenmod.datagen;

import hippofatale.chocolatechickenmod.block.ModBlocks;
import hippofatale.chocolatechickenmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //chocolate syrup
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_SYRUP.get(), 1)
                .requires(Items.COCOA_BEANS, 2)
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_SYRUP.get(), 9)
                .requires(ModBlocks.CHOCOLATE_SYRUP_CRATE)
                .unlockedBy("has_chocolate_syrup_crate", has(ModBlocks.CHOCOLATE_SYRUP_CRATE))
                .save(recipeOutput, "chocolatechickenmod:chocolate_syrup_from_crate");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHOCOLATE_SYRUP_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.CHOCOLATE_SYRUP.get())
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .save(recipeOutput);

        //blue curacao syrup
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUE_CURACAO_SYRUP.get(), 1)
                .requires(Items.BLUE_DYE)
                .requires(ModItems.CITRUS_ORANGE)
                .requires(ModItems.CITRUS_LEMON)
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_blue_dye", has(Items.BLUE_DYE))
                .unlockedBy("has_citrus_orange", has(ModItems.CITRUS_ORANGE))
                .unlockedBy("has_citrus_lemon", has(ModItems.CITRUS_LEMON))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUE_CURACAO_SYRUP.get(), 9)
                .requires(ModBlocks.BLUE_CURACAO_SYRUP_CRATE)
                .unlockedBy("has_blue_curacao_syrup_crate", has(ModBlocks.BLUE_CURACAO_SYRUP_CRATE))
                .save(recipeOutput, "chocolatechickenmod:blue_curacao_syrup_from_crate");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_CURACAO_SYRUP_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.BLUE_CURACAO_SYRUP.get())
                .unlockedBy("has_blue_curacao_syrup", has(ModItems.BLUE_CURACAO_SYRUP))
                .save(recipeOutput);

        //chocolate
        //food
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_BREAD.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.BREAD)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_CHICKEN.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_MUTTON.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_MUTTON)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_mutton", has(Items.COOKED_MUTTON))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_PORK.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_PORKCHOP)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE_STEAK.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .save(recipeOutput);

        //blue curacao
        //food
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUE_CHICKEN.get())
                .requires(ModItems.BLUE_CURACAO_SYRUP)
                .requires(Items.COOKED_CHICKEN)
                .requires(ModItems.CITRUS_ORANGE)
                .unlockedBy("has_blue_curacao_syrup", has(ModItems.BLUE_CURACAO_SYRUP))
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .unlockedBy("has_citrus_orange", has(ModItems.CITRUS_ORANGE))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUE_MUTTON.get())
                .requires(ModItems.BLUE_CURACAO_SYRUP)
                .requires(Items.COOKED_MUTTON)
                .requires(ModItems.CITRUS_LEMON)
                .unlockedBy("has_blue_curacao_syrup", has(ModItems.BLUE_CURACAO_SYRUP))
                .unlockedBy("has_cooked_mutton", has(Items.COOKED_MUTTON))
                .unlockedBy("has_citrus_lemon", has(ModItems.CITRUS_LEMON))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUE_PORK.get())
                .requires(ModItems.BLUE_CURACAO_SYRUP)
                .requires(Items.COOKED_PORKCHOP)
                .requires(ModItems.CITRUS_ORANGE)
                .unlockedBy("has_blue_curacao_syrup", has(ModItems.BLUE_CURACAO_SYRUP))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP))
                .unlockedBy("has_citrus_orange", has(ModItems.CITRUS_ORANGE))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUE_STEAK.get())
                .requires(ModItems.BLUE_CURACAO_SYRUP)
                .requires(Items.COOKED_BEEF)
                .requires(ModItems.CITRUS_LEMON)
                .unlockedBy("has_blue_curacao_syrup", has(ModItems.BLUE_CURACAO_SYRUP))
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .unlockedBy("has_citrus_lemon", has(ModItems.CITRUS_LEMON))
                .save(recipeOutput);

        //tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHOCOLATE_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("B")
                .define('B', Items.BREAD)
                .define('C', ModItems.CHOCOLATE_BREAD.get())
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_chocolate_bread", has(ModItems.CHOCOLATE_BREAD))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHOCOLATE_DOUBLE_BOILER.get())
                .pattern("IBI")
                .pattern("IWI")
                .pattern("ICI")
                .define('I', Items.IRON_INGOT)
                .define('B', Items.BUCKET)
                .define('W', Items.WATER_BUCKET)
                .define('C', Items.CAMPFIRE)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .unlockedBy("has_campfire", has(Items.CAMPFIRE))
                .save(recipeOutput);



    }
}
