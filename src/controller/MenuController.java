package controller;

import java.util.*;
import view.*;
import model.characters.*;
import controller.*;
import model.items.Item;
import model.Shop;

public class MenuController 
{
    public static void mainMenu(Player player, Shop shop, EnemyFactory enemyFac)
    {
        int choice = -1;
        int choice2;
        while( choice != 6)
        {
            try 
            {
                Menu.printMainMenu();  
                choice = Menu.getIntInput("");       
                switch(choice)
                {
                    case 1: // Go to Shop
                         ShopController.runShop(player, shop);
                         break;
                    case 2: // update character name
                        String name = Menu.getTextInput("Please enter the new name: ");
                        player.setName(name);
                        System.out.println("Player name updated to '"+ player.getName() + "'");
                        break;   
                    case 3: // choose weapon
                        Menu.printWeaponMenu(player.getWeapon().toString(),player.getName()); //show menu
                        player.displayItems("W"); // displays weapons to user
                        choice2 = Menu.getIntInput("");
                        chooseWeapon(player,choice2);
                        break;
                    case 4:    
                        Menu.printArmourMenu(player.getArmour().toString(),player.getName());
                        player.displayItems("A");
                        choice2 = Menu.getIntInput("");
                        chooseArmour(player,choice2);
                        break;
                    case 5:   
                        BattleController.runBattle(player,enemyFac.createEnemy()); 
                        break;
                    case 6:
                        choice = 6;
                        System.exit(0);
                        break;
                    default:
                        break;
                }           
            } 
            catch (MenuException m) 
            {
                System.out.println("Error: " + m.getMessage());
            }
            catch(PlayerException p)
            {
                System.out.println("Error: " + p.getMessage());
            }
        }    
    }

        private static void chooseWeapon(Player player, int index) throws PlayerException
        {
            try
            {
                Item item = player.getItemAt("W",index - 1); // gets weapon that they chose
                player.getWeapon().setEquipped(false); // unequip current weapon
                player.setCurWeapon(item); // equip new weapon
                item.setEquipped(true); 
                System.out.println(item.getName() + " has been equipped.");
            }
            catch(ItemNotFoundException a)
            {
                throw new PlayerException(a.getMessage(),a);
            }    
        }

        private static void chooseArmour(Player player, int index) throws PlayerException
        {
            try
            {
                player.getArmour().setEquipped(false); // unequip current armour
                Item item = player.getItemAt("A",index - 1); // get chosen armour
                player.setCurArmour(item); // equip new armour
                item.setEquipped(true);
                System.out.println(item.getName() + " has been equipped.");
            }
            catch(ItemNotFoundException a)
            {
                throw new PlayerException(a.getMessage(),a);
            }
        }
    
}