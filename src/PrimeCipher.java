import java.util.ArrayList;
import java.util.List;


public class PrimeCipher {
    public static void main(String[] args) {
        String text = "TEST";

        List<CipherEntry> letters = new ArrayList<>();
        //adds the english alphabet from entries
        addCipherLettersTo(letters);

        List<Character> encryptedLetters = new ArrayList<>();
        List<Character> encryptionKeys = new ArrayList<>();

        encryptText(text, letters, encryptedLetters, encryptionKeys);

        System.out.println("Input text: " + text);
        System.out.println("Encrypted text: " + encryptedLetters);
        System.out.println("Encryption keys: " + encryptionKeys);
    }

    public static void addCipherLettersTo(List letters) {
        for (int i = 1; i <= 26; i++) {
            char letter = (char) (i + 64); //ASCII value for "A" = 65
            letters.add(new CipherEntry(String.valueOf(letter), i));
        }
    }

    public static void encryptText(String text, List letters, List encryptedLetters, List encryptionkeys) {

        for (int i = 0; i <= (text.length() - 1); i++) {
            char letter = Character.toUpperCase(text.charAt(i));
            int encryptionKey = getRandomInteger(2, 1000);
            //handles non-letter symbols (no encryption)
            if (!Character.isLetter(letter)) {
                encryptedLetters.add(letter);
                continue;
            } else {
                int index = getIndexFromList(letters, String.valueOf(letter));
                int encryptedIndex = (index + encryptionKey - 1) % letters.size();
                encryptionkeys.add(encryptionKey);

                char encryptedLetter = (char) (encryptedIndex + 65);
                encryptedLetters.add(encryptedLetter);
            }

        }
    }

    public static int getIndexFromList(List<CipherEntry> letters, String targetLetter) {
        for (int i = 0; i < letters.size(); i++) {
            CipherEntry cipherEntry = letters.get(i);
            if (cipherEntry.getLetter().equals(targetLetter)) {
                return i;
            }
        }
        return -1; //if index does not exist in letters
    }

    public static int getRandomInteger(int min, int max) {
        return (int) Math.round((Math.random() * (max - min + 1)) + min);
    }

}
