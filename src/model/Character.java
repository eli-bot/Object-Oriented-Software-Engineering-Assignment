// FILE: Character.java
// AUTHOR: Elijah Combes
// PURPOSE: abstract class for Character objects
// COMMENTS: contains common methods and fields to subclasses and abstract methods for these classes
// REFERENCES: 
// Last Mod: 27/04/2020

package model.characters;

import java.util.*;

public abstract class Character
{
    protected String name; // name of Character
    protected int maxHealth; // maximum health
    protected int curHealth; //current health
    protected int gold; // in game currency

    // abstract methods
    // getters that each character must have min + max defence/attack
    public abstract int getMinAttack(); // abstract as Player uses different algorithm to obtain these values than-
    public abstract int getMaxAttack(); // -Enemy classes
    public abstract int getMinDefence();
    public abstract int getMaxDefence();
    // abstract method that determines the damage that a character will inflict on an enemy
    public abstract int calcDamage(int damage);
    
    // Default constructor for a character
    public Character()
    {
        name = "Bob"; // default name
        maxHealth = 30; // default health 30
        curHealth = 30; // health starts at max
        gold = 100; // default gold 10
    }
    
    // create instance of character with imported fields 
    // NAME: Character
    // PURPOSE: Alternate constructor for creating a character object
    // IMPORTS: inName(String), inMax,(int) inCur(int), inGold(int)
    // EXPORTS: none/Character object
    public Character(String inName, int inMax, int inCur, int inGold)
    {
        name = inName;
        maxHealth = inMax;
        curHealth = inCur;
        gold = inGold;
    }

    // Accessors for Character fields
    public String getName()
    {
        return name;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public int getCurHealth()
    {
        return curHealth;
    }

    public int getGold()
    {
        return gold;
    }

    // MUTATORS
    public void setGold(int newGold)
    {
        gold = newGold;
    }
    
    public void setCurHealth(int newHealth)
    {
        curHealth = newHealth;

    } 

    // NAME: isAlive() 
    // PURPOSE: determines whether character is alive or not
    //          returns true if alive, false otherwise        
    // IMPORTS: none
    // EXPORTS: boolean
    public boolean isAlive()
    {
        boolean alive = true;
        if( curHealth <= 0 )
        {
            alive = false;
        }
        return alive;
    }

    // NAME: toString
    // PURPOSE: converts Character data into a string format
    // IMPORTS: none
    // EXPORTS: String representation of character
    public String toString()
    {
        return ("Name: " + name + ", Max Health: " + maxHealth + ", Current Health: " + curHealth + ", Gold: "+gold);
    }
}