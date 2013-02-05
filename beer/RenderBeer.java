package Bellumacraft.beer;

import org.lwjgl.opengl.GL11;

import Bellumacraft.mod_Mine;
import net.minecraft.src.*;

public class RenderBeer extends TileEntitySpecialRenderer{
	
   public RenderBeer ()
   {
      distrib = new ModelBeer ();
   }
   
   public void renderAModelAt(TileEntityBeer tileentity1, double d, double d1, double d2, float f)
   {   
      int orientation = 0;
    
      Block block = tileentity1.getBlockType();
      orientation = tileentity1.getBlockMetadata();     
      mod_Mine .block_beer .setBlockBounds(0.060F, 0F, 0.060F, 0.940F, 1F, 0.940F);
      GL11.glPushMatrix();
      GL11.glTranslatef((float) d + 0.5F, (float) d1 +1.5F, (float) d2 +0.5F );

      if (orientation == 0)
      {    	  
          GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
          GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      }
      else if (orientation == 5)
      {
          GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
          GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      }
      else if (orientation == 3)
      {
          GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
          GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      }
      else if (orientation == 4)
      {
          GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
          GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      }
      else if (orientation == 2)
      {
          GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
          GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
      } 
      
      bindTextureByName("/mod_texture/distrib2.png");
      GL11.glPushMatrix();
      distrib.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }
   
   public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
   {
      renderAModelAt((TileEntityBeer )tileentity, d, d1, d2, f);
   }
   
   private ModelBeer  distrib ;
}