package Bellumacraft;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.util.Random;

import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraftforge.common.*;
import net.minecraft.src.*;

import Bellumacraft.mine.*;
import Bellumacraft.money.*;
import Bellumacraft.design.*;
import Bellumacraft.beer.*;
import Bellumacraft.others.*;
import Bellumacraft.stair.*;
import Bellumacraft.step.*;
import Bellumacraft.armure.*;
import Bellumacraft.tools.*;


public class mod_Mine extends BaseMod implements IGuiHandler
{

	//--------------------------------------------blocks---------------------------------------------------------------------//
	public static int IDoutil = 20000;
	public static int CD = 20500;
	public static int ID = 220;	
	
    public static final Block block_adam = (new BlockAdam(ID, 0, Material.wood)).setBlockName("block_adam");
    public static final Block block_beer = (new BlockBeer(ID+1, 1, false)).setHardness(1F).setResistance(1F).setBlockName("Distributeur");
    public static final Block block_copper = (new BlockCopper(ID+2, 1, Material.wood)).setBlockName("block_copper");
    public static final Block block_mythril = (new BlockMythril(ID+3, 2, Material.wood)).setBlockName("block_mythril");
    public static final Block block_silver = (new BlockSilver(ID+4, 3, Material.wood)).setBlockName("block_silver");
    
    public static final Block block_stairlog = (new BlockStairLog(ID+8, 7, Material.wood)).setBlockName("block_stairlog");    
    
    public static final Block demidalleD = (new BlockHalfSlabMod(ID+9, 7, false)).setHardness(0.5F).setResistance(0.5F).setBlockName("Demi-dalle");
    public static final Block doubledemidalleD = (new BlockStepMod(ID+10, 7, Material.wood)).setHardness(0.5F).setResistance(0.5F).setBlockName("Double demi-dalle");
    
    public static Block cropBeer = (new BlockCropBeer(ID+17)).setBlockName("cropBeer").setStepSound(Block.soundGrassFootstep);
    
    public static final Block Fence = (new BlockFenceMod(ID+18, 4, Material.wood)).setBlockName("Fence");
    public static final Block FenceA = (new BlockFenceMod(ID+19, 5, Material.wood)).setBlockName("Fence");
    public static final Block FenceB = (new BlockFenceMod(ID+20, 6, Material.wood)).setBlockName("Fence");
    public static final Block Table = (new BlockTable(ID+21, 4, Material.glass)).setBlockName("Table");
    public static final Block Escalier = (new BlockStair(ID+22, 4, Material.glass)).setHardness(1F).setResistance(1F).setBlockName("Escalier");
    public static final Block Chaise = (new BlockChaise(ID+23)).setHardness(1F).setResistance(1F).setBlockName("Chaise");

    
    //----------------------------------------------------Items-----------------------------------------------------------//
    public static Item seedBeer = (new ItemSeeds(IDoutil, cropBeer.blockID, Block.tilledField.blockID)).setIconIndex(addTex("seedBeer", 'i')).setItemName("seedBeer");
    public static Item Beer = (new Item(IDoutil+1)).setIconIndex(addTex("Beer", 'i')).setItemName("Beer");
    public static final Item Cup = (new ItemCup(IDoutil+2)).setIconIndex(0).setItemName("Chope Vide");
    public static final Item BucketBeer = (new ItemCup(IDoutil+3)).setIconIndex(2).setItemName("seau de biere");
    public static final Item CupBeer = (new ItemDrink(IDoutil+4, 10, 0.0F, false)).setAlwaysEdible().setIconIndex(1).setItemName("Chope Pleine");
    
    //----------------------------------------------------Item Block------------------------------------------------------//
    public static final Item ItemTable = (new ItemTable(IDoutil+5, Material.glass).setIconIndex(1).setItemName("Table"));
    public static final Item ItemStair = (new ItemReed(IDoutil+6, Escalier)).setIconIndex(2).setItemName("Escalier");
    public static final Item ItemChaise = (new ItemReed(IDoutil+7, Chaise)).setIconIndex(25).setItemName("Chaise");
    public static final Item ItemBeer3D = (new ItemReed2(IDoutil+42, block_beer)).setIconIndex(37).setItemName("Distributeur");
    //--------------------------------------------------------------------------------------------------------------------//
    
