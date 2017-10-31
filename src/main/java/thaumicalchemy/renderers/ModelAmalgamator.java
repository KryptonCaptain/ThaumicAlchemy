package me.codasylph.thaumicalchemy.renderers;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelAmalgamator extends ModelBase
{
    ModelRenderer UpperTube;
    ModelRenderer Outlet;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer IntakeLeft;
    ModelRenderer IntakeRight;
    ModelRenderer CrossTube;
    ModelRenderer RightTube;
    ModelRenderer LeftTube;
    ModelRenderer DownTube;
    ModelRenderer LOutlet;
    ModelRenderer ROutlet;
    ModelRenderer Container1;
    ModelRenderer Container2;
    
    public ModelAmalgamator() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.UpperTube = new ModelRenderer((ModelBase)this, 8, 9)).addBox(-0.5f, -5.0f, -0.5f, 1, 2, 1);
        this.UpperTube.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.UpperTube.setTextureSize(64, 32);
        this.UpperTube.mirror = true;
        this.setRotation(this.UpperTube, 0.0f, 0.0f, 0.0f);
        (this.Outlet = new ModelRenderer((ModelBase)this, 0, 2)).addBox(-1.5f, 6.0f, -1.5f, 3, 2, 3);
        this.Outlet.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Outlet.setTextureSize(64, 32);
        this.Outlet.mirror = true;
        this.setRotation(this.Outlet, 0.0f, 0.0f, 0.0f);
        (this.LeftArm = new ModelRenderer((ModelBase)this, 4, 9)).addBox(1.5f, -0.5f, -0.5f, 1, 8, 1);
        this.LeftArm.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.LeftArm.setTextureSize(64, 32);
        this.LeftArm.mirror = true;
        this.setRotation(this.LeftArm, 0.0f, 0.0f, 0.0f);
        (this.RightArm = new ModelRenderer((ModelBase)this, 4, 9)).addBox(-2.5f, -0.5f, -0.5f, 1, 8, 1);
        this.RightArm.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.RightArm.setTextureSize(64, 32);
        this.RightArm.mirror = true;
        this.setRotation(this.RightArm, 0.0f, 0.0f, 0.0f);
        (this.IntakeLeft = new ModelRenderer((ModelBase)this, 0, 7)).addBox(4.5f, -0.5f, -0.5f, 4, 1, 1);
        this.IntakeLeft.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.IntakeLeft.setTextureSize(64, 32);
        this.IntakeLeft.mirror = true;
        this.setRotation(this.IntakeLeft, 0.0f, 0.0f, 0.0f);
        (this.IntakeRight = new ModelRenderer((ModelBase)this, 0, 7)).addBox(-8.5f, -0.5f, -0.5f, 4, 1, 1);
        this.IntakeRight.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.IntakeRight.setTextureSize(64, 32);
        this.IntakeRight.mirror = true;
        this.setRotation(this.IntakeRight, 0.0f, 0.0f, 0.0f);
        (this.CrossTube = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.5f, -6.0f, -0.5f, 11, 1, 1);
        this.CrossTube.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.CrossTube.setTextureSize(64, 32);
        this.CrossTube.mirror = true;
        this.setRotation(this.CrossTube, 0.0f, 0.0f, 0.0f);
        (this.RightTube = new ModelRenderer((ModelBase)this, 0, 9)).addBox(-5.5f, -5.0f, -0.5f, 1, 6, 1);
        this.RightTube.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.RightTube.setTextureSize(64, 32);
        this.RightTube.mirror = true;
        this.setRotation(this.RightTube, 0.0f, 0.0f, 0.0f);
        (this.LeftTube = new ModelRenderer((ModelBase)this, 0, 9)).addBox(4.5f, -5.0f, -0.5f, 1, 6, 1);
        this.LeftTube.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.LeftTube.setTextureSize(64, 32);
        this.LeftTube.mirror = true;
        this.setRotation(this.LeftTube, 0.0f, 0.0f, 0.0f);
        (this.DownTube = new ModelRenderer((ModelBase)this, 8, 12)).addBox(-0.5f, 3.0f, -0.5f, 1, 3, 1);
        this.DownTube.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.DownTube.setTextureSize(64, 32);
        this.DownTube.mirror = true;
        this.setRotation(this.DownTube, 0.0f, 0.0f, 0.0f);
        (this.LOutlet = new ModelRenderer((ModelBase)this, 0, 2)).addBox(-1.5f, 7.0f, -1.5f, 3, 2, 3);
        this.LOutlet.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.LOutlet.setTextureSize(64, 32);
        this.LOutlet.mirror = true;
        this.setRotation(this.LOutlet, 0.0f, 0.0f, -1.570796f);
        (this.ROutlet = new ModelRenderer((ModelBase)this, 0, 2)).addBox(-1.5f, 7.0f, -1.5f, 3, 2, 3);
        this.ROutlet.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.ROutlet.setTextureSize(64, 32);
        this.ROutlet.mirror = true;
        this.setRotation(this.ROutlet, 0.0f, 0.0f, 1.570796f);
        (this.Container1 = new ModelRenderer((ModelBase)this, 24, 0)).addBox(3.5f, 1.0f, -1.5f, 3, 6, 3);
        this.Container1.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Container1.setTextureSize(64, 32);
        this.Container1.mirror = true;
        this.setRotation(this.Container1, 0.0f, 0.0f, 0.0f);
        (this.Container2 = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-6.5f, 1.0f, -1.5f, 3, 6, 3);
        this.Container2.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Container2.setTextureSize(64, 32);
        this.Container2.mirror = true;
        this.setRotation(this.Container2, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.UpperTube.render(f5);
        this.Outlet.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        this.IntakeLeft.render(f5);
        this.IntakeRight.render(f5);
        this.CrossTube.render(f5);
        this.RightTube.render(f5);
        this.LeftTube.render(f5);
        this.DownTube.render(f5);
        this.LOutlet.render(f5);
        this.ROutlet.render(f5);
        this.Container1.render(f5);
        this.Container2.render(f5);
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
