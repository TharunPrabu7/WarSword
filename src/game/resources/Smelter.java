package game.resources;

public class Smelter {
    private Resource ingot;

    public Smelter(){
        ingot = new Resource("ingot");
    }

    public void produce(){
        ingot.increment();
    }

    public Resource getIngot(){
        return ingot;
    }
}
