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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_SYRUP.get(), 4)
                .requires(Items.COCOA_BEANS)
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

        //chocolate food
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_BREAD.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.BREAD)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_CHICKEN.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_MUTTON.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_MUTTON)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_mutton", has(Items.COOKED_MUTTON))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_PORK.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_PORKCHOP)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHOCOLATE_STEAK.get())
                .requires(ModItems.CHOCOLATE_SYRUP)
                .requires(Items.COOKED_BEEF)
                .unlockedBy("has_chocolate_syrup", has(ModItems.CHOCOLATE_SYRUP))
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .save(recipeOutput);

        //chocolate tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHOCOLATE_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("B")
                .define('B', Items.BREAD)
                .define('C', ModItems.CHOCOLATE_BREAD.get())
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_chocolate_bread", has(ModItems.CHOCOLATE_BREAD))
                .save(recipeOutput);



    }
}
