// main class
package controller;

import model.characters.Player;
import model.characters.Character;
import model.Shop;
import controller.MenuController;
import view.LoadShop;
import view.FileReader;
import controller.*;
import model.items.Item;;

public class CombatGame 
{
    public static void main(String[] args)
    {
        try
        {
            Shop shop = new Shop();
            ShopController.initialiseShop(shop); // adds enchantments to shop

            EnemyFactory enemyFac = new EnemyFactory();
            Player player = enemyFac.createNewCharacter();

            LoadShop loader = new FileReader();
            loader.loadShopData(shop); // read in shop data from file

            equipCheapestWeapon(player,shop); // set cheapest weapon
            equipCheapestArmour(player,shop); // set cheapest armour

            MenuController.mainMenu(player,shop,enemyFac);
        }
        catch(ShopException s)
        {
            System.out.println("Error: " + s.getMessage());
        }    
    }

    private static void equipCheapestWeapon(Player player, Shop shop)
    {
        Item curWeapon  = shop.getCheapestItem("W"); // gets cheapest weapon from shop
        player.setCurWeapon(curWeapon); // sets cheapest weapon as current weapon
        curWeapon.setEquipped(true);
        player.addToInventory("W",curWeapon);
    }

    private static void equipCheapestArmour(Player player, Shop shop)
    {
        Item curArmour = shop.getCheapestItem("A"); // get cheapest armour in shop
        player.setCurArmour(curArmour); // equip cheapest armour
        curArmour.setEquipped(true); 
        player.addToInventory("A",curArmour); // add this armour to inventory
    }

}