    //--------------------------------------------------Music-------------------------------------------------------------//
    public static final Item zelda = (new ItemRecordForge(CD, "zelda", "zelda")).setIconIndex(37).setItemName("Record");
    public static final Item saria = (new ItemRecordForge(CD+1, "saria", "saria")).setIconIndex(37).setItemName("Record");
    
    //----------------------------------------------------biere (plante)---------------------------------------------------//
    public static int growBeer1 = addTex("growBeer1", 't');
    public static int growBeer2 = addTex("growBeer2", 't');
    public static int growBeer3 = addTex("growBeer3", 't');
    public static int growBeer4 = addTex("growBeer4", 't');
    public static int growBeer5 = addTex("growBeer5", 't');
    public static int growBeer6 = addTex("growBeer6", 't');
    public static int growBeer7 = addTex("growBeer7", 't');
    public static int growBeer8 = addTex("growBeer8", 't');
    
    //---------------------------------------------------armures---------------------------------------------------------------//
    
    static EnumArmorMaterial RUBIS = EnumHelper.addArmorMaterial("RUBIS", 10, new int[] {1, 2, 3, 4}, 20);
    static EnumArmorMaterial EMERALD = EnumHelper.addArmorMaterial("EMERALD", 10, new int[] {1, 2, 3, 4}, 20);
    static EnumArmorMaterial COPPER = EnumHelper.addArmorMaterial("COPPER", 10, new int[] {1, 2, 3, 4}, 20);
    static EnumArmorMaterial SAPHIR = EnumHelper.addArmorMaterial("SAPHIR", 10, new int[] {1, 2, 3, 4}, 20);
    static EnumArmorMaterial BLACK = EnumHelper.addArmorMaterial("BLACK", 10, new int[] {1, 2, 3, 4}, 20);
    
    static EnumToolMaterial toolMaterialRubis= EnumHelper.addToolMaterial("RUBIS", 2, 500, 7F, 3, 9);
    static EnumToolMaterial toolMaterialEmerald= EnumHelper.addToolMaterial("EMERALD", 2, 500, 7F, 3, 9);
    static EnumToolMaterial toolMaterialCopper= EnumHelper.addToolMaterial("COPPER", 2, 500, 7F, 3, 9);
    static EnumToolMaterial toolMaterialSaphir= EnumHelper.addToolMaterial("SAPHIR", 2, 500, 7F, 3, 9);
    
    public static final Item lunette = (new ItemArmor(IDoutil+40, mod_Mine.BLACK, 5, 0, 1)).setIconIndex(35).setItemName("lunette");
    public static final Item lunetteb = (new ItemArmor(IDoutil+41, mod_Mine.BLACK, 5, 0, 1)).setIconIndex(36).setItemName("lunette");
    public static final Item lunettec = (new ItemArmor(IDoutil+43, mod_Mine.BLACK, 5, 0, 1)).setIconIndex(38).setItemName("lunette");
    
    public static final Item casque_Rubis = (new ItemArmor(IDoutil+8, mod_Mine.RUBIS, 5, 0, 1)).setIconIndex(27).setItemName("casque_Rubis");
    public static final Item plastron_Rubis = (new ItemArmor(IDoutil+9, mod_Mine.RUBIS, 5, 1, 1)).setIconIndex(28).setItemName("plastron_Rubis");
    public static final Item jambières_Rubis = (new ItemArmor(IDoutil+10, mod_Mine.RUBIS, 5, 2, 1)).setIconIndex(29).setItemName("jambières_Rubis");
    public static final Item bottes_Rubis = (new ItemArmor(IDoutil+11, mod_Mine.RUBIS, 5, 3, 1)).setIconIndex(30).setItemName("bottes_Rubis");
    
    public static final Item casque_Emerald = (new ItemArmor(IDoutil+12, mod_Mine.EMERALD, 5, 0, 1)).setIconIndex(19).setItemName("casque_Emerald");
    public static final Item plastron_Emerald = (new ItemArmor(IDoutil+13, mod_Mine.EMERALD, 5, 1, 1)).setIconIndex(20).setItemName("plastron_Emerald");
    public static final Item jambières_Emerald = (new ItemArmor(IDoutil+14, mod_Mine.EMERALD, 5, 2, 1)).setIconIndex(21).setItemName("jambières_Emerald");
    public static final Item bottes_Emerald = (new ItemArmor(IDoutil+15, mod_Mine.EMERALD, 5, 3, 1)).setIconIndex(22).setItemName("bottes_Emerald");
    
