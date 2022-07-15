package com.glodblock.github.common.block;

import appeng.block.AEBaseTileBlock;
import com.glodblock.github.common.tile.TileBurette;
import com.glodblock.github.inventory.GuiType;
import com.glodblock.github.inventory.InventoryHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBurette extends AEBaseTileBlock {

    public BlockBurette() {
        super(Material.IRON);
        setTileEntity(TileBurette.class);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {
            return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
        }
        TileBurette tile = getTileEntity(world, pos);
        if (tile != null) {
            if (!world.isRemote) {
                InventoryHandler.openGui(player, world, pos, facing, GuiType.PRECISION_BURETTE);
            }
            return true;
        }
        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

}