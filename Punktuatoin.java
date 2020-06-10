package Lab5;
// 9121mod3=1
// 9121mod17=11
public class Punktuatoin {
    private char data1;
    protected String symb;

    public Punktuatoin(char sumbol) {
        data1 = sumbol;
        symb = String.valueOf(sumbol);
    }

    public char getPunktuation() {
        return data1;
    }
}
