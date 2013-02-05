package Bellumacraft.design;

import java.util.Random;

import Bellumacraft.mod_Mine;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockChaise extends BlockMountable{
        
        public BlockChaise(int i)
        
        {
                super(i, Material.wood);
                this.setCreativeTab(CreativeTabs.tabBlock);
        }
        
    public TileEntity getBlockEntity()

        {       
                try
                        {
                        return new TileEntityChaise();
                        }

                catch(Exception exception)
                        {
                        throw new RuntimeException(exception);
                        }       
        }
        
        public int idDropped(int i, Random random, int j)
        {
                return mod_Mine.ItemChaise.shiftedIndex;
        }
        

public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
   {
      int rotation = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
      int metadata = world.getBlockMetadata(i, j, k) & 4;
      int sens = 0;

       if (rotation == 0)
       {
          sens = 0;
       }

       if (rotation == 1)
       {
          sens = 1;
       }

       if (rotation == 2)
       {
          sens = 2;
       }

       if (rotation == 3)
       {
           sens = 3;
       }

       world.setBlockMetadataWithNotify(i, j, k, sens | metadata );
   }
 
            
        public int quantityDropped(Random random)
        {
                return 1;
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
}
 