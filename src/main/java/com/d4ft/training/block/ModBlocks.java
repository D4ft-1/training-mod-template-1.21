package com.d4ft.training.block;

import com.d4ft.training.TrainingMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .instrument(NoteBlockInstrument.BIT)
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
                    .instrument(NoteBlockInstrument.BASEDRUM)
            )
    );

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(3.0F, 3.0F)
                            .instrument(NoteBlockInstrument.BASEDRUM)
            )
    );

    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(3.0F, 3.0F)
                            .sounds(BlockSoundGroup.DEEPSLATE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
            )
    );
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TrainingMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {

        Registry.register(Registries.ITEM, Identifier.of(TrainingMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TrainingMod.LOGGER.info("registering Mod Blocks for " + TrainingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.SAPPHIRE_BLOCK);
            fabricItemGroupEntries.add(RAW_SAPPHIRE_BLOCK);
        });
    }
}
