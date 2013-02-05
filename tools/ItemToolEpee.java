package Bellumacraft.tools;

import java.util.ArrayList;
import net.minecraft.src.*;

public class ItemToolEpee extends ItemPickaxe  
{  
	public ItemToolEpee (int i, EnumToolMaterial enumtoolmaterial)
        {
                super(i, enumtoolmaterial);
        }
        
        public boolean isFull3D()
        {
            return true;
        }
        
        public int getItemEnchantability()
        {
            return this.toolMaterial.getEnchantability();
        }
        
        public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            return par1ItemStack;
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