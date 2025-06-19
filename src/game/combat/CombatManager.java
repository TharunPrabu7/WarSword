package game.combat;

import game.entities.Boss;
import game.entities.Soldier;
import ui.panels.CombatPanel;

public class CombatManager {
    private final Soldier soldier;
    private final Boss boss;
    private CombatPanel combatPanel;

    public CombatManager(Soldier soldier, Boss boss){
        this.soldier = soldier;
        this.boss = boss;
    }

    public void defaultSetup(){

    }

    public void attackBoss(){
        if (boss.isAlive()){
            int dmg = soldier.attack();
            boss.takeDamage(dmg);
            System.out.println(dmg);
            if (!boss.isAlive()){
                combatPanel.getCombatLog().setText(boss.getName() + " is defeated.");
                combatPanel.getAttackButton().setText("Next Monster");
                updateCombatDisplay(dmg);
            } else
                updateCombatDisplay(dmg);
        }
        else {
            boss.getStats().reset();
            combatPanel.getCombatLog().setText("A new " + boss.getName() + " has appeared!");
            updateCombatDisplay(0);
            combatPanel.getAttackButton().setText("Attack");
        }
    }

    public void updateCombatDisplay(int damage){
        combatPanel.getBossHpLabel().setText("Boss HP: " + boss.getHp());
        combatPanel.getCombatLog().setText(boss.getName() + " has taken " + damage + " damage.\n");
    }

    public Soldier getSoldier(){
        return soldier;
    }

    public Boss getBoss(){
        return boss;
    }

    public void setCombatPanel(CombatPanel combatPanel) {
        this.combatPanel = combatPanel;
    }
}
