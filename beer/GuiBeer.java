package Bellumacraft.beer;

import org.lwjgl.opengl.GL11;
import net.minecraft.src.*;

public class GuiBeer extends GuiContainer
{
    private TileEntityBeer BeerInventory;
    private int leveldose;

    public GuiBeer(InventoryPlayer par1InventoryPlayer, TileEntityBeer par2TileEntityFurnace)
    {
        super(new ContainerBeer(par1InventoryPlayer, par2TileEntityFurnace));
        this.BeerInventory = par2TileEntityFurnace;
        this.leveldose = 70 / this.BeerInventory.Getlevel();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString("Distributeur", 80, 6, 4210752);
        this.fontRenderer.drawString("Inventaire", 100, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        int var4 = this.mc.renderEngine.getTexture("/gui/distributor.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        if (this.BeerInventory.isBeering())
        {
            var7 = this.BeerInventory.getBeereTimeRemainingScaled(7) * this.leveldose;
            int var8 = (10 - this.BeerInventory.getBeereTimeRemainingScaled(7)) * this.leveldose;
            this.drawTexturedModalRect(var5 + 58, var6 + 8 + var8, 177, 70 - var7, 14, 70);
        }

        var7 = this.BeerInventory.getCoolProgressScaled(42);
        this.drawTexturedModalRect(var5 + 79, var6 + 35, 190, 0, var7 + 1, 16);
    }
}
