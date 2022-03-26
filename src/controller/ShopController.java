package controller;

import view.*;
import controller.*;
import model.items.Item;
import model.characters.*;
import model.enchantments.*;
import model.Shop;

public class ShopController
{
    public static void runShop(Player player, Shop shop)
    {
        int choice = 0;
        String choice2 = "";
        while(choice != 3)
        {
            try
            {
                ShopMenu.printShopMenu();
                choice = Menu.getIntInput("");
                switch(choice)
                {
                    case 1: // buy items
                        ShopMenu.purchaseItemsMenu(shop); 
                        choice2 = Menu.getTextInput("");
                        if(!choice2.equals("0"))
                        {
                            purchaseItem(player,shop,choice2);
                        }
                        break;
                    case 2: // sell items
                        player.displayAllItems(player);
                        ShopMenu.sellItemsMenu();
                        choice2 = Menu.getTextInput("");
                        if(!choice2.equals("0"))
                        {
                            sellItem(player,shop,choice2);
                        }
                        break;
                    default:
                        System.out.println("Returning to menu...");
                        break;
                }    
            }
            catch(MenuException a)
            {
                System.out.println("Error: " + a.getMessage() );      
            }
            catch(ShopException o)
            {
                System.out.println("Error: " + o.getMessage() );   
            }
        }
    }    

    private static void purchaseItem(Player player, Shop shop, String itemName) throws ShopException
    {
        Item newItem;
        try
        {
            String key = shop.getListKey(itemName, shop.getShopItems());
            if( key == "")
            {
                System.out.println("Error: "+itemName+ " does not exist") ;   
            }
            else
            {
                int index = shop.getItemIndex( key, itemName );
                newItem = shop.getItemAt( key, index );
                if(newItem.getCost() <= player.getGold() )
                {
                    if( key.equals( "E" ) )
                    {
                        purchaseEnchantment(newItem,player); // add enchantment to curWeapon
                    }
                    else
                    {
                        player.addToInventory(key, newItem); // add item to inventory  
                    }
                    System.out.println(itemName + " has been added to inventory.");
                    player.setGold( player.getGold( ) - newItem.getCost( ) ); // pay up
                }
                else
                {
                    System.out.println("Sorry, you do not have enough gold for that item.");
                }    
            } 
        }
        catch(ItemNotFoundException a)
        {
            throw new ShopException("Item not found in inventory",a);
        }      
    }

    private static void purchaseEnchantment(Item enchantment, Player player) throws ItemNotFoundException
    {
        try
        {
            enchantment.setNext(player.getWeapon()); // add enchantment to weapon/decorator pattern
            player.removeItem("W",player.getWeapon().getName()); // remove weapon from inv and add (enchantment + weapon)
            player.addToInventory("E",enchantment); // weapon = enchantment now represented as one item
            player.setCurWeapon(enchantment); // update curWeapon
        }
        catch(ItemNotFoundException a)
        {
            throw a;
        }    
    }

    private static void sellItem(Player player, Shop shop, String itemName) throws ShopException
    {
        Item itemToSell;
        int index;
        try
        {
            String key = shop.getListKey( itemName, player.getPlayerItems( ) ); // gets key for hashmap of player items
            index = player.getItemIndex( key, itemName ); // get index for list of this type of item
            itemToSell = player.getItemAt( key, index ); // gets the item from that list
        
            if(itemToSell.getEquipped() ) // check if item is equipped
            {                             // maybe throw exception instead?  
                System.out.println("You cannot sell equipped items");
            }
            else
            {
                player.removeItem( key, itemName ); // remove item from inventory
                player.setGold( player.getGold() + itemToSell.getCost()/2 ); // items sells for 50% of cost
                System.out.println(itemName + " has been sold, you receive +" + itemToSell.getCost()/2 );
                System.out.println("Total Gold: "+ player.getGold() );
            }
        }
        catch(ItemNotFoundException a)
        {
            throw new ShopException(a.getMessage(),a);
        }
    }

    public static void initialiseShop(Shop shop)
    {
        shop.addItem("E", new DamagePlusTwo());
        shop.addItem("E", new DamagePlusFive());
        shop.addItem("E", new FireDamage());
        shop.addItem("E", new PowerUp());
    }
}