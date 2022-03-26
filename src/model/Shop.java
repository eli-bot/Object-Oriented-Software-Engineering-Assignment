// FILE: Shop.java
// AUTHOR: Elijah Combes
// PURPOSE: contains state for a shop within the combatgame
//          stores lists of Items available in the shop
//          contains methods necessary for adding and removing items from shop and displaying shop
package model;

import java.util.*;
import model.items.Item;
import controller.ItemNotFoundException;

public class Shop 
{
    private HashMap<String,ArrayList<Item>> items; // HashMap containing Lists of different item types

    public Shop() // default constructor
    {
        items = new HashMap<String,ArrayList<Item>>(); 
    }
    // NAME: addItem
    // IMPORTS: key - specifies which item type to add, newItem - new item to add
    // EXPORTS: none
    // PURPOSE: adds an Item to the shop to store it
    public void addItem( String key, Item newItem )
    {
        if( !(items.containsKey(key)) ) // if ArrayList with imported key doesnt exist then create one
        {
            items.put( key ,new ArrayList<Item>() );
        }
        items.get(key).add(newItem); // add item to items list
    }

    // NAME: removeItem
    // IMPORTS: key, name
    // EXPORTS: itemToRemove
    // PURPOSE: Removes and item from the shop
    public Item removeItem( String key, String name )
    {
        ArrayList<Item> list =  items.get(key);
        Item itemToRemove;
        int counter = 0;
        int index = 0;
        // find the item in the list and then remove it after
        for(Item item: list)
        {
            
            if( name.equals(item.getName( ) ) )
            {
                itemToRemove = item;
                index = counter++;
            }
            counter++;
        }
        return (Item)(list.remove(index));
    }

    // NAME: getItems
    // IMPORTS: key
    // EXPORTS List of items
    // PURPOSE: returns a list of a specified type of items indicated by the key
    public ArrayList<Item> getItems(String key)
    {
        return items.get(key);
    }

    // NAME: getShopItems
    // IMPORTS: none
    // EXPORTS: entire hashmap of shop items
    // PURPOSE: returns all shop items
    public HashMap<String,ArrayList<Item>> getShopItems()
    {
        return items;
    }

    // NAME: getItemAt
    // IMPORTS: key, index
    // EXPORTS: Item
    // PURPOSE: returns the item in the list specified by key and indicated by index
    public Item getItemAt(String key, int index)
    {
        return getItems(key).get(index);
    }

    // NOTE: assumes that there is >= 1 of each item type
    // ie if key = "W" there must be at least one weapon in the input file
    // NAME: getCheapestItem
    // IMPORTS: key
    // EXPORTS: Item
    // PURPOSE: returns the cheapest item in the specified list
    public Item getCheapestItem(String key)  
    {
        ArrayList<Item> list = getItems(key); // gets list of items with key
        int curCheapest = 999999;
        Item cheapest = null;
       
        for(Item item: list)
        {
            if(item.getCost() < curCheapest )
            {
                cheapest = item;
                curCheapest = cheapest.getCost();
            }
        }
        return cheapest;
    }

    // NAME: getListKey
    // IMPORTS: itemName, map
    // EXPORTS: key - for the list that contains itemName
    // PURPOSE: finds the list that the imported itemName is located in and returns it
    public String getListKey(String itemName, HashMap<String,ArrayList<Item>> map) throws ItemNotFoundException
    {
        ArrayList<Item> list;
        String key = "";
        for(Map.Entry<String,ArrayList<Item>> entry: map.entrySet( ) )
        {
            list = entry.getValue(); // get a list from hashmap
            for(Item item: list)
            {
                if( itemName.equals(item.getName( ) ) ) 
                {
                    key = entry.getKey(); // item found
                }
            }
        }
        if( key.equals("") )
        {
            throw new ItemNotFoundException("Item does not exist here"); // item not in list
        }

        return key;
    }

    // NAME: getItemIndex
    // IMPORTS: key, itemName
    // EXPORTS: int
    // PURPOSE: returns the index of the imported item
    public int getItemIndex( String key, String itemName )
    {
        ArrayList<Item> itemsList = items.get( key );
        int index = 0; 
        int itemIndex = 0;
        for(Item item: itemsList)
        {
            if( item.getName().equals( itemName ) )
            {
                itemIndex = index++;
            }
            index++;
        }
        return itemIndex;
    }
   
    // NAME: displayShop
    // IMPORTS: none
    // EXPORTS: none
    // PURPOSE: displays the contents of the shop, maybe should return a String that the controller passes to view?
    public void displayShop()
    {
        ArrayList<Item> list;
        for(Map.Entry<String,ArrayList<Item>> entry: items.entrySet( ) )
        {
            list = entry.getValue();
            System.out.println(entry.getKey() + ": ");
            for(Item item: list)
            {
                System.out.println(item.toString());
            }
        }
    }
}