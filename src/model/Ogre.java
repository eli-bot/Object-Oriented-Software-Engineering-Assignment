// FILE: Ogre.java
// AUTHOR: Elijah Combes
// PURPOSE: contains specifcations for ogre enemy type and calcDamage to calc ogre's damage and speicial ability
package model.characters;

import java.util.*;

public class Ogre extends Enemy 
{
    // NAME: Ogre
    // PURPOSE: default constructor 
    // IMPORTS: none 
    // EXPORTS: Ogre object
    public Ogre()
    {
        super("Ogre", 40, 40, 40, 5, 10, 6, 12);
    }
   
    // NAME: calcDamage
    // PURPOSE: overrides superclass method, 20% chance of attacking twice
    // IMPORTS: damage(int)
    // EXPORTS: damage
    @Override
    public int calcDamage(int damage)
    {
        Random r = new Random();
        int damage2;

        if( r.nextInt(5) == 0 ) // 1/5 chance
        {
            //attack twice
            damage2 = r.nextInt( ( maxAttack - minAttack ) + 1 ) + minAttack;
            System.out.println("Ogre attacks twice due to special ability");
            System.out.println("First attack: "+ damage);
            System.out.println("Second attack: " + damage2);
            damage = damage + damage2;
        }
        return damage; // returns total damage
    }
}