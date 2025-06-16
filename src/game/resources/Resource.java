package game.resources;

public class Resource {
    private final String name;
    private int quantity;

    public Resource(String name){
        this.name = name;
        this.quantity = 0;
    }

    public String getName(){return name;}

    public int getQuantity(){return quantity;}

    public void increment(){quantity++;}

    public void decrement(){quantity--;}

    public void decrementByTwo(){quantity -= 2;}

    public void decrementByThree(){quantity -= 3;}

    public void add(int amount){quantity+=amount;}
}
