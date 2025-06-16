package ui;

import javax.swing.*;

public class UI {

    JFrame window;

    final private int HEIGHT = 720;
    final private int WIDTH = 1280;

    public void createUI(){
        window = new JFrame("War Sword 10000");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public JFrame getWindow(){
        return window;
    }

    public int getHEIGHT(){
        return HEIGHT;
    }

    public int getWIDTH(){
        return WIDTH;
    }
}
