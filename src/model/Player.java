// FILE: Player.java
// AUTHOR: Elijah Combes
// PURPOSE: Defines a Player, contains methods for adding,removing items from players inventory
//          also for obtaining the inventory and mutators and accessors for fields.
package model.characters;

import java.util.*;
import controller.ItemNotFoundException;
import model.items.*;

public class Player extends Character
{
    private Item curWeapon; // player's current equipped weapon
    private Item curArmour; // players current equipped armour
    private HashMap<String,ArrayList<Item>> inventory; // players inventory, hashmap of lists where each list is a different type of item.
    private int itemCount; // number of items currently in inventory

    public Player() // default constructor
    {
        super();
        inventory = new HashMap<String,ArrayList<Item>>();
        itemCount = 0;
    }
    
    public Player(String inName, int inGold, int inMax, int inCur, Item inWeapon, Item inArmour) // alternate constructor
    {
        super(inName,inMax,inCur,inGold);
        curWeapon = inWeapon;
        curArmour = inArmour;
    
        inventory = new HashMap<String,ArrayList<Item>>(); 
        itemCount = 0;
        
   //     (inventory.get("W")).add(curWeapon); // get List of weapons and add a new weapon to it
    //    (inventory.get("A")).add(curArmour); // needed as 
     //   inventory.get("P");
    }
    // NAME: calcDamage
    // IMPORTS: damage(int)
    // EXPORTS: damage(int)
    // PURPOSE: returns this player's attack damage which is based on the players current weapon, enchantments are added elsewhere
    public int calcDamage(int damage)
    {
        return curWeapon.getDamage( damage);
    }

    // NAME: rand
    // IMPORTS: min, max
    // EXPORTS: random integer between min and max
    // PURPOSE: get random number between two imported numbers
   /* public static int rand(int min, int max)
    {
       int num;
       Random random = new Random();
       num = random.nextInt( ( max - min ) + 1 ) + min;
       return num;
    }*/
    // ACCESSORS
    public Item getWeapon()
    {
        return curWeapon;
    }

    public Item getArmour()
    {
        return curArmour;
    }

    @Override
    public int getMinAttack()
    {
        return curWeapon.getMinEffect();
    }

    @Override
    public int getMaxAttack()
    {
        return curWeapon.getMaxEffect();
    }

    @Override
    public int getMinDefence()
    {
        return curArmour.getMinEffect();
    }
   
    @Override
    public int getMaxDefence()
    {
        return curArmour.getMaxEffect();
    }
   

    public HashMap<String,ArrayList<Item>> getInventory()
    {
        return inventory;
    }

    // MUTATORS
    public void setName(String newName )
    {
        name = newName;
    }

    public void setCurWeapon( Item inWeapon )
    {
        curWeapon = inWeapon;
    }

    public void setCurArmour( Item inArmour )
    {
        curArmour = inArmour;
    }

    public void setGold(int newGold)
    {
        gold = newGold;
    }

    // NAME: removeItem
    // IMPORTS: key - key for hashmap( ie "A" for Armour), name - name of item 
    // EXPORTS: itemToRemove
    // PURPOSE: removes an item from players inventory based on imported key and name
    public Item removeItem( String key, String name ) throws ItemNotFoundException
    {
        ArrayList<Item> list;
        ArrayList<Item> itemsList = null;
        int index;
        Item itemToRemove = null;
        try
        {
            for(Map.Entry<String,ArrayList<Item>> entry:  inventory.entrySet()) 
            {
                index = 0;
                list = entry.getValue(); // get one list from hashmap
                for(Item item: list) // for each item in that list
                { 
                    if(name.equals(item.getName())) // if the name of that Item equals imported one
                    {
                        itemsList = list; 
                        itemToRemove = item; // item has been found, return this item
                    }
                    index++;
                }
            }
            if(itemToRemove != null) // if the item was actually found in a list
            {
                itemsList.remove(itemToRemove); // remove item
                itemCount--; // decrease item count
            }
            else
            {
                throw new ItemNotFoundException(name + " does not exist in your inventory");
            }
        }    
        catch(IndexOutOfBoundsException a)
        {
            throw new ItemNotFoundException(name + " does not exist in your inventory");
        }    
        return itemToRemove;
    }    