    public static final Item casque_Saphir = (new ItemArmor(IDoutil+16, mod_Mine.SAPHIR, 5, 0, 1)).setIconIndex(23).setItemName("casque_Saphir");
    public static final Item plastron_Saphir = (new ItemArmor(IDoutil+17, mod_Mine.SAPHIR, 5, 1, 1)).setIconIndex(24).setItemName("plastron_Saphir");
    public static final Item jambières_Saphir = (new ItemArmor(IDoutil+18, mod_Mine.SAPHIR, 5, 2, 1)).setIconIndex(25).setItemName("jambières_Saphir");
    public static final Item bottes_Saphir = (new ItemArmor(IDoutil+19, mod_Mine.SAPHIR, 5, 3, 1)).setIconIndex(26).setItemName("bottes_Saphir");
    
    public static final Item casque_Copper = (new ItemArmor(IDoutil+20, mod_Mine.COPPER, 5, 0, 1)).setIconIndex(31).setItemName("casque_Copper");
    public static final Item plastron_Copper = (new ItemArmor(IDoutil+21, mod_Mine.COPPER, 5, 1, 1)).setIconIndex(32).setItemName("plastron_Copper");
    public static final Item jambières_Copper = (new ItemArmor(IDoutil+22, mod_Mine.COPPER, 5, 2, 1)).setIconIndex(33).setItemName("jambières_Copper");
    public static final Item bottes_Copper = (new ItemArmor(IDoutil+23, mod_Mine.COPPER, 5, 3, 1)).setIconIndex(34).setItemName("bottes_Copper");
    
    public static final Item pelleToolRubis= (new ItemToolPelle(IDoutil+24, toolMaterialRubis)).setIconIndex(11).setItemName("pelleTool");
    public static final Item piocheToolRubis= (new ItemToolPioche(IDoutil+25, toolMaterialRubis)).setIconIndex(12).setItemName("piocheTool");
    public static final Item hacheToolRubis= (new ItemToolHache(IDoutil+26, toolMaterialRubis)).setIconIndex(13).setItemName("hacheTool");
    public static final Item epeeToolRubis= (new ItemToolEpee(IDoutil+27, toolMaterialRubis)).setIconIndex(14).setItemName("epeeTool");
    
    public static final Item pelleToolEmerald= (new ItemToolPelle(IDoutil+28, toolMaterialEmerald)).setIconIndex(3).setItemName("pelleTool");
    public static final Item piocheToolEmerald= (new ItemToolPioche(IDoutil+29, toolMaterialEmerald)).setIconIndex(4).setItemName("piocheTool");
    public static final Item hacheToolEmerald= (new ItemToolHache(IDoutil+30, toolMaterialEmerald)).setIconIndex(5).setItemName("hacheTool");
    public static final Item epeeToolEmerald= (new ItemToolEpee(IDoutil+31, toolMaterialEmerald)).setIconIndex(6).setItemName("epeeTool");
    
    public static final Item pelleToolCopper= (new ItemToolPelle(IDoutil+32, toolMaterialCopper)).setIconIndex(15).setItemName("pelleTool");
    public static final Item piocheToolCopper= (new ItemToolPioche(IDoutil+33, toolMaterialCopper)).setIconIndex(16).setItemName("piocheTool");
    public static final Item hacheToolCopper= (new ItemToolHache(IDoutil+34, toolMaterialCopper)).setIconIndex(17).setItemName("hacheTool");
    public static final Item epeeToolCopper= (new ItemToolEpee(IDoutil+35, toolMaterialCopper)).setIconIndex(18).setItemName("epeeTool");
    
