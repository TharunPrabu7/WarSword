package game.resources;

public class Farm {
    private Resource food;

    public Farm(){
        food = new Resource("fod");
    }

    public void produceFood(){
        food.increment();
    }

    public Resource getFood(){
        return food;
    }
}
