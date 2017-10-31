package me.codasylph.thaumicalchemy.renderers;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelJar extends ModelBase
{
    ModelRenderer MidContainer;
    
    public ModelJar() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.MidContainer = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.5f, -3.0f, -1.5f, 3, 6, 3);
        this.MidContainer.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.MidContainer.setTextureSize(64, 32);
        this.MidContainer.mirror = true;
        this.setRotation(this.MidContainer, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.MidContainer.render(f5);
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
