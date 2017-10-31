package codasylph.thaumicalchemy;

import java.util.Iterator;
import java.util.ArrayList;
import thaumcraft.api.aspects.Aspect;

public class AspectHelper
{
    public static Aspect getCompound(final Aspect aspect1, final Aspect aspect2) {
        final ArrayList<Aspect> compounds = (ArrayList<Aspect>)Aspect.getCompoundAspects();
        for (final Aspect aspect3 : compounds) {
            if ((aspect3.getComponents()[0] == aspect1 || aspect3.getComponents()[0] == aspect2) && (aspect3.getComponents()[1] == aspect1 || aspect3.getComponents()[1] == aspect2)) {
                return aspect3;
            }
        }
        return null;
    }
    
    public static float getRed(final Aspect a) {
        final String color = Integer.toHexString(a.getColor());
        return Integer.valueOf(color.substring(0, 2), 16) / 255.0f;
    }
    
    public static float getGreen(final Aspect a) {
        final String color = Integer.toHexString(a.getColor());
        return Integer.valueOf(color.substring(2, 4), 16) / 255.0f;
    }
    
    public static float getBlue(final Aspect a) {
        final String color = Integer.toHexString(a.getColor()).concat("00");
        return Integer.valueOf(color.substring(4, 6), 16) / 255.0f;
    }
}
