package Lab6;

public class Shield extends Ammunition {
    public Shield(String n, int p, double w) {
        super(n, p, w);
    }

    private String name = "Щит";

    public String getInformation(){
        return "Тип "+ name + " "+super.getInformation();
    }
}
