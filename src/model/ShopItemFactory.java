// FILE: ShopItemFactory.java
// AUTHOR: Elijah Combes
// PURPOSE: chooses correct item to create based on parameters
//          used to decouple classes from Item subclasses
package model;

import model.items.Item;
import model.items.Armour;
import model.items.Weapon;
import model.items.HealingPotion;
import model.items.DamagePotion;
import model.items.Potion;

public class ShopItemFactory 
{
    // NAME: createItem
    // IMPORTS: symbol, str[]
    // EXPORTS: Item
    // PURPOSE: chooses coorect Item subclass to create based on the imported symbol
    //          uses str[] to pass to Item constructors            
    public static Item createItem(String symbol, String[] str)
    {
        Item newItem = null;
        int min = Integer.parseInt(str[2]);
        int max =  Integer.parseInt(str[3]);
        int cost = Integer.parseInt(str[4]);
        if( symbol.equals( "A" ) ) // Armour
        {
            newItem = new Armour(str[1], cost, min, max, str[5] ); // + material
        }
        else if( symbol.equals( "W" ) ) // Weapon
        {
            newItem = new Weapon(str[1], cost, min, max, str[5], str[6] ); // + weapon and damage type
        }
        else if( symbol.equals( "P" ) ) // Potion
        {
            if(str[5].equals("H")) // HealingP
            {
                newItem = new HealingPotion( str[1], min, max, cost );
            }
            else if( str[5].equals( "D" ) ) // DamageP
            {
                newItem = new DamagePotion( str[1], min, max, cost );
            }  
        }
        return newItem;      
    }  
}