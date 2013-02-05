package Bellumacraft.beer;

import net.minecraft.src.*;

import java.util.ArrayList;
import java.util.Random;

import Bellumacraft.mod_Mine;

public class BlockBeer extends BlockContainer  
{
	public static mod_Mine instance;
    private Random BeerRand = new Random();
    private final boolean isActive;
    private static boolean keepBeerInventory = false;
    
    public BlockBeer(int i, int id, boolean var3)
    
    {
       super(i, id, Material.wood);
       this.isActive = var3;
    }

    public int idDropped(int var1, Random var2)
    {
        return this.blockID;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World var1, int var2, int var3, int var4)
    {
        super.onBlockAdded(var1, var2, var3, var4);
        this.setDefaultDirection(var1, var2, var3, var4);
    }

    private void setDefaultDirection(World var1, int var2, int var3, int var4)
    {
        if (!var1.isRemote)
        {
            int var5 = var1.getBlockId(var2, var3, var4 - 1);
            int var6 = var1.getBlockId(var2, var3, var4 + 1);
            int var7 = var1.getBlockId(var2 - 1, var3, var4);
            int var8 = var1.getBlockId(var2 + 1, var3, var4);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            var1.setBlockMetadataWithNotify(var2, var3, var4, var9);
        }
    }

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5)
    {/*
    	
            TileEntityBeer var6 = (TileEntityBeer)var1.getBlockTileEntity(var2, var3, var4);
            if(var6 != null)
            {
            var5.openGui(mod_Mine.instance, 15, var1, var2, var3, var4);
            return true;
            }
            return true;        */
        if (var1.isRemote)
        {
            return true;
        }
        else
        {
        	
            TileEntityBeer var6 = (TileEntityBeer)var1.getBlockTileEntity(var2, var3, var4);
            /*
            if(var6 != null)
            {
            var5.openGui(mod_Mine.instance, 15, var1, var2, var3, var4);
            return true;
            }
            return true;        
            */
            if (var6 != null)
            {
                //var5.displayGUIBeer(var6);
                return true;
            }

            return true;
        }
    }

    /**
     * Returns the TileEntity used by this block.
     */
    public TileEntity getBlockEntity()
    {
            return new TileEntityBeer();
        
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int rotation = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (rotation == 0)
        {
        	world.setBlockMetadataWithNotify(i, j, k, 2);
        }

        if (rotation == 1)
        {
        	world.setBlockMetadataWithNotify(i, j, k, 5);
        }

        if (rotation == 2)
        {
        	world.setBlockMetadataWithNotify(i, j, k, 3);
        }

        if (rotation == 3)
        {
        	world.setBlockMetadataWithNotify(i, j, k, 4);
        }
    }

    /**
     * Called whenever the block is removed.
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepBeerInventory)
        {
            TileEntityBeer var5 = (TileEntityBeer)par1World.getBlockTileEntity(par2, par3, par4);

            for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
            {
                ItemStack var7 = var5.getStackInSlot(var6);

                if (var7 != null)
                {
                    float var8 = this.BeerRand.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.BeerRand.nextFloat() * 0.8F + 0.1F;
                    float var10 = this.BeerRand.nextFloat() * 0.8F + 0.1F;

                    while (var7.stackSize > 0)
                    {
                        int var11 = this.BeerRand.nextInt(21) + 10;

                        if (var11 > var7.stackSize)
                        {
                            var11 = var7.stackSize;
                        }

                        var7.stackSize -= var11;
                        EntityItem var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));
                        float var13 = 0.05F;
                        var12.motionX = (double)((float)this.BeerRand.nextGaussian() * var13);
                        var12.motionY = (double)((float)this.BeerRand.nextGaussian() * var13 + 0.2F);
                        var12.motionZ = (double)((float)this.BeerRand.nextGaussian() * var13);
                        par1World.spawnEntityInWorld(var12);
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    
    public void onBlockPlaced(World world, int i, int j, int k, int par5)
    {
        if (par5 == 0)
        {
            int metadata = world.getBlockMetadata(i, j, k);
            world.setBlockMetadataWithNotify(i, j, k, metadata | 4);
        }
    }
    
    public int getRenderType()
    {
       return -1;
    }

    public boolean isOpaqueCube()
    {
       return false;
    }
    
    public boolean renderAsNormalBlock()
    {
       return false;
    }

    public String getTextureFile()
    {
        return "/mod_texture/terrain2.png";
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return null;
	}
}
