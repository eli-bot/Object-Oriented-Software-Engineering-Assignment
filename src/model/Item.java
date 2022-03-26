// FILE: Item.java
// AUTHOR: Elijah Combes
// PURPOSE: Abstract class to define an Item, contains abstract methods necessary for strategy pattern and
//          common fields and methods to all items.
package model.items;

import java.util.*;

public abstract class Item 
{
    protected String name; // item name
    protected boolean isEquipped; // true if equipped
    protected int cost; // cost of item

    public abstract int getDamage(int damage); // gets the damage of an item
    public abstract String getName(); // gets the items name
    public abstract int getCost(); // gets the items cost
    public abstract void setNext(Item next); // sets the next item in a list of items
    public abstract int getMinEffect(); // gets the minimum effect of an item, may be damaging or healing
    public abstract int getMaxEffect(); // gets the maximum effect of an item ""
    public abstract String toString(); // converts Item to string representation, different in all subclasses

    // default constructor
    public Item()
    {
        name = "";
        cost = 0;
        isEquipped = false;
    }
    // alternate constructor
    public Item(String inName, boolean inEquip, int inCost)
    {
        name = inName;
        cost = inCost;
        isEquipped = inEquip;
    }

    public void setEquipped(boolean newVal)
    {
        isEquipped = newVal; // true if equipped
    }

    public boolean getEquipped()
    {
        return isEquipped;
    }   
}