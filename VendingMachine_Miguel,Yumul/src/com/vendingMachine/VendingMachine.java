package com.vendingMachine;

import java.util.Scanner;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.regular.Regular;
import com.special.Special;

public class VendingMachine {

    private JFrame mainFrame;
    private JButton[] startButtons = new JButton[3];
    private JPanel startScreen = new JPanel();
    private JPanel regularScreen = new JPanel();
    private JPanel specialScreen = new JPanel();

    public VendingMachine(Regular cRegular, Special cSpecial)
    {
        this.mainFrame = new JFrame("Virtual Vending Machine");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout());
        this.mainFrame.setSize(500, 500);

        start(cRegular, cSpecial);

        this.mainFrame.setVisible(true); //Always last sa constructor
    }

    public void start(Regular cRegular, Special cSpecial){
        startScreen.setSize(250, 250);
        startScreen.setLayout(new BoxLayout(startScreen, BoxLayout.PAGE_AXIS));
        JLabel startGraphic = new JLabel("<html><h3><bold>Welcome to the Vending Machine! Available Options Are:</bold></h3><hr></html>");
        startButtons[0] = new JButton("Regular");
        startButtons[1] = new JButton("Special");
        startButtons[2] = new JButton("Exit");
        startButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                regularMenu(cRegular);
            }
        });
        startButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                specialMenu(cSpecial);
            }
        });
        startButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        startGraphic.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButtons[0].setAlignmentX(Component.CENTER_ALIGNMENT);
        startButtons[1].setAlignmentX(Component.CENTER_ALIGNMENT);
        startButtons[2].setAlignmentX(Component.CENTER_ALIGNMENT);
        startScreen.add(startGraphic);
        startScreen.add(startButtons[0]);
        startScreen.add(startButtons[1]);
        startScreen.add(startButtons[2]);
        this.mainFrame.add(startScreen);
    }

    //follow the format of regularmenu to specialmenu
    //call this again when done with features or maintenance
    public void regularMenu(Regular cRegular){
        this.mainFrame.remove(startScreen);  //removes the previous panel so that it taketh the new panel, do this everytime panel changes
        regularScreen.setSize(200, 200);
        //change to grid layout later to simulate vending machine front.
        regularScreen.setLayout(new BoxLayout(regularScreen, BoxLayout.PAGE_AXIS));
        JButton[] regularButton = new JButton[3];
        JLabel regularGraphic = new JLabel("Options for regular Vending machine");
        regularButton[0] = new JButton("Features");
        regularButton[1] = new JButton("Maintenance");
        regularButton[2] = new JButton("Exit");
        regularButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                regularFeatures(cRegular);
            }
        });
        regularButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                regularMaintenance(cRegular);
            }
        });
        regularButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        //add regular vending machine menu here
        //add buttons, text, and other shit that are the first thing they see here.
        regularScreen.add(regularGraphic);
        regularScreen.add(regularButton[0]);
        regularScreen.add(regularButton[1]);
        regularScreen.add(regularButton[2]);
        this.mainFrame.add(regularScreen);
        mainFrame.pack();        //call so that new panel appears, do this everytime panel changes
    }

    //add other regular vending machine ui methods and changes here
    public void regularFeatures(Regular cRegular){

    }

    public void regularMaintenance(Regular cRegular){

    }
    
    /*-------------------------------------------- */
    public void specialMenu(Special cSpecial){

    }
}


