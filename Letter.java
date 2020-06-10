package Lab5;
// 9121mod3=1
// 9121mod17=11

public class Letter {
    private char data;
    protected String letter;

    public Letter(char sumbol) {
        data = sumbol;
        letter = String.valueOf(sumbol);
    }
    public char getLetter() {
        return data;
    }
    public boolean isVowelLetter() {
        if ((letter.equalsIgnoreCase("a")) | (letter.equalsIgnoreCase("e"))
                | (letter.equalsIgnoreCase("u"))
                | (letter.equalsIgnoreCase("y"))
                | (letter.equalsIgnoreCase("i"))
                | (letter.equalsIgnoreCase("o")))
            return true;
        else
            return false;
    }

}
