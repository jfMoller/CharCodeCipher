import java.util.ArrayList;
import java.util.List;

public class Cipher {
    public static void main(String[] args) {
        CipherText text = new CipherText("THISISAMESSAGE");

        List<CipherEntry> letters = new ArrayList<>();
        // adds the English alphabet from entries
        addCipherLettersTo(letters);

        List<Character> encryptedLetters = new ArrayList<>();
        List<Integer> encryptionKeys = new ArrayList<>();

        String encryptedText = text.encrypt(letters, encryptedLetters, encryptionKeys);

        System.out.println("Input text: " + text);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Encryption keys: " + encryptionKeys);

        String decryptedText = text.decrypt(encryptedLetters, letters, encryptionKeys);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public static void addCipherLettersTo(List<CipherEntry> letters) {
        for (int i = 1; i <= 26; i++) {
            char letter = (char) (i + 64); // ASCII value for "A" = 65
            letters.add(new CipherEntry(String.valueOf(letter), i));
        }
    }
}