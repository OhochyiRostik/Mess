package Lab5;
// 9121mod3=1
// 9121mod17=11
public class Main {
    public static void main(String[] args) {
        String text = "London is the capital of Great Britain.";
        if ((text.substring(0).trim().equals(""))) {
            System.out.println("no text");
        } else {
            Text txt = new Text(text);
            System.out.println(txt.getText());
            System.out.println();
            Sentence s;
            int count_vowel_letter;
            int max_word_vowel_letter = 0;
            for (int i = 0; i < txt.sentenceNumber(); i++) {
                s = new Sentence(txt.getSentences(i));
                for (int j = 0; j < s.getWord().length; j++) {
                    count_vowel_letter = s.getWord()[j].find();
                    if (max_word_vowel_letter < count_vowel_letter)
                        max_word_vowel_letter = count_vowel_letter;
                }
            }
            for (int k = 0; k <= max_word_vowel_letter; k++) {
                for (int i = 0; i < txt.sentenceNumber(); i++) {
                    s = new Sentence(txt.getSentences(i));
                    for (int j = 0; j < s.getWord().length; j++) {
                        if ((k == s.getWord()[j].find())) {
                            System.out.print(s.getWord()[j].getWord().trim());
                            System.out.print(" ");
                        }
                    }
                }
            }
        }
    }
}

