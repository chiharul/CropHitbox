package me.paladin.crophitbox.mixins;

import me.paladin.crophitbox.CropUtil;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Block.class)
public interface IblockAccesor {
    @Accessor("minX")
    void setMinX(double minX);

    @Accessor("minY")
    void setMinY(double minY);

    @Accessor("minZ")
    void setMinZ(double minZ);

    @Accessor("maxX")
    void setMaxX(double maxX);

    @Accessor("maxY")
    void setMaxY(double maxY);

    @Accessor("maxZ")
    void setMaxZ(double maxZ);
}
