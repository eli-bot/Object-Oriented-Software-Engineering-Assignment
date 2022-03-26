// FILE: BattleController.java
// AUTHOR: Elijah Combes
// PURPOSE: contains the brains for executing a battle in the game, passses data from the model to the view/menus
//          methods for: starting battle, using potion, attacking, winning battle
package controller;

import model.characters.*;
import controller.PlayerException;
import model.characters.Character;
import model.items.*;
import model.characters.Player;
import view.BattleMenu;
import view.*;
import controller.*;
import java.util.*;

public class BattleController 
{
    // NAME: runBattle
    // IMPORTS: Player, Character
    // EXPORTS: none
    // PURPOSE: begins a battle and guides battle based on user choices and in game events, controls battle
    public static void runBattle(Player char1, Character char2)
    {
        int choice = 0;
        boolean finished = false;
        BattleMenu.printEncounter(char1.getName(), char2.getName()); // displays start of battle
        while(!finished) // finished when a character in the battle is dead
        {
            try
            {
                while(char1.isAlive( ) && char2.isAlive( ) )
                {
                    BattleMenu.showAttributes(char1.toString()); // show players attributes
                    BattleMenu.printBattleMenu(); // display battle menu to user
                    choice = Menu.getIntInput(""); // get users choice
                switch(choice)
                {
                    case 1:
                        attack(char1,char2); // char1's turn/ Players turn
                        if(char2.isAlive()) // if enemy is alive
                        {
                            attack(char2,char1); // enemy's turn to attack
                        }
                        break;
                    case 2:
                        potion(char1,char2);  // use a potion
                        break;
                    default:
                        System.out.println("Please choose a valid option.");
                        break;      
                }
                }
                if(char1.isAlive()) // player wins battle
                {
                    battleWon(char1,char2);
                    finished = true;
                }
                else // player loses battle = game over
                {
                    BattleMenu.battleLost(char2.getName());
                    finished = true;
                    System.exit(0); // game ends
                }
            }    
            catch(MenuException a) // error handling, print error and return to menu
            {
                System.out.println("Error: " + a.getMessage() ); 
            }
            catch(PlayerException p)
            {
                System.out.println("Error: " + p.getMessage() );
            }
        }    
    }

    // NAME: potion
    // IMPORTS: Player, Character
    // EXPORTS: none
    // PURPOSE: controls the events that take place when a user decides to use a potion
    private static void potion(Player char1,Character char2) throws PlayerException, MenuException
    {
        try
        {
            BattleMenu.printPotionMenu(char1.getName()); // display potion menu
            char1.displayItems("P"); // display the players potions in inventory
            int index = Menu.getIntInput(""); // get potion that user selects
            Item potion = char1.removeItem("P", (char1.getItemAt("P", index-1)).getName());
            //Item potion = char1.removeItem("P",potionName); // remove potion from inventory
            Item weapon = usePotion(char1,char2,potion); // use potion
            char1.setCurWeapon(weapon); // equip weapon again after potion is used as line above equips potion
        }
        catch(ItemNotFoundException a)
        {
            throw new PlayerException(a.getMessage(),a);
        }    
        catch(MenuException m)
        {
            throw m;
        }
    }

    // NAME: usePotion
    // IMPORTS: Player, Character, Item - potion to use
    // EXPORTS: Item - players current wepaon before potion is used
    // PURPOSE: uses a potion in battle, determines whether potion is healing or damaging
    private static Item usePotion(Player char1,Character char2, Item p)
    {
        Item temp = char1.getWeapon(); 
        if(p != null)
        {
            int effect = p.getDamage(rand(p.getMinEffect(), p.getMaxEffect())); // get effect of potion
            if(effect < 0) // potion is a healing potion
            {
                char1.setCurHealth(Math.min(char1.getMaxHealth(), char1.getCurHealth() + Math.abs(effect)) );
                System.out.println(char1.getName() + " used a healing potion and healed " 
                                  + Math.abs(effect) + " health points."); // should probably be curHealth - prevHealth                 
            }
            else // potion is damaging
            {
                char1.setCurWeapon(p); // equips potion as current weapon
                attack(char1,char2); // uses potion
            }
        }
        return temp;
    }

    // NAME: battleWon
    // IMPORTS: Character x2
    // EXPORTS: none
    // PURPOSE: controls events that occur when a player wins a battle
    private static void battleWon(Character char1, Character char2)
    {
        char1.setCurHealth((int)Math.min(char1.getMaxHealth(),char1.getCurHealth() * 1.5)); // increase health
        char1.setGold(char1.getGold() + char2.getGold() ); // add gold earned
        BattleMenu.battleWon(char1.getName(), char2.getName(), char2.getGold(), char1.getCurHealth()); // display this info
       
        if(char2.getName().equals("Dragon")) // you win game over
        {
            BattleMenu.gameOver(); // dsiplay end game 
            System.exit(0); // exit game
        }
    }

    // NAME: attack
    // IMPORTS: Character x2
    // EXPORTS: none
    // PURPOSE: controls events that occur when attacking in a battle
    //          char1 attacks char2
    private static void attack(Character char1, Character char2)
    {
        System.out.println("\n-------------------- "+char1.getName()+"'s Turn --------------------");
        int damage = char1.calcDamage( rand(char1.getMinAttack(), char1.getMaxAttack()));  // calculate damage random # between min and max
        int defence = rand( char2.getMinDefence(), char2.getMaxDefence() ); // calculate defence 
        int total = Math.max(0, damage - defence ); // total damage 
        
        int newHealth = Math.max(0, char2.getCurHealth() - total); // update char2 health
        char2.setCurHealth( newHealth );

        BattleMenu.printTurn(char1.getName(), char2.getName(), damage, defence, total, newHealth ); // display events of this attack turn
    }

    // return random number between the two imported numbers inclusive 
    public static int rand(int min, int max)
    {
        int num;
        Random random = new Random();
       
        num = random.nextInt( ( max - min ) + 1 ) + min;
        return num;
    }
}