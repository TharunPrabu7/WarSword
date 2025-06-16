package game.resources;

public class Armory {
    private Resource armor;

    public Armory(){
        armor = new Resource("armor");
    }

    public void produceArmor(){
        armor.increment();
    }

    public Resource getArmor(){
        return armor;
    }
}