    public static final Item pelleToolSaphir= (new ItemToolPelle(IDoutil+36, toolMaterialSaphir)).setIconIndex(7).setItemName("pelleTool");
    public static final Item piocheToolSaphir= (new ItemToolPioche(IDoutil+37, toolMaterialSaphir)).setIconIndex(8).setItemName("piocheTool");
    public static final Item hacheToolSaphir= (new ItemToolHache(IDoutil+38, toolMaterialSaphir)).setIconIndex(9).setItemName("hacheTool");
    public static final Item epeeToolSaphir= (new ItemToolEpee(IDoutil+39, toolMaterialSaphir)).setIconIndex(10).setItemName("epeeTool");
    //public static final Item fauxTool= (new ItemToolFaux(ID, toolMaterial)).setIconIndex(4).setItemName("armure_casque");
    //-------------------------------------------------------------------------------------------------------------------------//
    
    //----------------------------------------------------autres------------------------------------------------------------------//
    public static mod_Mine instance;

    public Object getGuiElement(int var1, EntityPlayer var2, World var3, int var4, int var5, int var6)
    {
        System.out.println("Entree dans getguielement");

        if (var1 == 15)
        {
            //ModLoader.getMinecraftInstance().displayGuiScreen(new GuiBeer(var2.inventory, (TileEntityBeer)var2.worldObj.getBlockTileEntity(var4, var5, var6)));
            TileEntityBeer tile = (TileEntityBeer)var3.getBlockTileEntity(var4, var5, var6);
            return new GuiBeer(var2.inventory, tile);
        }

        return null;
    }
    
    public static int RenderTable;
    public static int RenderStair;
    
    public void addNewSound(String par1)
    {
    Minecraft mc = ModLoader.getMinecraftInstance();
    mc.installResource("streaming/" + par1, new File(mc.mcDataDir, "resources/streaming/" + par1));
    }   
    

