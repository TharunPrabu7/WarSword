package ui;

import game.Main;
import ui.panels.MainMenuPanel;
import ui.panels.TownPanel;

public class ScreenManager {
    UI ui;
    Main.choiceHandler ch;

    MainMenuPanel mainMenuPanel;
    TownPanel townPanel;

    public ScreenManager(UI ui, Main.choiceHandler ch){
        this.ui = ui;
        this.ch = ch;
    }

    public void showMainMenu(){
        clearPanels();
        mainMenuPanel = new MainMenuPanel(ui, ch);
    }

    public void showTown(){
        clearPanels();
        townPanel = new TownPanel(ui, ch);
    }

    private void clearPanels(){
        ui.getWindow().getContentPane().removeAll();
        ui.getWindow().revalidate();
        ui.getWindow().repaint();
    }
}
