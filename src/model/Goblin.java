
// FILE: Goblin.java
// AUTHOR: Elijah Combes
// PURPOSE: defines a Goblin enemy type which adds a goblins special ability to
//          strategy pattern method calcDamage()
package model.characters;

import java.util.*;
import model.characters.*;

public class Goblin extends Enemy
{
    // NAME: Goblin
    // PURPOSE: default constructor
    // IMPORTS: none
    // EXPORTS: Goblin object
    public Goblin()
    {
        super("Goblin", 30 , 30, 20, 3, 8, 4, 8);
    }
    
    // NAME: calcDamage
    // PURPOSE: overrides method in superclass, has 50% chance to add 3 to the damage
    // IMPORTS: damage (int)
    // EXPORTS: damage
    @Override
    public int calcDamage(int damage)
    {
        Random r = new Random();

        if( r.nextInt(2) == 0 ) // 1/2 chance of event occuring
        {
            damage = damage + 3; // add 3 to total damage
            System.out.println("Goblin's special ability deals 3 extra damage points");
        }
        return damage;
    }
}