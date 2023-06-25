import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CipherText text = new CipherText("IT SEEMS TO BE WORKING NOW?"); // supports non-spaced capitalized letters

        List<CipherEntry> letters = new ArrayList<>();
        addAlphabet(letters); // adds the English alphabet

        List<Character> encryptedLetters = new ArrayList<>();
        List<Integer> encryptionKeys = new ArrayList<>();

        System.out.println("Input text: " + text);
        System.out.println("Encrypted text: " + text.encrypt(letters, encryptedLetters, encryptionKeys));
        System.out.println("Encryption keys: " + encryptionKeys);
        System.out.println("Decrypted text: " + text.decrypt(encryptedLetters, letters, encryptionKeys));
    }

    public static void addAlphabet(List letters) {
        for (int i = 1; i <= 26; i++) {
            char letter = (char) (i + 64); // ASCII value for "A" = 65
            letters.add(new CipherEntry(String.valueOf(letter), i));
        }
        letters.add(new CipherEntry(" ", 27)); // space
        letters.add(new CipherEntry("?", 28)); // question mark
        letters.add(new CipherEntry("-", 29)); // hyphen
    }
}