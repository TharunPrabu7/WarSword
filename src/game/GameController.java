package game;

import game.combat.CombatManager;
import game.entities.Boss;
import game.entities.Soldier;
import game.resources.*;
import ui.GameUpdateListener;

import java.util.HashMap;
import java.util.Map;

public class GameController {

    // Resources
    private final Mine mine;
    private final Smelter smelt;
    private final Weaponry weapon;
    private final Armory armor;
    private final Farm food;
    private final Barracks soldier;

    private CombatManager combatManager;

    private final GameUpdateListener uiUpdater;

    public GameController(GameUpdateListener uiUpdater) {
        this.mine = new Mine();
        this.smelt = new Smelter();
        this.weapon = new Weaponry();
        this.armor = new Armory();
        this.food = new Farm();
        this.soldier = new Barracks();

        this.uiUpdater = uiUpdater;
    }

    // Mine ore and notify UI
    public void produceOre() {
        mine.produce();
        notifyUpdate();
    }

    public void smeltOre(){
        if(mine.getOre().getQuantity()>0){
            mine.getOre().decrement();
            smelt.getIngot().increment();
        }
        notifyUpdate();
    }

    public void produceWeapon(){
        if(smelt.getIngot().getQuantity()>1){
            weapon.getWeapon().increment();
            smelt.getIngot().decrementByTwo();
        }
        notifyUpdate();
    }

    public void produceArmor(){
        if(smelt.getIngot().getQuantity()>2){
            armor.getArmor().increment();
            smelt.getIngot().decrementByThree();
        }
        notifyUpdate();
    }

    public void produceFood(){
        food.getFood().increment();
        notifyUpdate();
    }

    public void trainSoldier(){
        if(weapon.getWeapon().getQuantity() > 0 && armor.getArmor().getQuantity() > 0 && food.getFood().getQuantity() > 0){
            soldier.getSoldier().increment();
            weapon.getWeapon().decrement();
            armor.getArmor().decrement();
            food.getFood().decrement();
        }
        notifyUpdate();
    }

    public CombatManager getCombatManager(){
        if (combatManager == null){
            Soldier s = new Soldier("Infantry", 10, 10);
            Boss b = new Boss("Goblin", 10, 10);
            combatManager = new CombatManager(s, b);
        }
        return combatManager;
    }

    public void startNewCombat(){
        Soldier s = new Soldier("Infantry", 10, 10);
        Boss b = new Boss("Goblin", 10, 10);
        combatManager = new CombatManager(s, b);
    }

    public Map<String, Integer> getResourceSummary(){
        Map<String, Integer> summary = new HashMap<>();
        summary.put("Ores", mine.getOre().getQuantity());
        summary.put("Ingots", smelt.getIngot().getQuantity());
        summary.put("Weapons", weapon.getWeapon().getQuantity());
        summary.put("Armor", armor.getArmor().getQuantity());
        summary.put("Food", food.getFood().getQuantity());
        summary.put("Soldiers", soldier.getSoldier().getQuantity());
        return summary;
    }

    // Push update to UI
    private void notifyUpdate() {
        uiUpdater.updateSummary("Ore: " + mine.getOre().getQuantity() + " | " +
                "Ingot: " + smelt.getIngot().getQuantity() + " | " +
                "Weapon: " + weapon.getWeapon().getQuantity() + " | " +
                "Armor: " + armor.getArmor().getQuantity() + " | " +
                "Food: " + food.getFood().getQuantity() + " | " +
                "Infantry: " + soldier.getSoldier().getQuantity());
    }

    public int getOreQuantity() {
        return mine.getOre().getQuantity();
    }

    public Resource getOreResource() {
        return mine.getOre();
    }

    public int getIngotQuantity(){
        return smelt.getIngot().getQuantity();
    }

    public Resource getIngotResource(){
        return smelt.getIngot();
    }


    public int getWeaponQuantity(){
        return weapon.getWeapon().getQuantity();
    }

    public Resource getWeaponResource(){
        return weapon.getWeapon();
    }

    public int getArmorQuantity(){
        return armor.getArmor().getQuantity();
    }

    public Resource getArmorResource(){
        return armor.getArmor();
    }

    public int getFoodQuantity(){
        return food.getFood().getQuantity();
    }

    public Resource getFoodResource(){
        return food.getFood();
    }

    public int getSoldierQuantity(){
        return soldier.getSoldier().getQuantity();
    }

    public Resource getSoldierResource(){
        return soldier.getSoldier();
    }



}
