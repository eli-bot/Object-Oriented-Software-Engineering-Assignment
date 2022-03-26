// FILE: HealingPotion.java
// AUTHOR: Elijah Combes
// PURPOSE: Class to define a Potion object that heals the user
package model.items;

import model.items.Potion;

public class HealingPotion extends Potion
{
    // NAME: HealingPotion
    // PURPOSE: Constructor for HealingPotion object
    // IMPORTS: HP fields
    // EXPORTS: this object 
    public HealingPotion(String inName, int inMin, int inMax, int inCost)
    {
        super(inName, inMin, inMax, inCost);
    }

    // returns damage as a negative value if its a healing potion
    // NAME: getDamage
    // PURPOSE: overrides superclass method
    // IMPORTS: damage(int)
    // EXPORTS: damage
    @Override
    public int getDamage(int damage)
    {
        return damage - ( 2 * damage ); // returns negative value so controller knows its a healing potion
    }
}