// FILE: Dragon.java
// AUTHOR: Elijah Combes
// PURPOSE: Class that defines a type of enemy, Dragon.
//          used as part of strategy pattern, one of the "strategies" for attacking
package model.characters;

import java.util.*;

public class Dragon extends Enemy
{
    // NAME: Dragon
    // PURPOSE: default constructor for Dragon object
    // IMPORTS: none
    // EXPORTS: Dragon object
    public Dragon()
    {
        super("Dragon", 100, 100, 100, 15, 30, 15, 20);
    }

    // NAME: calcDamage
    // PURPOSE: Overrides method in superclass, adds implementation relevant for this object
    //          25% chance damage will be mulitplied by 2
    //          10% chance to heal 10hp
    // strategy pattern method, defines Dragon strategy/ special ability
    // IMPORTS: damage(int)
    // EXPORTS: damage 
    @Override
    public int calcDamage(int damage)
    {
        Random r = new Random();

        if( r.nextInt(4) == 0) // 1/4 chance
        {
            damage = damage * 2;
            System.out.println("Dragon's Special ability mulitplies damage by 2");
        }
        else if( r.nextInt(10) == 0) // 1/10 chance
        {
            this.setCurHealth(  Math.min( 100, this.getCurHealth() + 10 ) ); // heal 10hp
            System.out.println("Dragon's special ability heals 10 health points");
        }
        return damage;
    }
}