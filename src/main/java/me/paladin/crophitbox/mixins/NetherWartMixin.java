package me.paladin.crophitbox.mixins;

import me.paladin.crophitbox.CropUtil;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockNetherWart.class)
public abstract class NetherWartMixin extends BlockBush {
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {
        CropUtil.updateWartMaxY(worldIn, pos, worldIn.getBlockState(pos).getBlock());
        return super.getSelectedBoundingBox(worldIn, pos);
    }
    
    @Override
    public MovingObjectPosition collisionRayTrace(World worldIn, BlockPos pos, Vec3 start, Vec3 end) {
        CropUtil.updateWartMaxY(worldIn, pos, worldIn.getBlockState(pos).getBlock());
        return super.collisionRayTrace(worldIn, pos, start, end);
    }
}
