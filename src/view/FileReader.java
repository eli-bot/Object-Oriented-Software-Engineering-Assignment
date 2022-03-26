// FILE: FileReader.java
// AUTHOR: Elijah Combes
// PURPOSE: Type of LoadShop, part of stategy pattern for loading shop data from a source
//          loads shop data from a file to initialise a shop object
package view;

import java.util.*;
import java.io.*;
import view.LoadShop;
import model.ShopItemFactory;
import controller.ShopException;
import model.items.Item;
import model.Shop;

public class FileReader implements LoadShop
{
    
    // NAME: loadShopData
    // IMPORTS: Shop
    // EXPORTS: none
    // PURPOSE: loads the shop item data from a file and into the shop
    @Override
    public void loadShopData( Shop shop ) throws ShopException
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String fileName = "resources/ShopItems.txt";
        StringTokenizer strTok;

        Item newItem = null;
        String[] str;
        int count = 0;
        String line;

        try
        {
            fileStrm = new FileInputStream( fileName );
            rdr = new InputStreamReader( fileStrm );
            bufRdr = new BufferedReader( rdr );

            line = bufRdr.readLine( ); // get line from file
            while( line != null ) 
            {
                str = line.split(", ",10);
                
                String symbol = str[0]; // item symbolie "W" for Weapon
                newItem = ShopItemFactory.createItem(symbol,str); // gte and create appropriate item from factory
                if( newItem != null )
                {
                    shop.addItem( symbol , newItem ); // add item to shop
                    count++;
                }
                line = bufRdr.readLine();
            }
            fileStrm.close(); // close file
        }
        catch(ArrayIndexOutOfBoundsException a)
        {
            throw new ShopException("Bad shop data file.",a); // shop data file is incorrect
        }
        catch( IOException e )
        {
            if( fileStrm != null )
            {
                try
                {
                    fileStrm.close(); // close file
                }
                catch( IOException ex2 ) {}
            }
            throw new ShopException("Bad Shop data file.", e);
        }
    }
}