package me.codasylph.thaumicalchemy.renderers;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelEssentia extends ModelBase
{
    ModelRenderer Essentia4;
    ModelRenderer Essentia3;
    ModelRenderer Essentia2;
    ModelRenderer Essentia1;
    
    public ModelEssentia() {
        this.textureWidth = 16;
        this.textureHeight = 320;
        (this.Essentia1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 1, 2);
        this.Essentia1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Essentia1.setTextureSize(64, 32);
        this.Essentia1.mirror = false;
        this.setRotation(this.Essentia1, 0.0f, 0.0f, 0.0f);
        (this.Essentia2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 2, 2);
        this.Essentia2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Essentia2.setTextureSize(64, 32);
        this.Essentia2.mirror = false;
        this.setRotation(this.Essentia2, 0.0f, 0.0f, 0.0f);
        (this.Essentia3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 3, 2);
        this.Essentia3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Essentia3.setTextureSize(64, 32);
        this.Essentia3.mirror = false;
        this.setRotation(this.Essentia3, 0.0f, 0.0f, 0.0f);
        (this.Essentia4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -2.0f, -1.0f, 2, 4, 2);
        this.Essentia4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Essentia4.setTextureSize(64, 32);
        this.Essentia4.mirror = false;
        this.setRotation(this.Essentia4, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final int i) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        switch (i) {
            case 1: {
                this.Essentia1.render(f5);
                break;
            }
            case 2: {
                this.Essentia2.render(f5);
                break;
            }
            case 3: {
                this.Essentia3.render(f5);
                break;
            }
            case 4: {
                this.Essentia4.render(f5);
                break;
            }
            default: {
                this.Essentia4.render(f5);
                break;
            }
        }
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
