package game.resources;

public class Mine{
    private final Resource ore;

    public Mine(){
        ore = new Resource("Ore");
    }

    public void produce(){
        ore.increment();
    }

    public Resource getOre(){return ore;}
}
