// FILE: BattleMenu
// AUTHOR: Elijah Combes
// PURPOSE: contains the menu displayed to the user when a battle has been started
package view;

public class BattleMenu 
{
    // NAME: printEncounter
    // IMPORTS: name1, name2
    // PURPOSE: displays the two characters involved in a battle and the start of a battle
    public static void printEncounter(String name1, String name2)
    {
        System.out.println("\n-------------------- BATTLE --------------------");
        System.out.println(name1 + " ecountered a wild " + name2);
    }

    // NAME: printBattleMenu
    // PURPOSE: displays the main battle menu to the user
    public static void printBattleMenu() 
    {
        System.out.println("Please choose an option: ");
        System.out.println("1. Attack");
        System.out.println("2. Use Potion");
    }

    // NAME: printPotionMenu
    // IMPORTS: name
    // PURPOSE: displays the menu once the user has chosen to use a potion
    public static void printPotionMenu(String name)
    {
        System.out.println("0. Go back");
        System.out.println("Please type the Index of the potion you wish to use: ");
        System.out.println("-------------------- " + name + "'s Potions --------------------");
    }

    // NAME: printTurn
    // IMPORTS: data that must be displayed after a turn
    // PURPOSE: displays the events and data of one turn in a battle
    public static void printTurn(String name1, String name2, int damage, int defence, int total, int health)
    {
        System.out.println(name1 + " attacked " + name2);
        System.out.println(name1 + "'s Damage: " + damage );
        System.out.println(name2 + "'s Defence: " + defence );
        System.out.println("Damage Inflicted: " + total);
        System.out.println(name2 + "'s Health: " + health + "\n");
    }

    // NAME: showAttributes
    // IMPORTS: characters attributes in string form
    // PURPOSE: displays the characters attributes 
    public static void showAttributes(String attr)
    {
        System.out.println("\n-------------------- Attributes --------------------");
        System.out.println(attr+"\n");
    }

    // NAME: battleLost
    // IMPORTS: name
    // PURPOSE: displays who the user lost to
    public static void battleLost(String name)
    {
        System.out.println("-------------------- Game Over --------------------");
        System.out.println("You have been defeated by " + name );
    }

    // NAME: battleWon
    // IMPORTS: anme1, name2, goldEarned, health
    // PURPOSE: displays data about who won battle and benefits for the winner
    public static void battleWon(String name1, String name2, int goldEarned, int health)
    {
        System.out.println("-------------------- YOU WON! --------------------");
        System.out.println(name1 + " has defeated " + name2 );
        System.out.println("You earn "+ goldEarned + " gold for winning.");
        System.out.println("Health increased to: "+ health );
    }

    // NAME: gameOver
    // IMPORTS: none
    // PURPOSE: displays end game to user, when user wins the game/ defeats dragon
    public static void gameOver()
    {
        System.out.println("-------------------- Game Over --------------------");
        System.out.println("Congratulations you have defeated the Dragon!");
    }
}
