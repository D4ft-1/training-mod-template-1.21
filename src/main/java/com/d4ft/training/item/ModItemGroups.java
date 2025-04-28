package com.d4ft.training.item;

import com.d4ft.training.TrainingMod;
import com.d4ft.training.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModItemGroups {

    public static final ItemGroup SAPPHIRE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrainingMod.MOD_ID, "sapphire_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE))
                    .displayName(Text.translatable("itemgroup.training-mod.sapphire_items"))
                    .entries((displayContext, entries) -> {
                       entries.add(ModItems.SAPPHIRE);
                       entries.add(ModItems.RAW_SAPPHIRE);

                    })
                    .build());

    public static final ItemGroup SAPPHIRE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrainingMod.MOD_ID, "sapphire_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SAPPHIRE_BLOCK))
                    .displayName(Text.translatable("itemgroup.training-mod.sapphire_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.RAW_SAPPHIRE_BLOCK);

                    })
                    .build());

    public static void registerItemGroups() {
        TrainingMod.LOGGER.info("Registering Item Groups for " + TrainingMod.MOD_ID);
    }
}
