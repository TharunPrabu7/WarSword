package ui.panels;

import game.GameController;
import game.Main;
import ui.UI;

import javax.swing.*;
import java.awt.*;

public class TownPanel {
    JPanel townPanel;
    public JLabel summary;
    Main.ChoiceHandler ch;
    GameController gc;
    UI ui;

    public TownPanel(UI ui, Main.ChoiceHandler ch, GameController gc){
        this.ui = ui;
        this.ch = ch;
        this.gc = gc;
        createTown();
    }

    public void createTown(){
        townPanel = new JPanel();
        townPanel.setBounds(0, 0, ui.getWIDTH(), ui.getHEIGHT());
        townPanel.setBackground(Color.DARK_GRAY);
        townPanel.setLayout(null);

        // To main menu
        JButton backButton = new JButton("<-");
        backButton.setBounds(ui.getWIDTH()-60,10,50,50);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.setActionCommand("mainMenu");
        backButton.addActionListener(ch);
        townPanel.add(backButton);

        // Inventory
        JButton inventoryButton = new JButton("I");
        inventoryButton.setBounds(ui.getWIDTH()-120,10,50,50);
        inventoryButton.setBackground(Color.white);
        inventoryButton.setForeground(Color.black);
        inventoryButton.setActionCommand("inventory");
        inventoryButton.addActionListener(ch);
        townPanel.add(inventoryButton);

        // Fight Boss
        JButton fightBossButton = new JButton("Fight Boss");
        fightBossButton.setBounds(500,300,200,50);
        fightBossButton.setActionCommand("fightBoss");
        fightBossButton.addActionListener(ch);
        townPanel.add(fightBossButton);

        // Miner
        JButton mineButton = new JButton("Mine");
        mineButton.setBounds(50,100,100,100);
        mineButton.setBackground(Color.red);
        mineButton.setActionCommand("mine");
        mineButton.addActionListener(ch);
        townPanel.add(mineButton);

        // Smelter
        JButton smeltButton = new JButton("Smelt");
        smeltButton.setBounds(160,100,100,100);
        smeltButton.setBackground(Color.blue);
        smeltButton.setActionCommand("smelt");
        smeltButton.addActionListener(ch);
        townPanel.add(smeltButton);

        // Weaponry
        JButton makeWeaponButton = new JButton("Make weapon");
        makeWeaponButton.setBounds(270,100,100,100);
        makeWeaponButton.setBackground(Color.green);
        makeWeaponButton.setActionCommand("makeWeapon");
        makeWeaponButton.addActionListener(ch);
        townPanel.add(makeWeaponButton);

        // Armory
        JButton makeArmorButton = new JButton("Armor");
        makeArmorButton.setBounds(380,100,100,100);
        makeArmorButton.setBackground(Color.lightGray);
        makeArmorButton.setActionCommand("makeArmor");
        makeArmorButton.addActionListener(ch);
        townPanel.add(makeArmorButton);

        // Farm
        JButton makeFoodButton = new JButton("Food");
        makeFoodButton.setBounds(490,100,100,100);
        makeFoodButton.setBackground(Color.black);
        makeFoodButton.setForeground(Color.white);
        makeFoodButton.setActionCommand("makeFood");
        makeFoodButton.addActionListener(ch);
        townPanel.add(makeFoodButton);

        // Barracks
        JButton trainSoldierButton = new JButton("Train");
        trainSoldierButton.setBounds(600,100,100,100);
        trainSoldierButton.setBackground(Color.yellow);
        trainSoldierButton.setActionCommand("trainSoldier");
        trainSoldierButton.addActionListener(ch);
        townPanel.add(trainSoldierButton);

        // Summary
        summary = new JLabel("Ore: 0 | Ingot: 0 | weapon: 0 | Armor: 0 | Food: 0 | Infantry: 0");
        summary.setBounds(0,0,ui.getWIDTH(),150);
        summary.setBackground(Color.black);
        summary.setForeground(Color.white);
        summary.setFont(new Font("Arial", Font.PLAIN, 20));
        summary.setLayout(new GridBagLayout());
        townPanel.add(summary);

        ui.getWindow().add(townPanel);
    }

    public void setGameController(GameController gc){
        this.gc = gc;
    }

    public void updateSummary(String text){
        summary.setText(text);
    }

    public JPanel getTownPanel(){
        return townPanel;
    }
}
