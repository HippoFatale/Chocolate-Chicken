package hippofatale.chocolatechickenmod.util;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CHOCOLATE_TOOL = createTag("needs_chocolate_tool");
        public static final TagKey<Block> INCORRECT_FOR_CHOCOLATE_TOOL = createTag("incorrect_for_chocolate_tool");


        public static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> CITRUS_FRUITS = createTag("citrus_fruits");
        public static final TagKey<Item> CHOCOLATE_FOOD = createTag("chocolate_food");
        public static final TagKey<Item> CHOCOLATE_TOOLS = createTag("chocolate_tools");

        public static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ChocolateChickenMod.MOD_ID, name));
        }
    }

}
