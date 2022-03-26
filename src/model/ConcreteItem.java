// FILE: ConcreteItem.java
// AUTHOR: Elijah Combes
// PURPOSE: class for ConcreteItem objects, created just so common code could be contained here
//          rather than have multiple instances in subclasses, ie Weapon, Armour, Potion
// COMMENTS: contains common methods and fields to subclasses and abstract methods for these classes
package model.items;

import model.items.Item;
import java.util.*;

public class ConcreteItem extends Item
{
    // ConcreteItem fields
    protected int minEffect; // minimum effect of the item: may be damage or healing
    protected int maxEffect; // maximum effect of the item: may be damage or healing
    
    // NAME: ConcreteItem
    // PURPOSE: default constructor 
    public ConcreteItem()
    {
        minEffect = 0;
        maxEffect = 0;
    }
    
    // NAME: ConcreteItem
    // PURPOSE: alternate constructor
    public ConcreteItem(String inName, int inCost, int inMin, int inMax)
    {
        name = inName;
        cost = inCost;
        minEffect = inMin;
        maxEffect = inMax;
        isEquipped = false;
    }

    // NAME: setNext
    // PURPOSE: abstract method in superclass that must be overwritten
    //          since decorator objects need this
    @Override
    public void setNext(Item next)
    {
        System.out.println("Error this is a ConcreteItem");
    }
    
    // Accessors common to all ConcreteItem's
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getDamage(int damage)
    {
        return damage;
    }

    @Override
    public int getCost()
    {
        return cost;
    }

    @Override
    public int getMinEffect()
    {
        return minEffect;
    }
   
    @Override
    public int getMaxEffect()
    {
        return maxEffect;
    }
    // ACCESSOR
    public void setCost(int newCost)
    {
        cost = newCost;
    }

    // NAME: rand
    // PURPOSE: returns a random number between the two imported numbers inclusive
    // IMPORTS: min, max - integers
    // EXPORTS: num (int)
    public static int rand(int min, int max)
    {
        int num;
        Random random = new Random();
        
        num = random.nextInt( ( max - min ) + 1 ) + min;
        return num;
    }

    // NAME: toString
    // PURPOSE: converts state of ConcreteItem to String format
    // IMPORTS: none
    // EXPORTS: String
    @Override
    public String toString()
    {
        return ("Name: "+ name+ ", Cost: "+cost+ ", Min: "+ minEffect+ ", Max: "+maxEffect );
    }
}