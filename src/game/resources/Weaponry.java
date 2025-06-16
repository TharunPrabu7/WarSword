package game.resources;

public class Weaponry {
    private final Resource weapon;

    public Weaponry(){
        weapon = new Resource("weapon");
    }

    public void produceWeapon(){
        weapon.increment();
    }

    public Resource getWeapon(){
        return weapon;
    }
}
