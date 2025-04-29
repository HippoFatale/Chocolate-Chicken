package hippofatale.chocolatechickenmod.item;

import hippofatale.chocolatechickenmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CHOCOLATE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CHOCOLATE_TOOL,
            59,
            2f,
            0f,
            15,
            () -> Ingredient.of(ModItems.CHOCOLATE_BREAD));

}