    // NAME: addToInventory
    // IMPORTS: key - key for hashmap, newItem - item to add to inventory
    // EXPORTS: none
    // PURPOSE: adds an item to inventory based on imported key for item
    public void addToInventory( String key, Item newItem )
    {
        // if ArrayList with imported key doesnt exist then create one
        if(itemCount < 15) 
        {
            if( !(inventory.containsKey(key)) )
            {
                inventory.put( key ,new ArrayList<Item>() ); // create list
            }
            inventory.get(key).add(newItem); // add item
            itemCount++; // increase item count
        }    
    }

    // NAME: inventoryIsFull
    // IMPORTS: none
    // EXPORTS: full - boolean true if full
    // PURPOSE: checks if inventory is full or not
    public boolean inventoryIsFull()
    {
        boolean full = true;
        if(itemCount < 15)
        {
            full = false;    
        }
        return full;
    }

    // NAME: getItems
    // IMPORTS: key
    // EXPORTS: list of items from inventory with key
    // PURPOSE: gets a list of items from the inventory hashmap based on imported key, ie "W" = list of weapons
    public ArrayList<Item> getItems(String key)
    {
       return inventory.get(key);
    }
    // accessor for entire inventory
    public HashMap<String,ArrayList<Item>> getPlayerItems()
    {
        return inventory;
    }

    // NAME: getItemAt
    // IMPORTS: key, index
    // EXPORTS: Item 
    // PURPOSE: gets the item from a list of items in the inventory at a particular imported index
    public Item getItemAt(String key, int index) throws ItemNotFoundException
    {
        Item item = null;
        try
        {
            ArrayList<Item> list = getItems(key); // get the list specified by key
        
            if( !(index >= list.size()) ) // if index is not out of bounds
            {
                item = list.get(index); // get item at index
            }    
            if(item == null)
            {
                throw new ItemNotFoundException("Item does not exist in " + name + "'s inventory");
            }
        }    
        catch(IndexOutOfBoundsException a)
        {
            throw new ItemNotFoundException("That index does not exist");
        }  
        return item;
    }

    // NAME: getItemIndex
    // IMPORTS: key, itemName
    // EXPORTS: itemIndex - the index of the item specified by imports
    // PURPOSE: obtains the index of an item in the inventory so it can be obtained or used elsewhere
    public int getItemIndex( String key, String itemName ) throws ItemNotFoundException
    {
        ArrayList<Item> itemsList = inventory.get( key ); // get list
        int index = 0; 
        int itemIndex = -1;
        for(Item item: itemsList) // for each item in the list
        {
            if( item.getName().equals( itemName ) )
            {
                itemIndex = index++; // item found, return this index
            }
            index++;
        }
        if(itemIndex == -1 )
        {
            throw new ItemNotFoundException("Item not in " + name +"'s' inventory");
        }
        return itemIndex;
    }

    // NAME: displayItems
    // IMPORTS: key
    // EXPORTS: none
    // PURPOSE: displays all items in players inventory given a specific type
    public void displayItems(String key) // maybe should return a String which the controller can pass to view?
    {
        ArrayList<Item> itemsToDisplay = inventory.get(key);
        
        if( itemsToDisplay != null ) 
        {
            int i = 1; // start at 1 for aesthetics rather than at 0
            for(Item item: itemsToDisplay)
            {
                System.out.println(" Index: " + i + " ---------- "+ item.toString()); // display items index plus items specification
                i++;
            }
        }    
    }

    // NAME: displayAllItems
    // IMPORTS: player
    // EXPORTS: none
    // PURPOSE: displays players entire inventory
    public void displayAllItems(Player player)
    {
        System.out.println("-------------------- " + name + "'s Inventory' --------------------");
        for(Map.Entry<String,ArrayList<Item>> entry:  inventory.entrySet())
        {
            displayItems(entry.getKey());
        }
    }

    // NAME: toString
    // IMPORTS: none
    // EXPORTS: String representation of Player
    // PURPOSE: adds Players extra specification to Character(superclass) toString method
    @Override
    public String toString()
    {
        String info =  (super.toString() + " Current Weapon: " + curWeapon.getName() + ", Current Armour: " + curArmour.getName());
        
        return info;
    }
}