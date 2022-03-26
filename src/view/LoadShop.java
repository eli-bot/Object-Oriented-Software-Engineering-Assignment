// FILE: LoadShop
// AUTHOR: Elijah Combes
// PURPOSE: interface for different implementations of loading shop item data from different sources to implement.
//          each implementation must use the abstract method here. strategy pattern
package view;

import controller.ShopException;
import model.Shop;

public interface LoadShop 
{
    // method for loading shop item data from sources, must be implemneted
    public abstract void loadShopData(Shop shop) throws ShopException;  
}