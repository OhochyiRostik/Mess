package Lab5;
// 9121mod3=1
// 9121mod17=11
import java.util.ArrayList;
import java.util.List;

class Text {
    private Sentence[] data;
    private String text;
    private String allText;

    Text(String atext) {
        allText = atext;
        text = atext;
        char sumbol;
        int k = 0;
        int i;
        int j = 0;
        text = tab(text);
        for (j = 0; j < text.length(); j++) {
            sumbol = text.charAt(j);
            if (sumbol == '.') {
                if ((j > 1)
                        && (j < text.length() - 1)
                        && ((text.charAt(j + 1) == '.') && (text.charAt(j + 2) == '.'))) {
                    k++;
                    j++;
                    j++;
                } else {

                    k++;
                }
            } else if ((sumbol == '?') | (sumbol == '!')) {

                k++;
            }
        }

        Sentence[] sentenses = new Sentence[k];
        i = 0;
        int l = -1;

        for (j = 0; j < text.length(); j++) {
            sumbol = text.charAt(j);

            if (sumbol == '.') {
                if ((j > 1)
                        && (j < text.length() - 1)
                        && ((text.charAt(j + 1) == '.') && (text.charAt(j + 2) == '.'))) {
                    l++;
                    sentenses[l] = new Sentence(text.substring(i, j + 3));
                    i = j + 3;
                    j++;
                    j++;
                } else {
                    l++;
                    sentenses[l] = new Sentence(text.substring(i, j + 1));
                    i = j + 2;
                }
            } else if ((sumbol == '?') | (sumbol == '!')) {
                l++;
                sentenses[l] = new Sentence(text.substring(i, j + 1));
                i = j + 2;

            }

        }
        data = sentenses;
    }

    private String tab(String str) {
        StringBuffer x = new StringBuffer(str);
        for (int i = 0; i < x.length(); i++) {

            if (x.charAt(i) == ' ') {
                do
                    if (x.charAt(i + 1) == ' ')
                        x.deleteCharAt(i);
                while ((x.charAt(i + 1) == ' '));
            }

        }

        str = new String(x);
        return str;
    }

    public String getSentences(int i) {
        return data[i].GetSen();
    }

    public int sentenceNumber() {
        return data.length;
    }

    public String getText() {
        return allText;
    }

}