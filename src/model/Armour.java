// FILE: Armour.java
// AUTHOR: Elijah Combes
// PURPOSE: Container class for Armour objects
// COMMENTS: 
// REQUIRES: ConcreteItem super class
// Last Mod: 27/04/2020

package model.items;
 
public class Armour extends ConcreteItem
{
    private String material; // fields

    // Default constructor for Armour Item
    public Armour()
    {
        super();
        material = "";
    }
   
    // Alternate constructor for Armour items
    public Armour(String inName, int inCost, int inMin, int inMax, String inMaterial)
    {
        super(inName, inCost, inMin, inMax);
        material = inMaterial;
    }

    // Accessors
    public String getMaterial()
    {
        return material;
    }

    // Mutators
    public void setMaterial( String inMaterial )
    {
        material = inMaterial;
    }

    // NAME: toString
    // IMPORTS: none
    // EXPORTS: String representation of Armour object
    @Override
    public String toString()
    {
        return (super.toString() + ", Material: " + material);
    }
}