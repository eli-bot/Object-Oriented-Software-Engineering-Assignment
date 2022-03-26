// FILE: Enchantment.java
// AUTHOR: Elijah Combes
// PURPOSE: superclass for all enchantments, provides common methods and fields for them
//          decorator pattern "decorator", decorates an Item
package model.enchantments;

import model.items.Item;

public abstract class Enchantment extends Item
{
    protected Item next; // next item in the list of items
    protected String effect; // describes effect of this enchantment
    
    //public abstract int getDamage(int damage);
    // NAME: Enchantment
    // PURPOSE: default constructor
    // IMPORTS: none
    // EXPORTS: Enchantment object
    public Enchantment()
    {
        super();
        effect = "";
    }
    
    // NAME: Enchantment
    // PURPOSE: alternate constructor, adds this item to list of items
    // IMPORTS: next(Item) - next item in the list
    // EXPORTS: Enchantment object
    public Enchantment( Item next )
    {
        super();
        this.next = next;
    }

    // NAME: setNext
    // PURPOSE: adds this object to list of Item objects for decorator pattern, "next" points to the next
    //          object in the list
    // IMPORTS: next(Item) 
    // EXPORTS: none
    @Override
    public void setNext( Item next )
    {
        this.setNext(next);
    }

    // ACCESSORS - override as decorator pattern needs different implementation that normal ConcreteItems 
    @Override
    public int getCost()
    {
        int totalCost = cost;
        if(next != null)
        {
            totalCost = next.getCost() + this.cost;
        }
        return totalCost;
    }

    @Override
    public String getName()
    {
        return this.name;
    }
    
    // gets field data from the base item in the list
    @Override
    public int getMinEffect()
    {
        return next.getMinEffect();
    }

    @Override
    public int getMaxEffect()
    {
        return next.getMaxEffect();
    }

  /*  @Override 
    public int getDamage(int damage)
    {
        return next.getDamage(damage);
    }*/
    
    // NAME: toString
    // PURPOSE: converts enchantment data into string format
    // IMPORTS: none
    // EXPORTS: string
    @Override
    public String toString()
    {
        String str = "";

        if(next == null) // if this enchantment is not equipped on a weapon
        {
            str = ("Name: " + name + ", Effect: " + effect);
        }
        else
        {
            str = (this.name + " -> " + next.toString());
        }
        return str;    
    }
}    