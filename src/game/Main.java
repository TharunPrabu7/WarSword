package game;

import game.controller.CombatController;
import ui.ScreenManager;
import ui.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private ScreenManager sm;
    private CombatController cm;

    public static void main(String[] args) {
        new Main().startGame();
    }

    public void startGame(){
        UI ui = new UI();
        ui.createUI();

        sm = new ScreenManager(ui, new ChoiceHandler());
        sm.showMainMenu();

        cm = sm.getGameController().getCombatManager();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String choice = event.getActionCommand();
            switch (choice) {
                case "start", "run":
                    sm.showTown();
                    break;
                case "mainMenu":
                    sm.showMainMenu();
                    break;
                case "mine":
                    sm.getGameController().produceOre();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "smelt":
                    sm.getGameController().smeltOre();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "makeWeapon":
                    sm.getGameController().produceWeapon();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "makeArmor":
                    sm.getGameController().produceArmor();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "makeFood":
                    sm.getGameController().produceFood();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "trainSoldier":
                    sm.getGameController().trainSoldier();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "inventory":
                    sm.toggleInventory();
                    sm.updateInventoryDisplay(sm.getGameController().getResourceSummary());
                    break;
                case "fightBoss":
                    sm.showCombat();
                    break;
                case "attack":
                    cm.attackBoss();
                    break;
            }
        }
    }
}
