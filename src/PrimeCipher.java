import java.util.ArrayList;
import java.util.List;

public class PrimeCipher {
    public static void main(String[] args) {
        String text = "TESTINGALGO";

        List<CipherEntry> letters = new ArrayList<>();
        // adds the English alphabet from entries
        addCipherLettersTo(letters);

        List<Character> encryptedLetters = new ArrayList<>();
        List<Integer> encryptionKeys = new ArrayList<>();

        encryptText(text, letters, encryptedLetters, encryptionKeys);

        System.out.println("Input text: " + text);
        System.out.println("Encrypted text: " + encryptedLetters);
        System.out.println("Encryption keys: " + encryptionKeys);

        String decryptedText = decryptText(encryptedLetters, letters, encryptionKeys);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public static void addCipherLettersTo(List<CipherEntry> letters) {
        for (int i = 1; i <= 26; i++) {
            char letter = (char) (i + 64); // ASCII value for "A" = 65
            letters.add(new CipherEntry(String.valueOf(letter), i));
        }
    }

    public static void encryptText(String text, List<CipherEntry> letters, List<Character> encryptedLetters, List<Integer> encryptionKeys) {

        for (int i = 0; i <= (text.length() - 1); i++) {
            char letter = Character.toUpperCase(text.charAt(i));
            int encryptionKey = getRandomInteger(2, 1000);
            // handles non-letter symbols (no encryption)
            if (!Character.isLetter(letter)) {
                encryptedLetters.add(letter);
                continue;
            } else {
                int index = getIndexFromList(letters, String.valueOf(letter));
                int encryptedIndex = (index + encryptionKey - 1) % letters.size();
                encryptionKeys.add(encryptedIndex);
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
        return -1; // if index does not exist in letters
    }

    public static int getRandomInteger(int min, int max) {
        return (int) Math.round((Math.random() * (max - min + 1)) + min);
    }

    public static String decryptText(List<Character> encryptedLetters, List<CipherEntry> letters, List<Integer> encryptionKeys) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedLetters.size(); i++) {
            char encryptedLetter = encryptedLetters.get(i);
            int encryptionKey = encryptionKeys.get(i);

            // Handles non-letter symbols (no decryption)
            if (!Character.isLetter(encryptedLetter)) {
                decryptedText.append(encryptedLetter);
                continue;
            } else {
                int encryptedIndex = encryptedLetter - 65;
                int originalIndex = (encryptedIndex - encryptionKey + letters.size()) % letters.size();
                String originalLetter = letters.get(originalIndex).getLetter();
                decryptedText.append(originalLetter);
            }
        }

        return decryptedText.toString();
    }
}