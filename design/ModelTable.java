package Bellumacraft.design;

import net.minecraft.src.*;

public class ModelTable extends ModelBase
{
  //fields
    ModelRenderer patte1;
    ModelRenderer patte2;
    ModelRenderer patte3;
    ModelRenderer patte4;
    ModelRenderer face;
  
  public ModelTable()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      patte1 = new ModelRenderer(this, 0, 0);
      patte1.addBox(0F, 0F, 0F, 2, 16, 2);
      patte1.setRotationPoint(-8F, 8F, 6F);
      patte1.setTextureSize(64, 32);
      patte1.mirror = true;
      setRotation(patte1, 0F, 0F, 0F);
      patte2 = new ModelRenderer(this, 0, 0);
      patte2.addBox(0F, 0F, 0F, 2, 16, 2);
      patte2.setRotationPoint(6F, 8F, 6F);
      patte2.setTextureSize(64, 32);
      patte2.mirror = true;
      setRotation(patte2, 0F, 0F, 0F);
      patte3 = new ModelRenderer(this, 0, 0);
      patte3.addBox(0F, 0F, 0F, 2, 16, 2);
      patte3.setRotationPoint(6F, 8F, -8F);
      patte3.setTextureSize(64, 32);
      patte3.mirror = true;
      setRotation(patte3, 0F, 0F, 0F);
      patte4 = new ModelRenderer(this, 0, 0);
      patte4.addBox(0F, 0F, 0F, 2, 16, 2);
      patte4.setRotationPoint(-8F, 8F, -8F);
      patte4.setTextureSize(64, 32);
      patte4.mirror = true;
      setRotation(patte4, 0F, 0F, 0F);
      face = new ModelRenderer(this, 0, 0);
      face.addBox(0F, 0F, 0F, 16, 1, 16);
      face.setRotationPoint(-8F, 8F, -8F);
      face.setTextureSize(64, 32);
      face.mirror = true;
      setRotation(face, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    patte1.render(f5);
    patte2.render(f5);
    patte3.render(f5);
    patte4.render(f5);
    face.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}