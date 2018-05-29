package codasylph.thaumicalchemy;

import thaumcraft.api.aspects.Aspect;

public class EssentiaTank
{
    public Aspect type;
    public int amount;
    public int capacity;
    
    public EssentiaTank() {
        this.type = null;
        this.amount = 0;
        this.capacity = 64;
    }
    
    public EssentiaTank(final Aspect t, final int a, final int c) {
        this.type = t;
        this.amount = a;
        this.capacity = c;
    }
    
    public boolean contains(final Aspect a) {
        return this.type == a;
    }
    
    public void setCapacity(final int cap) {
        this.capacity = cap;
    }
    
    public void setContent(final Aspect a, final int i) {
        this.type = a;
        this.amount = i;
    }
    
    public Aspect getAspect() {
        return this.type;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    public int add(final Aspect a, final int i) {
        if (a == this.type) {
            final int added = Math.min(this.capacity - this.amount, i);
            this.amount += added;
            return added;
        }
        if (this.type == null) {
            this.type = a;
            this.amount = Math.min(this.capacity - this.amount, i);
            return i;
        }
        return 0;
    }
    
    public int remove(final Aspect a, final int i) {
        if (a == this.type) {
            //System.out.println("Type Matches");
            final int removed = Math.min(this.amount, i);
            //System.out.println("Removing " + removed);
            this.amount -= removed;
            //System.out.println(this.amount + " left.");
            if (this.amount <= 0) {
                this.type = null;
            }
            return removed;
        }
        //System.out.println("No match or no essentia present");
        return 0;
    }
}