    public void load()
    {
    	addNewSound("zelda.ogg");
    	addNewSound("saria.ogg");
    	//-------------------------Forge declaration (gui,outils,...)--------------------------//
        instance = this;
        ModLoader.setInGUIHook(this, true, true);
        ModLoader.setInGameHook(this, true, true);
        MinecraftForgeClient.preloadTexture("/mod_texture/terrain2.png");
        MinecraftForgeClient.preloadTexture("/mod_texture/item.png");
        MinecraftForge.setToolClass(piocheToolSaphir, "pickaxe", 2);
        MinecraftForge.setToolClass(pelleToolSaphir, "shovel", 2);
        MinecraftForge.setToolClass(hacheToolSaphir, "axe", 2);
        
        //------------------------------------registerblocks---------------------------//
        ModLoader.registerBlock(block_adam);
        ModLoader.registerBlock(block_beer);
        ModLoader.registerBlock(block_copper);
        ModLoader.registerBlock(block_mythril);
        ModLoader.registerBlock(block_silver);
        ModLoader.registerBlock(block_stairlog);
        ModLoader.registerBlock(demidalleD);
        ModLoader.registerBlock(doubledemidalleD);
        ModLoader.registerBlock(cropBeer);
        ModLoader.registerBlock(Fence);
        ModLoader.registerBlock(FenceA);
        ModLoader.registerBlock(FenceB);
        ModLoader.registerBlock(Table);
        ModLoader.registerBlock(Escalier);
        ModLoader.registerBlock(Chaise);
        
        //---------------------------addname--------------------------------//
        ModLoader.addName(block_adam, "block_adam");
        ModLoader.addName(block_beer, "Distributeur");
        ModLoader.addName(block_copper, "block_copper");
        ModLoader.addName(block_mythril, "block_mythril");
        ModLoader.addName(block_silver, "block_silver");
        ModLoader.addName(block_stairlog, "block_stairlog");
        ModLoader.addName(demidalleD, "Demi-dalle");
        ModLoader.addName(doubledemidalleD, "Double demi-dalle");
        ModLoader.addName(seedBeer, "Graine de Beer");
        ModLoader.addName(Beer, "Beer");
        ModLoader.addName(Fence, "Fence");
        ModLoader.addName(FenceB, "Fence");
        ModLoader.addName(FenceA, "Fence");
        ModLoader.addName(Cup, "Chope Vide");
        ModLoader.addName(BucketBeer, "seau de biere");
        ModLoader.addName(CupBeer, "Chope Pleine");
        ModLoader.addName(Table, "Table");
        ModLoader.addName(Escalier, "Escalier");
        ModLoader.addName(ItemTable, "Table");
        ModLoader.addName(ItemStair, "Escalier");
        
        ModLoader.addName(bottes_Rubis, "botte rubis");
        ModLoader.addName(jambières_Rubis, "jambiere rubis");
        ModLoader.addName(plastron_Rubis, "plastron rubis");
        ModLoader.addName(casque_Rubis, "casque rubis");
        
        ModLoader.addName(bottes_Saphir, "botte Saphir");
        ModLoader.addName(jambières_Saphir, "jambiere Saphir");
        ModLoader.addName(plastron_Saphir, "plastron Saphir");
        ModLoader.addName(casque_Saphir, "casque Saphir");
        
        ModLoader.addName(bottes_Emerald, "botte Emerald");
        ModLoader.addName(jambières_Emerald, "jambiere Emerald");
        ModLoader.addName(plastron_Emerald, "plastron Emerald");
        ModLoader.addName(casque_Emerald, "casque Emerald");
        
        ModLoader.addName(bottes_Copper, "botte Copper");
        ModLoader.addName(jambières_Copper, "jambiere Copper");
        ModLoader.addName(plastron_Copper, "plastron Copper");
        ModLoader.addName(casque_Copper, "casque Copper");
        
        ModLoader.addName(ItemChaise, "Chaise");
        
        ModLoader.addName(pelleToolRubis, "pelle");
        ModLoader.addName(piocheToolRubis, "pioche");
        ModLoader.addName(hacheToolRubis, "hache");
        ModLoader.addName(epeeToolRubis, "epee");
        
        ModLoader.addName(pelleToolEmerald, "pelle");
        ModLoader.addName(piocheToolEmerald, "pioche");
        ModLoader.addName(hacheToolEmerald, "hache");
        ModLoader.addName(epeeToolEmerald, "epee");
        
        ModLoader.addName(pelleToolCopper, "pelle");
        ModLoader.addName(piocheToolCopper, "pioche");
        ModLoader.addName(hacheToolCopper, "hache");
        ModLoader.addName(epeeToolCopper, "epee");
        
        ModLoader.addName(pelleToolSaphir, "pelle");
        ModLoader.addName(piocheToolSaphir, "pioche");
        ModLoader.addName(hacheToolSaphir, "hache");
        ModLoader.addName(epeeToolSaphir, "epee");
        
        ModLoader.addName(lunette, "lunette");
        ModLoader.addName(lunetteb, "lunette");
        ModLoader.addName(lunettec, "lunette");
        
        ModLoader.addName(ItemBeer3D, "Distributeur");
        
        
        
        
        //----------------------------------recipe-----------------------------------//
        ModLoader.addRecipe(new ItemStack(BucketBeer, 1), new Object[] {"#", '#', Beer});
        ModLoader.addRecipe(new ItemStack(Cup, 4), new Object[] {"# #", "# #", " # ", '#', Block.planks});
        ModLoader.addRecipe(new ItemStack(lunette, 4), new Object[] {"##", '#', Block.dirt});
        ModLoader.addRecipe(new ItemStack(lunetteb, 4), new Object[] {"##", '#', Block.sand});
        ModLoader.addRecipe(new ItemStack(bottes_Rubis, 4), new Object[] {"###", '#', Block.dirt});
        ModLoader.addRecipe(new ItemStack(jambières_Rubis, 4), new Object[] {"##", '#', Block.wood});
        ModLoader.addRecipe(new ItemStack(plastron_Rubis, 4), new Object[] {"###", '#', Block.wood});
        
        //-----------------------------------autres----------------------------------//
        //ModLoader.registerTileEntity(TileEntityBeer.class, "Distributeur");
        //MinecraftForge.registerBonemealHandler(new BoneMealHandler());
        //MinecraftForge.setGuiHandler(this, this);
        //----------------------------------------------------------------------------//
        
        //------------------------------------3d block--------------------------------//
        RenderTable = ModLoader.getUniqueBlockModelID(this, true);
        RenderStair = ModLoader.getUniqueBlockModelID(this, true);
        
        RenderBeer renderBeer = new RenderBeer();
        RenderChaise renderchaise = new RenderChaise();
        ModLoader.registerTileEntity(TileEntityBeer.class, "Distributeur", renderBeer);
        ModLoader.registerTileEntity(TileEntityChaise.class, "Chaise", renderchaise);
        //---------------------------------------------------------------------------//
    }

