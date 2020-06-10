package Lab5;
// 9121mod3=1
// 9121mod17=11
import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private Word[] data;
    private Punktuatoin[] data1;
    private String sentence;

    public Sentence(String sentence_string) {
        sentence_string = new String(sentence_string.trim());
        int word_counter;
        word_counter = 1;
        char sumbol;
        int punkruation_counter = 1;

        for (int i = 0; i < sentence_string.length(); i++) {
            sumbol = sentence_string.charAt(i);
            if (sentence_string.charAt(i) == ' ') {
                word_counter++;
            }
            if ((sumbol == '.') | (sumbol == ',') | (sumbol == '!')
                    | (sumbol == '?') | (sumbol == '/') | (sumbol == ':'))
                punkruation_counter++;

        }

        Word[] word = new Word[word_counter];

        Punktuatoin[] punktuatoin = new Punktuatoin[punkruation_counter];
        word_counter = 0;
        punkruation_counter = 0;

        for (int i = 0; i < sentence_string.length(); i++) {
            sumbol = sentence_string.charAt(i);
            if (((i > 1) & (i < sentence_string.length() - 1))
                    && ((sentence_string.charAt(i - 1) == ' ')
                    & ((sentence_string.charAt(i + 1)) == ' ') & (sentence_string
                    .charAt(i) == '-'))) {
                punktuatoin[punkruation_counter] = new Punktuatoin('-');
                punkruation_counter++;
                sentence_string = new String(sentence_string.replaceFirst(
                        sentence_string.substring(i - 1, i + 1), "".trim()));
            } else if ((sumbol == '.') | (sumbol == ',') | (sumbol == '!')
                    | (sumbol == '?') | (sumbol == ':')) {
                punktuatoin[punkruation_counter] = new Punktuatoin(sumbol);
                punkruation_counter++;
                sentence_string = new String(sentence_string.replaceFirst("\\ "
                        + sentence_string.substring(i, i + 1), "".trim()));

            }
        }
        sentence_string = new String(sentence_string.replace(".", ""));
        String[] l = sentence_string.split(" ");
        for (int i = 0; i < l.length; i++) {
            word[i] = new Word(l[i].trim());
        }

        sentence = sentence_string;
        data = word;
        data1 = punktuatoin;
    }

    public Word[] getWord() {
        return data;
    }

    public Punktuatoin[] getPunktuatoins() {
        return data1;
    }

    public int wordNumber() {
        return data.length;
    }

    public int punktuationNumber() {
        return data1.length;
    }

    public String GetSen() {
        return sentence;
    }

}
