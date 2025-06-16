package game;

import ui.ScreenManager;
import ui.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    UI ui;
    ScreenManager sm;

    public static void main(String[] args) {
        new Main().startGame();
    }

    public void startGame(){
        ui = new UI();
        ui.createUI();

        sm = new ScreenManager(ui, new choiceHandler());
        sm.showMainMenu();

    }

    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String choice = event.getActionCommand();
            switch (choice){
                case "start": sm.showTown(); break;
                case "mainmenu": sm.showMainMenu(); break;
            }
        }
    }
}