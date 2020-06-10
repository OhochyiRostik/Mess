package Lab6;

public class Armor extends Ammunition {
    public Armor(String n, int p, double w) {
        super(n, p, w);
    }
    private String name = "Кольчуга";
    public String getInformation(){
        return "Тип "+ name + " "+super.getInformation();
    }
}
