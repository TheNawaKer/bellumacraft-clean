package Bellumacraft.step;

import net.minecraft.src.*;
import java.util.ArrayList;
import java.util.Random;

import Bellumacraft.mod_Mine;

public class BlockStepMod extends Block 
{
	public BlockStepMod(int var1, int var2, Material var3)
    {
        super(var1, var2, var3);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return 1;
    }

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
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
    	return mod_Mine.demidalleD.blockID;
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this));
    }

    public String getTextureFile()
    {
        return "/mod_texture/terrain2.png";
    }
}
