// FILE: EnemyFactory.java
// AUTHOR: Elijah Combes
// PURPOSE: factory for Enemy objects, decouples calling classes from these Enemy subclasses
//          creates a new enemy or player based on the imported String, and the probability values       
package controller;

import model.characters.*;
import model.characters.Character;

import java.util.*;
import java.lang.Math.*;

public class EnemyFactory 
{
    private double slime; // probabilities for creating each type of enemy
    private double goblin; 
    private double ogre;
    private double dragon;
    
    // NAME: EnemyFactory
    // PURPOSE: default constructor, initialises all probabilities to their pre defined values
    // IMPORTS: none
    // EXPORTS: EnemyFactory Object
    public EnemyFactory()
    {
        slime = 0.5; // ie 0 -> 0.5 ... 50% chance
        goblin = 0.8; // 0.5 -> 0.8 ... 30% chance
        ogre = 1.0;   // 20% chance
        dragon = 0.0; // 0% chance at first...
    }

    // NAME: createNewCharacter
    // PURPOSE: creates Player Object, used to decouple any class that might need a Player object as an Item
    //          removes hard coded dependancy 
    // IMPORTS: none
    // EXPORTS: Player
    public Player createNewCharacter()
    {
        return new Player();
    }

    // NAME: createEnemy
    // PURPOSE: factory for creating enemies, creates a random new enemy based on their probabilities
    //          each non-dragon decreases by 5% after each call, dragon increases by 15%
    // IMPORTS: none
    // EXPORTS: Character
    public Character createEnemy()
    {
        Random r = new Random();
        double prob = r.nextDouble(); // random double between 0 and 1.0
        Character newCharacter = null;
        
        if(0 < prob && prob <= slime) // if the value is greater than zero but less tahn or equal to the slime prob
        {                             // then make a slime  
            newCharacter = new Slime();
        }
        else if(slime < prob && prob <= goblin )
        {
            newCharacter = new Goblin();
        }
        else if(goblin < prob && prob <= ogre)
        {
            newCharacter = new Ogre();
        }
        else if( ogre < prob && prob <= 1)
        {
            newCharacter = new Dragon();
        }
        updateProb(); // update the probabilities
        return newCharacter;
    }

    // NAME: updateProb
    // PURPOSE: updates probabilities after a battle, ensures they are between 0-100%
    // IMPORTS: none
    // EXPORTS: none
    private void updateProb()
    {
        slime = Math.max(0.05, slime - 0.05 ); // all non-dragons are reduced by 5%
        goblin = Math.max(0.05, goblin - 0.05 );
        ogre = Math.max(0.05, ogre - 0.05 );
        dragon = Math.min(0.85, dragon + 0.15 ); // dragon reduced by the number of non dragon enemies * 5
                                                // in this case 15%
    }
}