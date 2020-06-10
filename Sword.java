package Lab6;

public class Sword extends Ammunition{

    public Sword(String n, int p, double w) {
        super(n, p, w);
    }
    private String name = "Меч";
    public String getInformation(){
        return "Тип "+ name + " "+super.getInformation();
    }
}
