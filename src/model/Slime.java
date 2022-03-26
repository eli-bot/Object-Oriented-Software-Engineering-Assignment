// FILE: Slime.java
// AUTHOR: Elijah Combes
// PURPOSE: Type of enemy, defines a special ability where there is a 20% chance that no attack damage will occur
//          Defines fields of a Slime Character
package model.characters;

import java.util.*;

public class Slime extends Enemy
{
    // instantiate slime with name, maxHealth,curHealth,gold, min+max attack, min+max Defence
    // since these values do not change (not including curhealth) just pass them straight to Enemy()
    // NAME: Slime
    // PURPOSE: default constructor
    //          instantiate slime with name, maxHealth,curHealth,gold, min+max attack, min+max Defence
    //          since these values are pre defined (not including curhealth) just pass them straight to Enemy()
    // IMPORTS: none
    // EXPORTS: Slime object
    public Slime()
    {
        super("Slime",10,10,10,3,5,0,2);
    }

    // 20% chance that will do no damage
    // NAME: calcDamage
    // PURPOSE: adds Slime's special ability to its damage
    //          20% chance that it does no damage
    // IMPORTS: damage (int)
    // EXPORTS: damage
    @Override
    public int calcDamage(int damage)
    {
        Random r = new Random();

        if( r.nextInt(5) == 0 )
        {
            damage = damage * 0;
            System.out.println("Slime missed its' attack due to special ability");
        }
        return damage;
    }
}