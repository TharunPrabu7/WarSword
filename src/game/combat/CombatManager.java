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
            boss.takeDamage(soldier.attack());
            soldier.takeDamage(boss.attack());
            if (!boss.isAlive()){
                combatPanel.getCombatLog().setText(boss.getName() + " is defeated.");
                combatPanel.getAttackButton().setText("Next Monster");
                updateCombatDisplay();
            } else if (!soldier.isAlive()) {
                combatPanel.getCombatLog().setText(soldier.getName() + " is dead.");
                combatPanel.getAttackButton().setText("Retry");
                soldier.getStats().reset();
                updateCombatDisplay();
            } else
                updateCombatDisplay();
        }
        else {
            boss.getStats().reset();
            updateCombatDisplay();
            combatPanel.getAttackButton().setText("Attack");
        }
    }

    public void updateCombatDisplay(){
        combatPanel.getBossHpLabel().setText("Boss HP: " + boss.getHp());
        combatPanel.getSoldierHpLabel().setText("Soldier HP " + soldier.getHp());

        combatPanel.getCombatLog().setText(boss.getName() + " has taken " + soldier.attack() + " damage.\n" +
                soldier.getName() + " has taken " + boss.attack() + " damage.");
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
