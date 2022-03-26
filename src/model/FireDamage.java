// FILE: FireDamage.java
// AUTHOR: Elijah Combes
// PURPOSE: contains FireDamage enchantment and the effect it has on a weapon/items damage
package model.enchantments;

import model.items.*;
import java.util.*;
import java.lang.Math;

public class FireDamage extends Enchantment
{
    // NAME: FireDamage
    // PURPOSE: default constructor 
    // IMPORTS: none
    // EXPORTS: FireDamage object
    public FireDamage()
    {
        super();
        effect = "Adds between 5-10 (randomly) to attack damage";
        name = "Fire Damage";
        cost = 20;
    }
    
    // NAME: FireDamage
    // PURPOSE: alternate constructor, adds this enchantment to the list of items
    // IMPORTS: next (Item) - next item in the list
    // EXPORTS: FureDamage Object
    public FireDamage(Item next)
    {
        super(next);
        effect = "Adds between 5-10 (randomly) to attack damage";
        name = "Fire Damage";
        cost = 20;
    }

    // NAME: getDamage
    // PURPOSE: adds the damage of this enchantment to the next object in the list's damage
    //          part of decorator pattern
    // IMPORTS: damage (int)
    // EXPORTS: damage
    public int getDamage(int damage)
    {
        Random r = new Random();
        return next.getDamage(damage + r.nextInt(10-5) + 5 ) ; // adds random number between 5 and 10 to damage
    }
}
