package hippofatale.chocolatechickenmod.block.entity;

import hippofatale.chocolatechickenmod.ChocolateChickenMod;
import hippofatale.chocolatechickenmod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ChocolateChickenMod.MOD_ID);

    public static final Supplier<BlockEntityType<ChocolateDoubleBoilerBlockEntity>> CHOCOLATE_DOUBLE_BOILER_BE = BLOCK_ENTITIES.register("chocolate_double_boiler_be",
            () -> BlockEntityType.Builder.of(
                    ChocolateDoubleBoilerBlockEntity::new, ModBlocks.CHOCOLATE_DOUBLE_BOILER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
