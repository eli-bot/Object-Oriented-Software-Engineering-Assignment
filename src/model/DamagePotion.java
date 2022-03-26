// FILE: DamagePotion.java
// AUTHOR: Elijah Combes
// PURPOSE: Class that defines a potion that does a fixed amount of damage
//          used for future extensibility and to seperate healing potions from damage ones
package model.items;

import model.items.Potion;

public class DamagePotion extends Potion
{
    // NAME: DamagePotion
    // PURPOSE: COnstructor for damge potion item
    // IMPORTS: fields for damage potion
    // EXPORTS: DamagePotion object
    public DamagePotion(String inName, int inMin, int inMax, int inCost)
    {
        super(inName, inMin, inMax, inCost);
    }

    // NAME: getDamage
    // PURPOSE: overrides abstract method in superclass
    // IMPORTS: damage
    // EXPORTS: damage
    @Override
    public int getDamage(int damage)
    {
        return damage;
    }
}