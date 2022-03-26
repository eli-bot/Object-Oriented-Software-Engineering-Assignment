// FILE: PowerUp.java
// AUTHOR: Elijah Combes
// PURPOSE: PowerUp enchantment muliplies attack damage by 1.1
//          part of decorator pattern decorates a weapon
package model.enchantments;

import model.items.*;

public class PowerUp extends Enchantment
{  
    // NAME: PowerUp
    // PURPOSE: default constructor
    // IMPORTS: none 
    // EXPORTS: PowerUp object
    public PowerUp()
    {
        super();
        effect = "Multiplies attack damage by 1.1";
        name = "Power Up";
        cost = 10;
    }
    
    // NAME: PowerUp
    // PURPOSE: creates PowerUp item and adds to list
    // IMPORTS: next(Item) - 
    // EXPORTS:
    public PowerUp(Item next)
    {
        super(next);
        effect = "Multiplies attack damage by 1.1";
        name = "Power Up";
        cost = 10;
    }

    // NAME: getDamage
    // PURPOSE: mulitplies the next item in the list's damage by 1.1 and returns
    // IMPORTS: damage (int)
    // EXPORTS: damage
    public int getDamage(int damage)
    {
        return next.getDamage((int)(((double)damage) * 1.1));
    }

    // adds this item to start of list of enchantments/weapon
    public void setNext(Item next)
    {
        this.next = next;
    }
}