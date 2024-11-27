/**
 * This class is used for the inventory of items
 * that will be used in the vending machine
 *  @author Miguel
 *  @author Yumul
 */

package com.slot;
import com.item.Item;

public class Slot 
{
    /* fields and attributes */
    private Item cItem;
    private int nAmount;

   /**
   * Initializes the fields of the class Slot
   * A constructor
   * 
   * @param cItem  a variable of datatype Item
   * @param nAmount the amount an item can contain
   */
    public Slot(Item cItem, int nAmount)
    {
        this.cItem = cItem;
        this.nAmount = nAmount;
    }

   /**
   * Method to display vending machine item set
   * @return the displayed statement
   */
    public String display()
    {
        return nAmount + "\t\t\t" + cItem.getItemname() + "\t\t\t" + "P" + cItem.getPrice() + "\t\t\t" + cItem.getCalories();
    }

 /**
   * Decreases the current stock of a chosen item
   * If the stock of the item is decreased
   * 
   */
    public void decreaseAmount()
    {
        nAmount--;
    }

    /* Getter and setter methods */

  /**
   * Allows other classes to see the content of variable cItem
   * @return the item desired
   */
    public Item getItem()
    {
        return cItem;
    }
    
/**
   * Allows other classes to see the content of variable nAmount
   * @return the amount desired
   */
    public int getAmount()
    {
        return nAmount;
    }

/**
   * Allows other classes to change the content of variable cItem
   * @param cItem is the item desired
   * 
   */
    public void setItem(Item cItem)
    {
        this.cItem = cItem;
    }

/**
   * Allows other classes to change the content of variable nAmount
   * @param nAmount is the amount of an item desired
   * 
   */
    public void setAmount(int nAmount)
    {
        this.nAmount = nAmount;
    }

}


