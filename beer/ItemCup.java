package Bellumacraft.beer;

import net.minecraft.src.*;
import java.util.ArrayList;

public class ItemCup extends Item 
{
    public ItemCup(int var1)
    {
        super(var1);
        this.maxStackSize = 64;
    }

    public String getTextureFile()
    {
        return "/mod_texture/item.png";
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this));
    }
}
