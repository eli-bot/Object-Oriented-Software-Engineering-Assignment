// FILE: DamagePlusFive.java
// AUTHOR: Elijah Combes
// PURPOSE: Enchantment object used to decorate items
package model.enchantments;

import model.enchantments.Enchantment;
import model.items.*;

public class DamagePlusFive extends Enchantment
{
    // NAME: Default constructor for Damage+5 enchantment
    // PURPOSE: creates and initialises damage+5 object with pre defined fields
    // IMPORTS: 
    // EXPORTS: Damage+5 object
    public DamagePlusFive()
    {
        super();
        effect = "Adds 5 to attack damage";
        name = "Damage +5";
        cost = 10;
    }
    
    // NAME: DamagePlusFive
    // PURPOSE: Alternate constructor for Damage+5 object, part of decorator pattern
    //          allows this object to contain the next object in the list
    //          (ie the next enchantment or the base weapon)
    // IMPORTS: (next)Item
    // EXPORTS: Damage+5 object
    public DamagePlusFive(Item next)
    {
        super(next);
        effect = "Adds 5 to attack damage";
        name = "Damage +5";
        cost = 10;
    }
    
    // NAME: getDamage
    // PURPOSE: part of decorator pattern, calls next item in list which returns its' damage
    //          and adds five to that.
    // IMPORTS: damage(int)
    // EXPORTS: int
    public int getDamage(int damage)
    {
        return next.getDamage(damage + 5);
    }
}