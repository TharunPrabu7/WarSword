package ui.panels;

import game.Main;
import ui.UI;

import javax.swing.*;
import java.awt.*;

public class TownPanel {
    JPanel townPanel;
    Main.choiceHandler ch;
    UI ui;
    public TownPanel(UI ui, Main.choiceHandler ch){
        this.ui = ui;
        this.ch = ch;
        createTown();
    }

    public void createTown(){
        townPanel = new JPanel();
        townPanel.setBounds(0, 0, ui.getWIDTH(), ui.getHEIGHT());
        townPanel.setBackground(Color.DARK_GRAY);
        townPanel.setLayout(null);
        ui.getWindow().add(townPanel);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(500,300,200,50);
        backButton.setActionCommand("mainmenu");
        backButton.addActionListener(ch);
        townPanel.add(backButton);

        ui.getWindow().add(townPanel);
        ui.getWindow().revalidate();
        ui.getWindow().repaint();
    }
}
