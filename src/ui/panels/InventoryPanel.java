package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryPanel {
    private final TownPanel townPanel;

    private JPanel inventoryPanel;
    private JLabel inventoryLabel;
    private Map<String, JLabel> resourceLabels;

    public InventoryPanel(TownPanel townPanel){
        this.townPanel = townPanel;
        createInventoryPanel();
    }

    public void createInventoryPanel(){
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
        inventoryPanel.setBounds(900, 100, 300,300);
        inventoryPanel.setBackground(Color.white);

        resourceLabels = new HashMap<>();

        String[] resources = {"Ores", "Ingots", "Weapons", "Armor", "Food", "Soldiers"};
        for(String resource : resources){
            JLabel label = new JLabel(resource + ": 0");
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            inventoryPanel.add(label);
            resourceLabels.put(resource, label);
        }

        townPanel.getTownPanel().add(inventoryPanel);
    }

    public void updateInventory(Map<String, Integer> resources){
        for(Map.Entry<String, Integer> entry : resources.entrySet()){
            JLabel label = resourceLabels.get(entry.getKey());
            if(label != null){
                label.setText(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public JPanel getInventoryPanel(){
        return inventoryPanel;
    }
}
