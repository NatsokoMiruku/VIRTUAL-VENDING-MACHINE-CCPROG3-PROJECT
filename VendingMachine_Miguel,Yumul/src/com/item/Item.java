/**
 * This class is used to describe the item that will be 
 * used in the slot and to be sold by the vending machine
 *  @author Miguel
 *  @author Yumul
 */

package com.item;

public class Item
{
    private String strItemname; 
    private int nPrice;
    private int nCalories;
    private int nTimesSold = 0;

    /**
     * Constructor for the variables used in Item class.
     * @param strItemname the name of the item.
     * @param nPrice the price of the item.
     * @param nCalories the calories of the item.
     */

    public Item(String strItemname, int nPrice, int nCalories)
    {
        this.strItemname = strItemname;
        this.nPrice = nPrice;
        this.nCalories = nCalories;
    }

    /**
     * this method increases number of times an item is old
     */
    public void nTimesSold()
    {
        nTimesSold++;
    }

    /**
     * this method resets the number of times sold when restocking
     */
    public void resetTimesSold()
    {
        nTimesSold = 0;
    }

     /**
     * returns the number of times sold.
     * @return the integer number of the number of times a specific item has been sold
     */
    public int getTimesSold()
    {
        return nTimesSold;
    }

    /**
     * returns the string item name.
     * @return strItemname
     */
    public String getItemname()
    {
        return strItemname;
    }

    /**
     * returns the item price.
     * @return nPrice
     */
    public int getPrice()
    {
        return nPrice;
    }

    /**
     * returns the item calories.
     * @return nCalories
     */
    public int getCalories()
    {
        return nCalories;
    }

    /**
     * returns the number of times sold.
     * @return exp
     */
    public void setItemname(String strItemname)
    {
        this.strItemname = strItemname;
    }

    /**
     * Method that sets the price of the item
     * @param nPrice price of the item
     */
    public void setPrice(int nPrice)
    {
        this.nPrice = nPrice;
    }

    /**
     * Method that sets the calories of the item
     * @param nCalories calories of the item
     */
    public void setCalories(int nCalories)
    {
        this.nCalories = nCalories;
    }
}

