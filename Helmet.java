package Lab6;

public class Helmet extends Ammunition {

    public Helmet(String n, int p, double w) {
        super(n, p, w);
    }
    private String name = "Шолом";
    public String getInformation(){
        return "Тип "+ name + " "+super.getInformation();
    }
}
