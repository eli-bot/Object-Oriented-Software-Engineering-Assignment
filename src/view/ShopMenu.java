// FILE: ShopMenu
// AUTHOR: Elijah Combes
// PURPOSE: contains methods necessary for displaying the Shop menu to the user
package view;

import model.characters.Player;
import model.Shop;

public class ShopMenu 
{
    // NAME: printShopMenu
    // PURPOSE: displays the main shop menu to the user
    public static void printShopMenu()
    {
        System.out.println("-------------------- SHOP --------------------");
        System.out.println("1. Purchase items ");
        System.out.println("2. Sell items");
        System.out.println("3. Back");
    }    

    // NAME: purchaseItemsMenu
    // IMPORTS: Shop
    // PURPOSE: displays the menu when purchasing an item to the user
    public static void purchaseItemsMenu(Shop shop)
    {
        System.out.println("-------------------- ITEMS --------------------");
        shop.displayShop(); // maybe should be in controller
        System.out.println("\nPlease type the name of the item you wish to purchase \n0. Back");
    }

    // NAME: sellItemsMenu
    // PURPOSE: displays the sell item menu to the user.
    public static void sellItemsMenu()
    {
        System.out.println( "\nPlease type the name of the item you wish to sell. ");
        System.out.println("For enchanted items please type the name of the left most enchantment.\n0. Back");
    }
}