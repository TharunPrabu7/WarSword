package game.controller;

import game.entities.Boss;
import game.entities.Soldier;
import ui.panels.CombatPanel;

public class CombatController {
    private final Soldier soldier;
    private final Boss boss;
    private CombatPanel combatPanel;

    public CombatController(Soldier soldier, Boss boss){
        this.soldier = soldier;
        this.boss = boss;
    }

    public void attackBoss(){
        if (boss.isAlive() && soldier.isAlive()){
            int dmg = soldier.attack();
            int returnDmg = boss.attack();
            boss.takeDamage(dmg);
            soldier.takeDamage(returnDmg);
            if (!boss.isAlive()){
                combatPanel.getCombatLog().setText(boss.getName() + " is defeated.");
                combatPanel.getAttackButton().setText("Next Monster");
                updateCombatDisplay(dmg, returnDmg);
            } else if (!soldier.isAlive()){
                combatPanel.getCombatLog().setText(soldier.getName() + " is defeated.");
                combatPanel.getAttackButton().setText("Return");
                updateCombatDisplay(dmg, returnDmg);
            } else if (!soldier.isAlive() && !boss.isAlive()) {
                combatPanel.getCombatLog().setText("Both are dead.");
                updateCombatDisplay(dmg, returnDmg);
            } else
                updateCombatDisplay(dmg, returnDmg);
        }
        else {
            boss.getStats().reset();
            combatPanel.getCombatLog().setText("A new " + boss.getName() + " has appeared!");
            updateCombatDisplay(0, 0);
            combatPanel.getAttackButton().setText("Attack");
        }
    }

    public void updateCombatDisplay(int damage, int returnDamage){
        combatPanel.getBossHpLabel().setText("Boss HP: " + boss.getHp());
        combatPanel.getSoldierHpLabel().setText("Soldier HP: " + soldier.getHp());
        combatPanel.getCombatLog().setText(boss.getName() + " has taken " + damage + " damage.\n" +
                soldier.getName() + " has taken " + returnDamage + " damage.\n");
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
