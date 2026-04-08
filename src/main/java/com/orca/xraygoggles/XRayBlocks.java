package com.orca.xraygoggles;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import java.util.HashSet;
import java.util.Set;

public class XRayBlocks {
    private static final Set<Block> TRANSPARENT_BLOCKS = new HashSet<>();

    static {
        TRANSPARENT_BLOCKS.add(Blocks.STONE);
        TRANSPARENT_BLOCKS.add(Blocks.DIRT);
        TRANSPARENT_BLOCKS.add(Blocks.GRASS_BLOCK);
        TRANSPARENT_BLOCKS.add(Blocks.GRAVEL);
        TRANSPARENT_BLOCKS.add(Blocks.DEEPSLATE);
        TRANSPARENT_BLOCKS.add(Blocks.COBBLED_DEEPSLATE);
        TRANSPARENT_BLOCKS.add(Blocks.ANDESITE);
        TRANSPARENT_BLOCKS.add(Blocks.DIORITE);
        TRANSPARENT_BLOCKS.add(Blocks.GRANITE);
        TRANSPARENT_BLOCKS.add(Blocks.TUFF);
        TRANSPARENT_BLOCKS.add(Blocks.CALCITE);
        TRANSPARENT_BLOCKS.add(Blocks.COBBLESTONE);
        TRANSPARENT_BLOCKS.add(Blocks.NETHERRACK);
        TRANSPARENT_BLOCKS.add(Blocks.SANDSTONE);
        TRANSPARENT_BLOCKS.add(Blocks.RED_SANDSTONE);
        TRANSPARENT_BLOCKS.add(Blocks.SAND);
        TRANSPARENT_BLOCKS.add(Blocks.RED_SAND);
        TRANSPARENT_BLOCKS.add(Blocks.COARSE_DIRT);
        TRANSPARENT_BLOCKS.add(Blocks.ROOTED_DIRT);
    }

    public static boolean shouldBeTransparent(Block block) {
        return TRANSPARENT_BLOCKS.contains(block);
    }
}
