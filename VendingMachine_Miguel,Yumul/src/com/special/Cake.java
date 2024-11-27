package com.special;
import java.util.*;
import com.item.Item;

public class Cake {
    private Item flavor;
    private ArrayList<Item> toppings = new ArrayList<>();
    private int totalCalories = 300;
    private int totalPrice = 350;

    Cake(Item flavor){
        this.flavor = flavor;
    }

    public void addTopping(Item topping){
        toppings.add(topping);
        totalCalories += topping.getCalories();
        totalPrice += topping.getPrice();
    }

    public ArrayList<Item> getToppings(){
        return toppings;
    }

    public int getTotalCalories(){
        return totalCalories;
    }

    public Item getFlavor(){
        return flavor;
    }

    public int getTotalPrice(){
        return totalPrice;
    }
}
