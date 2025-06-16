package game;

import ui.ScreenManager;
import ui.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private UI ui;
    private ScreenManager sm;

    public static void main(String[] args) {
        new Main().startGame();
    }

    public void startGame(){
        ui = new UI();
        ui.createUI();

        sm = new ScreenManager(ui, new ChoiceHandler());
        sm.showMainMenu();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String choice = event.getActionCommand();
            switch (choice) {
                case "start":
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
            }
        }
    }
}
