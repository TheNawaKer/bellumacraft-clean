package Bellumacraft.design;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

import Bellumacraft.mod_Mine;

public class RenderChaise extends TileEntitySpecialRenderer{

        public RenderChaise ()
        {
                chaise = new ModelChaise ();
        }
        

        public void renderAModelAt(TileEntityChaise  tileentity1, double d, double d1, double d2, float f)
                {   
                   int orientation = 0;
                 
                   Block block = tileentity1.getBlockType();
                   orientation = tileentity1.getBlockMetadata();     
                   mod_Mine .Chaise .setBlockBounds(0.060F, 0F, 0.060F, 0.940F, 1F, 0.940F);
                   GL11.glPushMatrix();
                   GL11.glTranslatef((float) d + 0.5F, (float) d1 +1.5F, (float) d2 +0.5F );
                   if (orientation  == 0)
                   {
                       GL11.glRotatef(0, 0.0F, 1F, 0.0F);
                       GL11.glRotatef(180, 0.0F, 0.0F, 1F);
                   }

                   if (orientation  == 1)
                   {
                       GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                       GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
                   }

                   if (orientation  == 2)
                   {
                       GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                       GL11.glRotatef(180F, 0.0F, 0F, 1.0F);
                   }

                   if (orientation == 3)
                   {
                       GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
                       GL11.glRotatef(180F, 1.0F, 0F, 0.0F);
                   }
                   
                   bindTextureByName("/mod_BlockTuto/Texture_BlockTuto.png");
                   GL11.glPushMatrix();
                   chaise.renderModel(0.0625F);
                   GL11.glPopMatrix();
                   GL11.glPopMatrix();
                }
     
        
        public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
        {
                renderAModelAt((TileEntityChaise )tileentity, d, d1, d2, f);
        }
        
        private ModelChaise  chaise ;
}
 