// FILE: Potion.java
// AUTHOR: Elijah Combes
// PURPOSE: container class for Potion objects
package model.items;

public class Potion extends ConcreteItem 
{
    // NAME: Potion
    // PURPOSE: default constructor
    // IMPORTS: none
    // EXPORTS: Potion
    public Potion()
    {
        super();
    }
    
    // NAME: Potion
    // PURPOSE: alternate constructor for Potion object 
    // IMPORTS: all potion fields
    // EXPORTS: Potion object
    public Potion(String inName, int inMin, int inMax, int inCost)
    {
        super(inName, inCost, inMin, inMax);
    }

    // NAME: toString
    // PURPOSE: overrides superclass method in Item
    // IMPORTS: none 
    // EXPORTS:String representation of this object
    @Override
    public String toString()
    {
        return super.toString();
    }

}