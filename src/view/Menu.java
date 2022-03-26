// FILE: Menu.java
// AUTHOR: Elijah Combes
// PURPOSE: contains the main menu for the combatgame, contains methods for displaying this menu and some
//          sub menu's that didnt belong elsewhere. Also contains methods for userInput that many classes use.
package view;

import java.util.*;
import controller.MenuException;

public class Menu 
{
    // NAME: printMainMenu
    // PURPOSE: displays the main menu for the game to the user, where they can then select a choice
    public static void printMainMenu()
    {
        System.out.println("\n-------------------- Main Menu --------------------"); 
        System.out.println("Please choose an option: ");
        System.out.println("1. Go to Shop");
        System.out.println("2. Choose Character Name");
        System.out.println("3. Choose Weapon");
        System.out.println("4. Choose Armour");
        System.out.println("5. Start Battle");
        System.out.println("6. Exit Game\n");
    }
    
    // NAME: printWeaponMenu
    // IMPORTS: weapon ,name
    // PURPOSE: displays the choose wepaon menu to the user
    public static void printWeaponMenu(String weapon, String name)
    {
        System.out.println("To select a Weapon please type the index number that corresponds to the weapon: ");
        System.out.println("0. Return to menu\n");
        System.out.println("Current equipped weapon ---- " + weapon + "\n");
        System.out.println("-------------------- " + name + "'s Weapons --------------------");
    } 
    
    // NAME: printArmourMenu
    // IMPORTS: amrour, name
    // PURPOSE: displays the choose armour menu to the user
    public static void printArmourMenu(String armour, String name)
    {
        System.out.println("To select Armour please type the index number that corresponds to the Armour: ");
        System.out.println("0. Return to menu\n");
        System.out.println("Current equipped Armour ---- " + armour + "\n");
        System.out.println("-------------------- " + name + "'s Armour --------------------");
    }

    // NAME: getIntInput
    // IMPORTS: prompt
    // EXPORTS: int
    // PURPOSE: gets user input in the form a=of an integer and returns it
    public static int getIntInput(String prompt) throws MenuException // gets input as an integer from the user.
    {
        int choice = -1;
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(prompt);
            choice = sc.nextInt();
        }    
        catch(InputMismatchException a)
        {
            throw new MenuException("Input must be one of the integers above",a);
        }
        return choice;
    }

    // NAME: getTextInput
    // IMPORTS: prompt
    // EXPORTS: String
    // PURPOSE: gets user input in the form of a String
    public static String getTextInput(String prompt) throws MenuException// gets user input as string
    {
        String userInput;
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(prompt);
            userInput = sc.nextLine();
        }    
        catch(InputMismatchException a)
        {
            throw new MenuException("Input must be one of the integers above",a);
        }
        return userInput; 
    }
}