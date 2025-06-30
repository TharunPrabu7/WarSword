package ui.panels;

import game.controller.GameController;
import game.Main;
import ui.UI;

import javax.swing.*;
import java.awt.*;

public class CombatPanel {
    private final JPanel combatPanel;
    private final JTextArea combatLog;
    private final JLabel soldierHpLabel;
    private final JLabel bossHpLabel;
    private final JButton attackButton;
    private final GameController gc;

    public CombatPanel(UI ui, Main.ChoiceHandler ch, GameController gc){
        this.gc = gc;
        combatPanel = new JPanel();
        combatPanel.setLayout(null);
        combatPanel.setBounds(0, 0, ui.getWIDTH(), ui.getHEIGHT());
        combatPanel.setBackground(Color.darkGray);

        // HP Labels
        soldierHpLabel = new JLabel("Soldier HP: " + gc.getCombatManager().getSoldier().getHp());
        bossHpLabel = new JLabel("Boss HP: " + gc.getCombatManager().getBoss().getHp());
        soldierHpLabel.setBounds(100, 50, 200, 30);
        soldierHpLabel.setForeground(Color.white);
        bossHpLabel.setBounds(100, 100, 200, 30);
        bossHpLabel.setForeground(Color.white);
        combatPanel.add(soldierHpLabel);
        combatPanel.add(bossHpLabel);

        // Combat Log
        combatLog = new JTextArea(2,1);
        combatLog.setBounds(100, 150, 400, 200);
        combatLog.setEditable(false);
        combatPanel.add(combatLog);

        // Attack
        attackButton = new JButton("Attack");
        attackButton.setBounds(600, 150, 150, 40);
        attackButton.setActionCommand("attack");
        attackButton.addActionListener(ch);
        combatPanel.add(attackButton);

        // Run
        JButton runButton = new JButton("Run");
        runButton.setBounds(600, 200, 150, 40);
        runButton.setActionCommand("run");
        runButton.addActionListener(ch);
        combatPanel.add(runButton);
    }

    public JPanel getCombatPanel() {
        return combatPanel;
    }

    public void updateCombatDisplay(String log, int soldierHp, int bossHp) {
        combatLog.append(log + "\n");
        soldierHpLabel.setText("Soldier HP: " + soldierHp);
        bossHpLabel.setText("Boss HP: " + bossHp);
    }

    public JTextArea getCombatLog() {
        return combatLog;
    }

    public JButton getAttackButton(){
        return attackButton;
    }

    public JLabel getSoldierHpLabel() {
        return soldierHpLabel;
    }

    public JLabel getBossHpLabel() {
        return bossHpLabel;
    }
}