/* 
public class VendingMachine {

    private JFrame mainFrame;

    public VendingMachine(Regular cRegular)
    {
        this.mainFrame = new JFrame("Virtual Vending Machine");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout());
        this.mainFrame.setSize(500, 500);
        this.mainFrame.setBackground(Color.magenta);

        vendingMachine(cRegular);

        this.mainFrame.setVisible(true); //Always last sa constructor
    }

    public void vendingMachine(Regular cRegular)
    {        
        /* Initializes items and slots 
        cRegular.initializeItems();
        cRegular.initializeSlots();

        JLabel graphicLabel = new JLabel("Welcome to Vending Machine! Available options are: ");
        graphicLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton graphicButton = new JButton("Regular Vending Machine");
        graphicButton.setHorizontalAlignment(JButton.CENTER);

        JButton graphicButton1 = new JButton("Special Vending Machine");
        graphicButton1.setHorizontalAlignment(JButton.CENTER);

        JButton graphicButton2 = new JButton("Exit");
        graphicButton2.setHorizontalAlignment(JButton.CENTER);

        /*System.out.println("Welcome to Vending Machine!");
        System.out.println("[1]Regular Vending Machine");
        System.out.println("[2]Special Vending Machine");
        System.out.println("[3]Exit\n");
        System.out.println("Above are the available choices: ");

        Scanner sc = new Scanner(System.in);
        int nMenu = sc.nextInt();*/

        //continue maya actionlistener (pag click of button)

        //add clear screen logic here

        /* For Regular Vending Machine 
        while(nMenu == 1)
        {
            JLabel graphicLabel1 = new JLabel("Welcome to the Regular Vending Machine!");
            graphicLabel1.setHorizontalAlignment(JLabel.CENTER);

            JButton graphicButton3 = new JButton("Vending Machine Features");
            graphicButton3.setHorizontalAlignment(JButton.CENTER);

            JButton graphicButton4 = new JButton("Vending Machine Maintenance");
            graphicButton4.setHorizontalAlignment(JButton.CENTER);

            JButton graphicButton5 = new JButton("Back");
            graphicButton5.setHorizontalAlignment(JButton.CENTER);

            

            //continue maya actionlistener (pag click of button)

            //add clear screen logic here

            //System.out.print("\033[H\033[2J"); /* Clears console screen */
            /*System.out.flush();

            System.out.println("Welcome to the Regular Vending Machine!");
            System.out.println("Available options are: ");
            System.out.println("[1]Vending Machine Features");
            System.out.println("[2]Vending Machine Maintenance");
            System.out.println("[3]Exit");

            int nOption = sc.nextInt();*/
            
            /* If the Regular Vending machine FEATURES was chosen 
            while(nOption == 1)
            {
                JLabel graphicLabel2 = new JLabel("Select an option:");
                graphicLabel2.setHorizontalAlignment(JLabel.CENTER);

                JButton graphicButton6 = new JButton("Use Vending Machine");
                graphicButton6.setHorizontalAlignment(JButton.CENTER);

                JButton graphicButton7 = new JButton("Back");
                graphicButton7.setHorizontalAlignment(JButton.CENTER);

                //continue maya actionlistener (pag click of button)

                //add clear screen logic here

                /*System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("[0]Use Vending Machine");
                System.out.println("[3]Back");
                int nFeature = sc.nextInt();

                // goes back to the main menu
                if (nFeature == 3)
                {
                    nOption = 0;
                    nMenu = 1;
                }
                // uses vending machine features
                else
                {
                    cRegular.machineDisplay();
                    cRegular.features();

                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    System.out.println("\n");
                }
            }

            /* If Regular Vending machine MAINTENANCE was chosen 
            while (nOption == 2)
            {
                JLabel graphicLabel3 = new JLabel("Select an option:");
                graphicLabel3.setHorizontalAlignment(JLabel.CENTER);

                JButton graphicButton8 = new JButton("Use Maintenance");
                graphicButton8.setHorizontalAlignment(JButton.CENTER);

                JButton graphicButton9 = new JButton("Back");
                graphicButton9.setHorizontalAlignment(JButton.CENTER);

                //continue maya actionlistener (pag click of button)

                //add clear screen logic here

                //System.out.print("\033[H\033[2J"); /* Clears console screen 
                /*System.out.flush();

                System.out.println("[0]Use Maintenance");
                System.out.println("[3]Back");
                int nMaintenance = sc.nextInt();


                // goes back to the main menu
                if(nMaintenance == 3)
                {
                    nOption = 0;
                    nMenu = 1;
                }
                // uses vending machine maintenance
                else
                {
                    cRegular.maintenance();
                }
            }

            if (nOption == 3)
            {
                nMenu = 0;
            }
        }

        //NOT INCLUDED IN MCO1 YET
        /* For Special Vending Machine 
        while(nMenu == 2)
        {
            JLabel graphicLabel4 = new JLabel("Welcome to the Special Vending Machine!");
            graphicLabel4.setHorizontalAlignment(JLabel.CENTER);

            JButton graphicButton10 = new JButton("Vending Machine Features");
            graphicButton10.setHorizontalAlignment(JButton.CENTER);

            JButton graphicButton11 = new JButton("Vending Machine Maintenance");
            graphicButton11.setHorizontalAlignment(JButton.CENTER);

            JButton graphicButton12 = new JButton("Back");
            graphicButton12.setHorizontalAlignment(JButton.CENTER);
            
            //continue maya actionlistener (pag click of button)

            //add clear screen logic here

            /*System.out.println("Welcome to the Special Vending Machine!");
            System.out.println("Available options are: ");
            System.out.println("[1]Vending Machine Features");
            System.out.println("[2]Vending Machine Maintenance");
            System.out.println("[3]Exit");

            int nOption = sc.nextInt();

            while(nOption == 1)
            {
                

                System.out.println("Features");
                System.out.println("[3]Back");
                int nFeature = sc.nextInt();
                if(nFeature == 3)
                {
                    nOption = 0;
                    nMenu = 2;
                }
            }

            while(nOption == 2)
            {
                System.out.println("Maintenance");
                System.out.println("[3]Back");
                int nMaintenance = sc.nextInt();
                if(nMaintenance == 3)
                {
                    nOption = 0;
                    nMenu = 2;
                }
            }

            if(nOption == 3)
            {
                nMenu = 0;
            }
        }
        if(nMenu == 3)
        {
           nMenu = 0;
        }
        sc.close();
    }
}

public void showRegular(){
    
}
 */