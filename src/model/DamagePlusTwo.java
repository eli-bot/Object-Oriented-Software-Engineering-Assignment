// FILE: DamagePlusTwo.java
// AUTHOR: Elijah Combes
// PURPOSE: Enchantment object used to decorate items, adds 2 to total attack damage
package model.enchantments;

import model.items.*;

public class DamagePlusTwo extends Enchantment
{  
    // NAME: DamagePlusTwo
    // PURPOSE: Default constructor for Damage+2 enchantment
    // IMPORTS: none
    // EXPORTS: DamagePlusTwo object
    public DamagePlusTwo()
    {
        super();
        effect = "Adds 2 to attack damage";
        name = "Damage +2";
        cost = 5;
    }
   
    // NAME: DamagePlusTwo
    // PURPOSE: alternate constructor for damage+2 object that allows it to be added to the start of a list of Items
    // IMPORTS: next(Item) - pointer to the next item in the list
    // EXPORTS: Damage+2 object
    public DamagePlusTwo( Item next )
    {
        
        super(next);
        effect = "Adds 2 to attack damage";
        name = "Damage +2";
        cost = 5;
    }

    // NAME: getDamage
    // PURPOSE: adds 2 to the total damage of a weapon, if this enchantment is equipped
    // IMPORTS: damage(int)
    // EXPORTS: damage
    public int getDamage(int damage)
    {
        return next.getDamage(damage + 2);
    }
}