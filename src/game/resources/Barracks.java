package game.resources;

public class Barracks {
    private Resource soldier;

    public Barracks(){
        soldier = new Resource("soldier");
    }

    public void trainSoldier(){
        soldier.increment();
    }

    public Resource getSoldier(){
        return soldier;
    }
}
