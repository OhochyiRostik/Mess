package Lab6;

import java.util.ArrayList;

public class Chevalier {
    private ArrayList<Ammunition> ammunition;

    public Chevalier(ArrayList<Ammunition> am) {
        ammunition = am;
    }

    public int getPriceAmmunition(){
        int price=0;
        for (Ammunition ammun : ammunition) {
            price += ammun.getPrice();
        }
        return price;
    }

    private void swap(ArrayList<Ammunition> arr, int i, int j) {
        Ammunition t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t);
    }

    public void sortAmmunition(ArrayList<Ammunition> arr){
        for(int i = arr.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr.get(j).getWeight() > arr.get(j+1).getWeight())
                    swap(arr, j, j+1);
            }
        }
    }

    public ArrayList<Ammunition> getAmmunition(){
        return ammunition;
    }
}
