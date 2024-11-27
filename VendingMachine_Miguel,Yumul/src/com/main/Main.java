/* Header Declarations */
package com.main;
import java.util.*;
import com.graphics.Graphics;
import com.vendingMachine.VendingMachine;
import com.regular.Regular;
import com.special.Special;


public class Main {
    public static void main(String[] args) //throws Exception 
    { 
        Regular cRegular = new Regular();
        Special cSpecial = new Special();
        cRegular.initializeItems();
        cRegular.initializeSlots();
        cSpecial.initializeItems();
        cSpecial.initializeSlots();
        cSpecial.initializeFlavors();
        //insert call to VendingMachine here, since 1 line lang daw sa main sabi ni ms
        //VendingMachine machine = new VendingMachine();
        VendingMachine machine = new VendingMachine(cRegular, cSpecial);
        //test for gui
        //Graphics test = new Graphics();
    }
}