/**
 * This class is used for the features and maintenance
 * of the regular vending machine
 * it represents the properties of the vending mahine and how its being used 
 * along with updating the and modifying the items and the other attributes 
 * within the vending machine 
 *  @author Miguel
 *  @author Yumul
 */

package com.regular;

import com.item.Item;
import com.slot.Slot;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Regular {
    /* Field Declarations */
    protected Item[] nItem = new Item[9];
    protected Slot[] nSlot = new Slot[8];
    protected final int[] nMoney = { 1, 5, 10, 20, 50, 100 };
    protected int[] nMoneyCount = { 5, 5, 5, 5, 5, 5 };
    protected int nTotalAmount = 0;
    protected final int startInv = 10;

    /**
     * Method that displays the item descriptions in the regular vending machine
     */
    public void machineDisplay() {
        System.out.println("Amount" + "\t\t\t" + "Item" + "\t\t\t" + "Price" + "\t\t\t" + "Calories");
        System.out.println("[0]" + nSlot[0].display());
        System.out.println("[1]" + nSlot[1].display());
        System.out.println("[2]" + nSlot[2].display());
        System.out.println("[3]" + nSlot[3].display());
        System.out.println("[4]" + nSlot[4].display());
        System.out.println("[5]" + nSlot[5].display());
        System.out.println("[6]" + nSlot[6].display());
        System.out.println("[7]" + nSlot[7].display());
    }

    /**
     * Method that assigns item in each slot
     */
    public void initializeItems() {
        nItem[0] = new Item("Butterfingers (1 piece)", 80, 250); // updated info alr
        nItem[1] = new Item("Oreos", 45, 53); // updated info alr, nag guess lang sa price lol
        nItem[2] = new Item("Butter Sugar", 50, 140);
        nItem[3] = new Item("Egg Tart", 55, 225);
        nItem[4] = new Item("Macaroon", 90, 97); // updated info alr
        nItem[5] = new Item("Butter Croissant", 70, 231);
        nItem[6] = new Item("Brownies", 70, 112); //updated info alr
        nItem[7] = new Item("Glazed Donut", 50, 269);
    }

    /**
     * Method to initialize items in a slot and how many items in stock
     */
    public void initializeSlots() {
        nSlot[0] = new Slot(nItem[0], startInv);
        nSlot[1] = new Slot(nItem[1], startInv);
        nSlot[2] = new Slot(nItem[2], startInv);
        nSlot[3] = new Slot(nItem[3], startInv);
        nSlot[4] = new Slot(nItem[4], startInv);
        nSlot[5] = new Slot(nItem[5], startInv);
        nSlot[6] = new Slot(nItem[6], startInv);
        nSlot[7] = new Slot(nItem[7], startInv);
    }

    /**
     * Method that prints characters with delay
     * 
     * @param data
     * @param unit
     * @param delay
     */
    public static void printWithDelays(String data, TimeUnit unit, long delay) throws InterruptedException {
        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }

    /**
     * Method for Features of the Regular Vending Machine
     * features include:
     * inserting of money
     * item selection
     * checks selection if the item is in stock
     * checks inserted money if sufficient with selected item
     * insert and add money
     * selection of another item
     * cancel transaction
     * dispense item
     * checks if the machine has sufficient change otherwise transaction is
     * cancelled
     */


     //NEEDS FIXING TO ACCOMODATE THE GUI
     /*
      Checklist of things to do:
        1.remove all print text, and transfer over to the gui. All that will be left here are computations and returns and
        occasional console printing for error checking.
        2.some features may need to be seperated to different methods because you will need to return some values to the gui so that
        it will respond to changes in the vending machine object.
        3.All the values and stuff will be left here.
        4. in vending machine, just follow how i did the start menu and call the needed methods from regular or special
        so that you can get the needed results.

      */
    public void features() throws Exception {
        Scanner sc = new Scanner(System.in);
        int nPlace = -1;
        int nInsert = 0;
        int cancel = 0;
        int[] nDenomInsert = { 0, 0, 0, 0, 0, 0 };

        // user insert money by denomination
        System.out.println("[0]Php 1" + " " + "[1]Php 5" + " " + "[2]Php 10" + " " + "[3]Php 20" + " " + "[4]Php 50"
                + " " + "[5]Php 100");
        System.out.println("Insert Money");
        System.out.print("--> ");
        nPlace = sc.nextInt();

        if (nPlace != 6) {
            nInsert += nMoney[nPlace];
            nDenomInsert[nPlace]++;
        }

        /*
         * If the user wishes to add more money into the machine until user selects item
         */
        do {
            System.out.println("[0]Php 1" + " " + "[1]Php 5" + " " + "[2]Php 10" + " " + "[3]Php 20" + " " + "[4]Php 50"
                    + " " + "[5]Php 100");

            /* If the user wishes to choose an item */
            System.out.println("[6]Select Item");
            System.out.println("Money Inserted: " + nInsert);
            System.out.println("Select choice: ");
            System.out.print("--> ");
            nPlace = sc.nextInt();

            if (nPlace != 6) {
                nInsert += nMoney[nPlace];
                nDenomInsert[nPlace]++;
            }
        } while (nPlace != 6);

        // user selects item according to item index
        System.out.print("Select item number to choose item: ");
        int nSelect = sc.nextInt();

        // If the item chosen is out of stock
        if (nSlot[nSelect].getAmount() == 0) {
            while (nSlot[nSelect].getAmount() == 0) {
                System.out.println("Selected slot is empty. ");
                System.out.println("Kindly select another item: ");

                System.out.println("");
                System.out.println("Select Number to Choose Item");
                nSelect = sc.nextInt();

                System.out.println("Selected Item: " + nSlot[nSelect].display());
            }
        } else { // added item details line,, pa check if tama yung /t or \t ba dapat lol
            System.out.println("Amount" + "\t\t\t" + "Item" + "\t\t\t" + "Price" + "\t\t\t" + "Calories"); 
                                                                                                         
            System.out.println("Selected Item: " + nSlot[nSelect].display());
        }

        /* If the inserted money is insufficient for the item */
        if (nInsert < nSlot[nSelect].getItem().getPrice()) {
            int flag = 0;

            while (nInsert < nSlot[nSelect].getItem().getPrice() && flag == 0) {
                System.out.println("Insufficient Balance. Kindly add more cash or select another item: ");
                System.out.println("[0]Php 1" + " " + "[1]Php 5" + " " + "[2]Php 10" + " " + "[3]Php 20" + " "
                        + "[4]Php 50" + " " + "[5]Php 100");
                System.out.println("[1] Add cash");
                System.out.println("[2] Select another item");
                System.out.println("[3] Cancel");
                int nChosenOption = sc.nextInt();

                // if user wants to add more cash
                if (nChosenOption == 1) {
                    while (nChosenOption == 1) {
                        System.out.print("Enter cash to insert: ");
                        nPlace = sc.nextInt();
                        nInsert += nMoney[nPlace];
                        nDenomInsert[nPlace]++;

                        System.out.println("Money Inserted: " + nInsert);
                        System.out.println("Would you like to enter more cash?");
                        System.out.println("Enter [1] for yes or [2] for no");
                        System.out.print("Enter option: ");
                        nChosenOption = sc.nextInt();
                    }
                }

                // if user instead wants to select another item
                else if (nChosenOption == 2) {
                    System.out.print("Select item number to choose item: ");
                    nSelect = sc.nextInt();

                    System.out.println("Selected Item: " + nSlot[nSelect].display());

                    // If the item chosen is out of stock
                    if (nSlot[nSelect].getAmount() == 0) {
                        System.out.println("Selected slot is empty. ");
                        System.out.println("Kindly select another item: ");

                        while (nSlot[nSelect].getAmount() == 0) {
                            System.out.println("");
                            System.out.println("Select Number to Choose Item");
                            nSelect = sc.nextInt();

                            System.out.println("Selected Item: " + nSlot[nSelect].display());

                            if (nSlot[nSelect].getAmount() == 0)
                                System.out.println("Selected Slot is Empty");

                            System.out.println("Kindly select another item");
                        }
                    }
                }

                // if user wants to cancel transaction
                else if (nChosenOption == 3) {
                    flag = 1;
                    cancel = 1;
                }
            }
        }

        int nDispense = 0;

        // user input to dispense item or cancel transaction
        if (cancel != 1) {
            System.out.println("Kindly decide whether to cancel or proceed with transaction.");
            System.out.println("[1]Dispense");
            System.out.println("[2]Cancel");
            System.out.print("Enter choice: ");
            nDispense = sc.nextInt();
        }

        // dispenses item along with change
        if (nDispense == 1) {
            // gets change and checks if machine can accomodate change
            int nNeededChange = nInsert - nSlot[nSelect].getItem().getPrice();
            int giveChange = nNeededChange;
            int[] tempNmoneyCount = nMoneyCount.clone();

            while (nNeededChange > 0) {
                if (nNeededChange >= 100 && tempNmoneyCount[5] > 0) {
                    nNeededChange -= nMoney[5]; // minus denomination index from change
                    tempNmoneyCount[5]--; // minus number of money count

                } else if (nNeededChange >= 50 && tempNmoneyCount[4] > 0) {
                    nNeededChange -= nMoney[4];
                    tempNmoneyCount[4]--;
                } else if (nNeededChange >= 20 && tempNmoneyCount[3] > 0) {
                    nNeededChange -= nMoney[3];
                    tempNmoneyCount[3]--;
                } else if (nNeededChange >= 10 && tempNmoneyCount[2] > 0) {
                    nNeededChange -= nMoney[2];
                    tempNmoneyCount[2]--;
                } else if (nNeededChange >= 5 && tempNmoneyCount[1] > 0) {
                    nNeededChange -= nMoney[1];
                    tempNmoneyCount[1]--;
                } else if (nNeededChange >= 1 && tempNmoneyCount[0] > 0) {
                    nNeededChange -= nMoney[0];
                    tempNmoneyCount[0]--;
                } else {
                    nNeededChange = -1;
                }
            }

            // if machine change does not satisfy the needed change it will opt to cancel
            // transaction
            if (nNeededChange == -1) {

                System.out.println("Not enough change in the machine. ");
                cancel = 1;
            }

            // if machine change is satisfied, item and change will dispense
            else {
                printWithDelays("Change: " + giveChange + "\n", TimeUnit.MILLISECONDS, 80);
                printWithDelays("Dispensing Item\n", TimeUnit.MILLISECONDS, 40);
                printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
                printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
                printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
                System.out.println("Item Dispensed");
                nMoneyCount = tempNmoneyCount.clone();

                nSlot[nSelect].decreaseAmount();
                nTotalAmount += nSlot[nSelect].getItem().getPrice();
                nSlot[nSelect].getItem().nTimesSold();
            }
        }

        // cancels the transaction
        if (nDispense == 2 || cancel == 1) {
            printWithDelays("Transaction Cancelled\n", TimeUnit.MILLISECONDS, 20);
            printWithDelays("Cash Returned: " + nInsert + "\n", TimeUnit.MILLISECONDS, 80);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    }

    /**
     * Method for printing the summary of transactions
     */
    public void summaryofTransactions() throws Exception {
        System.out.println("Items Sold: ");

        for (int i = 0; i < nSlot.length; i++) {
            System.out.println("~ " + nSlot[i].getItem().getItemname() + " = " + nSlot[i].getItem().getTimesSold());
        }

        System.out.println(" ");
        System.out.println("Total Money Collected: " + nTotalAmount);
        System.out.println(" ");
        System.out.println("Starting Inventory: ");

        for (int i = 0; i < nSlot.length; i++) {
            System.out.println("~ " + nSlot[i].getItem().getItemname() + " = " + startInv);
        }
        System.out.println(" ");
        System.out.println("Ending Inventory: ");
        for (int i = 0; i < nSlot.length; i++) {
            System.out.println("~ " + nSlot[i].getItem().getItemname() + " = " + nSlot[i].getAmount());
        }
    }

    /**
     * Method for Maintenance of the Regular Vending Machine
     * Maintenance include:
     * restocking of items
     * price setting of items
     * collection of money inside machine
     * replenishing change inside machine
     * prints the summaryofTransactions()
     */
    public void maintenance() throws Exception {
        System.out.println("Welcome to the maintenance features! ");
        System.out.println("Kindly choose any option below.");
        System.out.println("[1] Stocking/Re-stocking of items");
        System.out.println("[2] Setting prices of items");
        System.out.println("[3] Collecting money inside machine");
        System.out.println("[4] Replenishing money (in different denominations) for change");
        System.out.println("[5] Print summary of transactions\n");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter option: ");
        int nMaintenanceChoice = input.nextInt();

        // Stocking/Re-stocking items
        if (nMaintenanceChoice == 1) {
            System.out.println("Re-stocking option chosen. All items would be re-stocked. ");
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);

            for (int i = 0; i < nSlot.length; i++) {
                nSlot[i].getItem().resetTimesSold();
            }

            initializeSlots();
        }

        // Price Setting
        else if (nMaintenanceChoice == 2) {
            System.out.println("Setting prices of items chosen. Kindly select which item to set.");
            machineDisplay();

            System.out.print("Enter the item index to set: ");
            int nItemChosen = input.nextInt();

            System.out.println(nItem[nItemChosen].getItemname() + " item chosen.");
            System.out.println("Current item price: " + nItem[nItemChosen].getPrice());
            System.out.println("Enter the new price of " + nItem[nItemChosen].getItemname());
            int nNewPrice = input.nextInt();

            nItem[nItemChosen].setPrice(nNewPrice);
        }

        // Cash Collection
        else if (nMaintenanceChoice == 3) {
            System.out.println("Collection of cash inside machine selected. ");
            System.out.println("Cash: " + nTotalAmount);

            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            System.out.println("Money collected!");
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);

            nTotalAmount = 0;
        }

        // Replenishing Change in Machine
        else if (nMaintenanceChoice == 4) {

            System.out.println("Replenishing money for change option selected. ");
            for (int i = 0; i < nMoneyCount.length; i++) {
                nMoneyCount[i] = 5;
            }

            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
            printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
        }

        // Printing of summary of transactions
        else if (nMaintenanceChoice == 5) {
            int nOk = 1;

            while (nOk != 0) {
                System.out.print("\033[H\033[2J");
                System.out.println("Printing summary of transactions.");
                printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
                printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);
                printWithDelays(".\n", TimeUnit.MILLISECONDS, 500);

                summaryofTransactions();
                System.out.println("[0]Back");
                nOk = input.nextInt();
            }

        }

    }
}
