package Lab6;

public class Ammunition {
    private int price;
    private double weight;
    private String name_am;

    public Ammunition (String name, int p , double w){
        name_am=name;
        price=p;
        weight=w;
    }
    public int getPrice(){
        return price;
    }
    public double getWeight(){
        return weight;
    }
    public String getName() {
        return name_am;
    }
    public String getInformation(){
        return "Name:" +name_am+" Price:"+String.valueOf(price)+" Weight:"+String.valueOf(weight);
    }

}

