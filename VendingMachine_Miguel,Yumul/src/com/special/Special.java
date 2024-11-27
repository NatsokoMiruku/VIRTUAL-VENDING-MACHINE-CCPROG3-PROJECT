package com.special;

import com.regular.Regular;
import com.item.Item;
import com.slot.Slot;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Special extends Regular{
    private Item[] cCake;//variable for cake
    private String[] strFlavor = new String[5]; //variable for flavor (cannot be sold alone)
    //variable for topping (can be sold alone)



    public void initializeItems() {
        nItem[0] = new Item("Butterfingers (1 piece)", 80, 250); // updated info alr
        nItem[1] = new Item("Oreos", 45, 53); // updated info alr, nag guess lang sa price lol
        nItem[2] = new Item("Macaroon", 90, 97); // updated info alr
        nItem[3] = new Item("Brownies", 70, 112); //updated info alr
        nItem[4] = new Item("Glazed Donut", 50, 269);
        nItem[5] = new Item("Glazed Donut", 50, 269);
        nItem[6] = new Item("Glazed Donut", 50, 269);
        nItem[7] = new Item("Glazed Donut", 50, 269);
        nItem[8] = new Item("Glazed Donut", 50, 269);
        
        
    }


    public Special()
    {
        
    }

    public void initializeCake()//for price and calories, do we sell a slice of the cake or a whole cake? we could do a whole nlng, unless you want an option na pwede sila bumile ng whole or sliced cake HAHAHA
    {//if we would do a whole cake, we would need higher denominations, up to 100 lang denomination lang natin,,,wdym? they can put how many 100s in the vending machine to get to the right amount
       /* cCake = new Item( flavor ng cake + " Cake", )

        if (flavorChosen == 0)
        {
            cCake = new Item("Strawberry Cake", price, calories);
        }
        else if (flavorChosen == 1)
        {

        }*/
    }///ay sure HAHHAHA

    public void initializeFlavors()//made it 5 flavors lang para mas simple
    {
        strFlavor[0] = "Strawberry";
        strFlavor[1] = "Chocolate";
        strFlavor[2] = "Cookies and Cream";
        strFlavor[3] = "Mango Bravo";
        strFlavor[4] = "Vanilla";
    }

    public void features()
    {

        System.out.println("Welcome to the special vending machine! ");
    }
}