    public void generateSurface(World var1, Random var2, int var3, int var4)
    {
        for (int var5 = 0; var5 < 30; ++var5)
        {
            int var6 = var3 + var2.nextInt(16);
            int var7 = var2.nextInt(50);
            int var8 = var4 + var2.nextInt(16);
            (new WorldGenMinable(block_adam.blockID, 8)).generate(var1, var2, var6, var7, var8);
        }
    }
    
    public boolean renderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
    	if(l == RenderTable)
    	{
        return renderTable(block, i, j, k, renderblocks);
    	}
    	if(l == RenderStair)
    	{
        return renderStair(block, i, j, k, renderblocks);
    	}
		return false;
    }
    
    public boolean renderTable(Block block, int i, int j, int k, RenderBlocks renderblocks)
    {
    	/*
        renderblocks.overrideBlockTexture = Block.planks.blockIndexInTexture;
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1875F, 0.375F, 0.1875F);
        renderblocks.renderStandardBlock(block, i, j, k);
        block.setBlockBounds(0.8125F, 0.0F, 0.0F, 1.0F, 0.375F, 0.1875F);
        renderblocks.renderStandardBlock(block, i, j, k);
        block.setBlockBounds(0.8125F, 0.0F, 0.8125F, 1.0F, 0.375F, 1.0F);
        renderblocks.renderStandardBlock(block, i, j, k);
        block.setBlockBounds(0.0F, 0.0F, 0.8125F, 0.1875F, 0.375F, 1.0F);
        renderblocks.renderStandardBlock(block, i, j, k);
        renderblocks.overrideBlockTexture = -1;

        renderblocks.overrideBlockTexture = Block.glass.blockIndexInTexture;
        block.setBlockBounds(0.0F, 0.375F, 0.0F, 1.0F, 0.5F, 1.0F);
        renderblocks.renderStandardBlock(block, i, j, k);
        renderblocks.overrideBlockTexture = -1;
        return true;*/
    	
        renderblocks.overrideBlockTexture = Block.planks.blockIndexInTexture;
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1875F, 0.875F, 0.1875F);
        renderblocks.renderStandardBlock(block, i, j, k);
        block.setBlockBounds(0.8125F, 0.0F, 0.0F, 1.0F, 0.875F, 0.1875F);
        renderblocks.renderStandardBlock(block, i, j, k);
        block.setBlockBounds(0.8125F, 0.0F, 0.8125F, 1.0F, 0.875F, 1.0F);
        renderblocks.renderStandardBlock(block, i, j, k);
        block.setBlockBounds(0.0F, 0.0F, 0.8125F, 0.1875F, 0.875F, 1.0F);
        renderblocks.renderStandardBlock(block, i, j, k);
        renderblocks.overrideBlockTexture = -1;

        renderblocks.overrideBlockTexture = Block.glass.blockIndexInTexture;
        block.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderblocks.renderStandardBlock(block, i, j, k);
        renderblocks.overrideBlockTexture = -1;
    	block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }
    
    public boolean renderStair(Block block, int i, int j, int k, RenderBlocks renderblocks)
    {
    	boolean flag = false;
        renderblocks.overrideBlockTexture = Block.glass.blockIndexInTexture;
    	block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    	renderblocks.renderStandardBlock(block, i, j, k);
    	block.setBlockBounds(1.0F, 1.0F, 0.0F, 0.5F, 0.5F, 0.5F);
    	renderblocks.renderStandardBlock(block, i, j, k);
    	renderblocks.overrideBlockTexture = -1;
    	flag = true;
    	block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public static int addTex(String var0, char var1)
    {
        return var1 == 116 ? ModLoader.addOverride("/terrain.png", "/mod_texture/" + var0 + ".png") : (var1 == 105 ? ModLoader.addOverride("/gui/items.png", "/mod_texture/" + var0 + ".png") : 0);
    }

    public String getVersion()
    {
        return "1.3.2";
    }

    public boolean clientSideRequired()
    {
        return true;
    }

    public boolean serverSideRequired()
    {
        return true;
    }


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
}
