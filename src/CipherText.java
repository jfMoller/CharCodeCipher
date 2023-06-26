import java.util.List;

public class CipherText {
    private String text;

    public CipherText(String text) {
        this.text = text;
    }

    public String encrypt(List<Character> encryptedLetters, List<Integer> encryptionKeys) {

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i <= (text.length() - 1); i++) {

            char letter = text.charAt(i);
            int encryptionKey = getRandomInteger(2, 1000);
            encryptionKeys.add(encryptionKey);

            int encryptedIndex = ((int) letter + encryptionKey);
            char encryptedLetter = (char) (encryptedIndex);
            encryptedLetters.add(encryptedLetter);
            encryptedText.append(encryptedLetter);

        }
        return encryptedText.toString();
    }

    public static String decrypt(List<Character> encryptedLetters, List<Integer> encryptionKeys) {

        if (encryptionKeys.size() == 0) {
            String error = "Error, no encryption keys";
            return error;
        }

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedLetters.size(); i++) {
            char encryptedLetter = encryptedLetters.get(i);
            int encryptionKey = encryptionKeys.get(i);

            char decryptedLetter = (char) (encryptedLetter - encryptionKey);
            decryptedText.append(decryptedLetter);
        }
        return decryptedText.toString();
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return text;
    }

    public int getRandomInteger(int min, int max) {
        return (int) Math.round((Math.random() * (max - min + 1)) + min);
    }
}
