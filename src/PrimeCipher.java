import java.util.ArrayList;
import java.util.List;


public class PrimeCipher {
    public static void main(String[] args) {
        List<CipherEntry> letters = new ArrayList<>();
        addAlphabet(letters);



    }
public static void addAlphabet(List letters) {
    for (int i = 1; i <= 26; i++) {
        char letter = (char) (i + 64); //ASCII value for "A" = 65
        letters.add(new CipherEntry(String.valueOf(letter), i));
    }
}
}
