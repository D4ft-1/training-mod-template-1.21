package com.d4ft.training.item;

import com.d4ft.training.TrainingMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SAPPHIRE = registerItem( "sapphire", new Item(new Item.Settings()));
    public static final Item RAW_SAPPHIRE = registerItem( "raw_sapphire", new Item(new Item.Settings()));
 //comment

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TrainingMod.MOD_ID, name), item);

    }

    public static void registerModItems() {
        TrainingMod.LOGGER.info("Registering Mod Items for " + TrainingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
           fabricItemGroupEntries.add(SAPPHIRE);
           fabricItemGroupEntries.add(RAW_SAPPHIRE);

        });
    }
}

