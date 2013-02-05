package Bellumacraft.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.src.*;

public class EntityMountableBlock extends Entity
{
    protected int orgBlockPosX;
    protected int orgBlockPosY;
    protected int orgBlockPosZ;
    protected int orgBlockID;

    /** List of timestamps (System.nanoTime) */
    private final List timestampList = new ArrayList();

    /** Flag profiling enabled */
    public boolean profilingEnabled = false;

    /** Current profiling section */
    private String profilingSection = "";
    
    /** List of parent sections */
    private final List sectionList = new ArrayList();
    
    /** Profiling map */
    private final Map profilingMap = new HashMap();
    
    public EntityMountableBlock(World world, double d, double d1, double d2)
    {
        super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0.0F;
        height = 0.0F;
        setPosition(d, d1, d2);
    }

    public EntityMountableBlock(World world, EntityPlayer entityplayer, int i, int j, int k, float f, float f1, float f2)
    {
        super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0.0F;
        height = 0.0F;
        orgBlockPosX = i;
        orgBlockPosY = j;
        orgBlockPosZ = k;
        orgBlockID = world.getBlockId(i, j, k);
        setPosition(f, f1, f2);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer entityplayer)
    {
        if (!super.interact(entityplayer))
        {
            if (!worldObj.isRemote && (riddenByEntity == null || riddenByEntity == entityplayer))
            {
                entityplayer.mountEntity(this);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        onEntityUpdate();
    }

    /**
     * Gets called every tick from main Entity class
     */
    public void onEntityUpdate()
    {
        startSection("entityBaseTick");

        if (riddenByEntity == null || riddenByEntity.isDead)
        {
            setDead();
        }
        else if (worldObj.getBlockId(orgBlockPosX, orgBlockPosY, orgBlockPosZ) != orgBlockID)
        {
            interact((EntityPlayer)riddenByEntity);
        }

        ticksExisted++;
        endSection();
    }
    
    public void startSection(String par1Str)
    {
        if (this.profilingEnabled)
        {
            if (this.profilingSection.length() > 0)
            {
                this.profilingSection = this.profilingSection + ".";
            }

            this.profilingSection = this.profilingSection + par1Str;
            this.sectionList.add(this.profilingSection);
            this.timestampList.add(Long.valueOf(System.nanoTime()));
        }
    }
        

            /**
             * End section
             */
            public void endSection()
            {
                if (this.profilingEnabled)
                {
                    long var1 = System.nanoTime();
                    long var3 = ((Long)this.timestampList.remove(this.timestampList.size() - 1)).longValue();
                    this.sectionList.remove(this.sectionList.size() - 1);
                    long var5 = var1 - var3;

                    if (this.profilingMap.containsKey(this.profilingSection))
                    {
                        this.profilingMap.put(this.profilingSection, Long.valueOf(((Long)this.profilingMap.get(this.profilingSection)).longValue() + var5));
                    }
                    else
                    {
                        this.profilingMap.put(this.profilingSection, Long.valueOf(var5));
                    }

                    if (var5 > 100000000L)
                    {
                        System.out.println("Something\'s taking too long! \'" + this.profilingSection + "\' took aprox " + (double)var5 / 1000000.0D + " ms");
                    }

                    this.profilingSection = !this.sectionList.isEmpty() ? (String)this.sectionList.get(this.sectionList.size() - 1) : "";
                }
            }
    public void entityInit()
    {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }
}