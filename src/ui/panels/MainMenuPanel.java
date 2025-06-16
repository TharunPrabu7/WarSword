package ui.panels;

import game.Main;
import ui.UI;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel {
    private JPanel mainMenuPanel;
    private JButton startButton;
    private UI ui;
    private Main.ChoiceHandler ch;

    public MainMenuPanel(UI ui, Main.ChoiceHandler ch){
        this.ui = ui;
        this.ch = ch;
        createMainMenu();
    }

    public void createMainMenu(){
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds(0,0,ui.getWIDTH(), ui.getHEIGHT());
        mainMenuPanel.setBackground(Color.BLACK);
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setLayout(null);

        startButton = new JButton("Start");
        startButton.setBounds(500, 300, 200, 50);
        startButton.setFocusPainted(false);
        startButton.setActionCommand("start");
        startButton.addActionListener(ch);

        mainMenuPanel.add(startButton);

        ui.getWindow().add(mainMenuPanel);
    }

    public JPanel getMainMenuPanel(){
        return mainMenuPanel;
    }
}
