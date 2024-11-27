package com.graphics;

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Graphics {

    private JFrame mainFrame;

    public Graphics()
    {
        this.mainFrame = new JFrame("Virtual Vending Machine");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout());
        this.mainFrame.setSize(500, 500);

        this.mainFrame.setVisible(true); //Always last sa constructor
    }

    
}
