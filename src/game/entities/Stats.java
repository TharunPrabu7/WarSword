package game.entities;

import java.util.Random;

public class Stats {
    private int attack;
    private int hp;
    private int defaultHp;

    public Stats(int hp, int attack){
        this.hp = hp;
        this.defaultHp = hp;
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void reset(){
        this.hp = defaultHp;
    }

    public boolean isAlive(){
        return hp>0;
    }

}
