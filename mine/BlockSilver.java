package Bellumacraft.mine;

import net.minecraft.src.*;
import java.util.ArrayList;
import java.util.Random;

public class BlockSilver extends Block  
{
	public BlockSilver(int var1, int var2, Material var3)
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

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return this.blockID;
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
