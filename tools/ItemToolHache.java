package Bellumacraft.tools;

import java.util.ArrayList;
import net.minecraft.src.*;

public class ItemToolHache extends ItemPickaxe  
{  
	public ItemToolHache (int i, EnumToolMaterial enumtoolmaterial)
        {
                super(i, enumtoolmaterial);
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