package me.paladin.crophitbox;

import me.paladin.crophitbox.mixins.BlockAccessor;

import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
//import net.minecraft.bloc
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockCocoa;

public class CropUtil {


    public static final AxisAlignedBB[] CARROT_POTATO_BOX = {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.4375D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)
    };
    public static final AxisAlignedBB FULL_BLOCK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB[] WHEAT_BOX = {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)
    };
    public static final AxisAlignedBB[] NETHER_WART_BOX = {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6875D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)
    };
    public static void setFullBlock(Block block) {
        BlockAccessor accessor = (BlockAccessor) block;
        accessor.setMinX(0.0);
        accessor.setMinY(0.0);
        accessor.setMinZ(0.0);
        accessor.setMaxX(1.0);
        accessor.setMaxY(1.0);
        accessor.setMaxZ(1.0);
    }


    public static void updateCropsMaxY(World world, BlockPos pos, Block block) {
        final IBlockState blockState = world.getBlockState(pos);
        final Integer ageValue = blockState.getValue(BlockCrops.AGE);
        BlockAccessor accessor = (BlockAccessor) block;
        accessor.setMaxY(
                blockState.getBlock() instanceof BlockPotato || blockState.getBlock() instanceof BlockCarrot// || blockState.getBlock() instanceof BlockMushroom
                        ? CARROT_POTATO_BOX[ageValue].maxY
                        : WHEAT_BOX[ageValue].maxY
        );
    }


    public static void updateWartMaxY(World world, BlockPos pos, Block block) {
        ((BlockAccessor) block).setMaxY(NETHER_WART_BOX[world.getBlockState(pos).getValue(BlockNetherWart.AGE)].maxY);
    }

}
