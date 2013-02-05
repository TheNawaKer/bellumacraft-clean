package Bellumacraft.step;

import java.util.ArrayList;
import net.minecraft.src.*;

import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import Bellumacraft.mod_Mine;

public class BlockHalfSlabMod extends Block  
{
	private boolean blockType;
	
    public BlockHalfSlabMod(int var1, int var2, boolean par2)
    {
        super(var1, var2, Material.wood);
        this.setBounds();
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.blockType = par2;
        if (!par2)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }       

        
    }

    private void setBounds()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World var1, int var2, int var3, int var4)
    {
        
        if (this != mod_Mine.demidalleD)
        {
            super.onBlockAdded(var1, var2, var3, var4);
        }

        int var5 = var1.getBlockId(var2, var3 - 1, var4);
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        int var7 = var1.getBlockMetadata(var2, var3 - 1, var4);

        if (var6 == var7)
        {
            if (var5 == this.blockID)
            {
                var1.setBlockWithNotify(var2, var3, var4, 0);
                var1.setBlockAndMetadataWithNotify(var2, var3 - 1, var4, mod_Mine.doubledemidalleD.blockID, var6);
            }
        }

    }
    
    public void setBlockBoundsForItemRender()
    {
        if (this.blockType)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
    }
    
    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        if (this.blockType)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            boolean var5 = (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) != 0;

            if (var5)
            {
                this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (this.blockType)
        {
            return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
        }
        else if (par5 != 1 && par5 != 0 && !super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5))
        {
            return false;
        }
        else
        {
            int var6 = par2 + Facing.offsetsXForSide[Facing.faceToSide[par5]];
            int var7 = par3 + Facing.offsetsYForSide[Facing.faceToSide[par5]];
            int var8 = par4 + Facing.offsetsZForSide[Facing.faceToSide[par5]];
            boolean var9 = (par1IBlockAccess.getBlockMetadata(var6, var7, var8) & 8) != 0;
            return var9 ? (par5 == 0 ? true : (par5 == 1 && super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5) ? true : !func_72241_e(par1IBlockAccess.getBlockId(par2, par3, par4)) || (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) == 0)) : (par5 == 1 ? true : (par5 == 0 && super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5) ? true : !func_72241_e(par1IBlockAccess.getBlockId(par2, par3, par4)) || (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) != 0));
        }
    }
    
    @SideOnly(Side.CLIENT)
    private static boolean func_72241_e(int par0)
    {
        return par0 == mod_Mine.demidalleD.blockID;
    }
    
    public void onBlockPlaced(World par1World, int par2, int par3, int par4, int par5)
    {
        if (par5 == 0 && !this.blockType)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4) & 7;
            par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8);
        }
    }
    
    /**
     * called before onBlockPlacedBy by ItemBlock and ItemReed
     */
    public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        if (!this.blockType)
        {
            if (par5 == 0 || par5 != 1 && (double)par7 > 0.5D)
            {
                int var9 = par1World.getBlockMetadata(par2, par3, par4) & 7;
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 | 8);
            }
        }
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int i)
    {
        if(i == 1 || i == 0)
        {
            return 8;
        } else
        {
            return 7;
        }
    }
        
    public String getTextureFile()
    {
        return "/mod_texture/terrain2.png";
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this));
    }
}
