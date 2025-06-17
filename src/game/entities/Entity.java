package game.entities;

public abstract class Entity {
    protected String name;
    protected Stats stats;

    public Entity(String name, int hp, int attack){
        this.name = name;
        this.stats = new Stats(hp, attack);
    }

    public void takeDamage(int damage){
        stats.setHp(stats.getHp() - damage);
    }

    public boolean isAlive(){
        return stats.isAlive();
    }

    public int getHp(){
        return stats.getHp();
    }

    public int attack(){
        return stats.getAttack();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Stats getStats() {
        return stats;
    }
}
