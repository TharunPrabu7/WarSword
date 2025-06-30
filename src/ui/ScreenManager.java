package ui;

import game.controller.GameController;
import game.Main;
import ui.panels.CombatPanel;
import ui.panels.InventoryPanel;
import ui.panels.MainMenuPanel;
import ui.panels.TownPanel;

import java.util.Map;

public class ScreenManager implements GameUpdateListener {
    private final UI ui;
    private final Main.ChoiceHandler ch;
    private final GameController gc;

    private final MainMenuPanel mainMenuPanel;
    private final TownPanel townPanel;
    private final CombatPanel combatPanel;
    private final InventoryPanel inventoryPanel;

    private boolean isInventoryToggleOn;

    public ScreenManager(UI ui, Main.ChoiceHandler ch) {
        this.ui = ui;
        this.ch = ch;
        this.gc = new GameController(this);

        // create all the panels and add at once
        mainMenuPanel = new MainMenuPanel(ui, ch);
        townPanel = new TownPanel(ui, ch, gc);
        combatPanel = new CombatPanel(ui, ch, gc);
        inventoryPanel = new InventoryPanel(townPanel);

        gc.getCombatManager().setCombatPanel(combatPanel);

        townPanel.getTownPanel().add(inventoryPanel.getInventoryPanel());
        inventoryPanel.getInventoryPanel().setVisible(false);

        ui.getWindow().setLayout(null);
        ui.getWindow().add(mainMenuPanel.getMainMenuPanel());
        ui.getWindow().add(townPanel.getTownPanel());
        ui.getWindow().add(combatPanel.getCombatPanel());
    }

    public void showMainMenu() {
        mainMenuPanel.getMainMenuPanel().setVisible(true);

        townPanel.getTownPanel().setVisible(false);
        combatPanel.getCombatPanel().setVisible(false);
        refresh();
    }

    public void showTown() {
        townPanel.getTownPanel().setVisible(true);

        mainMenuPanel.getMainMenuPanel().setVisible(false);
        combatPanel.getCombatPanel().setVisible(false);
        refresh();
    }

    public void showCombat(){
        combatPanel.getCombatPanel().setVisible(true);

        mainMenuPanel.getMainMenuPanel().setVisible(false);
        townPanel.getTownPanel().setVisible(false);
        refresh();
    }

    public GameController getGameController() {
        return gc;
    }

    @Override
    public void updateSummary(String text) {
        if (townPanel != null) {
            townPanel.updateSummary(text);
        }
    }

    public void toggleInventory(){
        if(!isInventoryToggleOn){
            inventoryPanel.getInventoryPanel().setVisible(true);
            isInventoryToggleOn = true;
        }
        else {
            inventoryPanel.getInventoryPanel().setVisible(false);
            isInventoryToggleOn = false;
        }
    }

    public void updateInventoryDisplay(Map<String, Integer> resourceMap){
        if(inventoryPanel != null)
            inventoryPanel.updateInventory(resourceMap);
    }

    private void refresh() {
        ui.getWindow().revalidate();
        ui.getWindow().repaint();
    }

    public CombatPanel getCombatPanel(){
        return combatPanel;
    }

}
