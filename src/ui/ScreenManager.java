package ui;

import game.GameController;
import game.Main;
import ui.panels.InventoryPanel;
import ui.panels.MainMenuPanel;
import ui.panels.TownPanel;

import javax.swing.*;
import java.util.Map;

public class ScreenManager implements GameUpdateListener {
    private final UI ui;
    private final Main.ChoiceHandler ch;

    private JPanel currentPanel;
    private GameController gc;

    private TownPanel townPanel;
    private InventoryPanel inventoryPanel;

    private boolean isInventoryToggleOn;

    public ScreenManager(UI ui, Main.ChoiceHandler ch) {
        this.ui = ui;
        this.ch = ch;
        this.gc = new GameController(this);
    }

    public void showMainMenu() {
        clearPanel();
        MainMenuPanel mainMenuPanel = new MainMenuPanel(ui, ch);
        currentPanel = mainMenuPanel.getMainMenuPanel();
        ui.getWindow().add(currentPanel);
        refresh();
    }

    public void showTown() {
        clearPanel();
        townPanel = new TownPanel(ui, ch, gc);
        currentPanel = townPanel.getTownPanel();

        inventoryPanel = new InventoryPanel(townPanel);
        inventoryPanel.getInventoryPanel().setVisible(false);

        ui.getWindow().add(currentPanel);
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

    private void clearPanel() {
        if (currentPanel != null) {
            ui.getWindow().remove(currentPanel);
            currentPanel = null;
        }

        townPanel = null;
        refresh();
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

}
