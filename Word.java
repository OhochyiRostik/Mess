package Lab5;
// 9121mod3=1
// 9121mod17=11
public class Word {
    private Letter[] data;
    private String word;

    public Word(String word_string) {
        word = word_string;
        Letter[] letters_word = new Letter[word_string.length()];
        for (int i = 0; i < word_string.length(); i++) {
            letters_word[i] = new Letter(word_string.charAt(i));
        }
        data = letters_word;
    }

    public String getWord() {
        return word;
    }

    public int find() {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].isVowelLetter())
                counter++;
        }
        return counter;
    }
}
