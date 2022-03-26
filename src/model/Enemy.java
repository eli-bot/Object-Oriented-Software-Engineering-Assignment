// FILE: Enemy.java
// AUTHOR: Elijah Combes
// PURPOSE: abstract class for Enemy Objects. Contains common fields and methods for 
//          enemy subclasses
package model.characters;

public abstract class Enemy extends Character {

    protected final int minAttack; // minimum possible attack damage
    protected final int maxAttack; // maximum possible attack damage
    protected final int minDefence; // minimum possible defence
    protected final int maxDefence; // maximum possible defence 

    // NAME: Enemy
    // PURPOSE: constructor for enemy object
    // IMPORTS: all fields
    // EXPORTS: Enemy object
    public Enemy(String inName, int inMax, int inCur, int inGold, int inMinAttack, int inMaxAttack, int inMinDefence, int inMaxDefence )
    {
        super(inName,inMax,inCur,inGold);
        minAttack = inMinAttack;
        maxAttack = inMaxAttack;
        minDefence = inMinDefence;
        maxDefence = inMaxDefence;
    }

    // ACCESSORS
    @Override
    public int getMinAttack()
    {
        return minAttack;
    }

    @Override
    public int getMaxAttack()
    {
        return maxAttack;
    }

    @Override
    public int getMinDefence()
    {
        return minDefence;
    }

    @Override
    public int getMaxDefence()
    {
        return maxDefence;
    }
}    