import java.util.List;

public class CipherText {
    private String text;

    public CipherText(String text) {
        this.text = text;
    }

    public String encrypt(List<CipherEntry> letters, List<Character> encryptedLetters, List<Integer> encryptionKeys) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i <= (text.length() - 1); i++) {
            char letter = Character.toUpperCase(text.charAt(i));
            int encryptionKey = getRandomInteger(2, 1000);

            // handles non-letter symbols (no encryption)
            if (!Character.isLetter(letter)) {
                encryptedLetters.add(letter);
                continue;
            } else {
                int index = getIndexFromList(letters, String.valueOf(letter));
                int encryptedIndex = (index + encryptionKey);
                encryptionKeys.add(encryptionKey);
                char encryptedLetter = (char) (encryptedIndex + 65);
                encryptedLetters.add(encryptedLetter);
                encryptedText.append(encryptedLetter);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(List<Character> encryptedLetters, List<CipherEntry> letters, List<Integer> encryptionKeys) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedLetters.size(); i++) {
            char encryptedLetter = encryptedLetters.get(i);
            int encryptionKey = encryptionKeys.get(i);


            char decryptedLetter = (char) (encryptedLetter - encryptionKey);
            decryptedText.append(decryptedLetter);

        }

        return decryptedText.toString();
    }


    public int getIndexFromList(List<CipherEntry> letters, String targetLetter) {
        for (int i = 0; i < letters.size(); i++) {
            CipherEntry cipherEntry = letters.get(i);
            if (cipherEntry.getLetter().equals(targetLetter)) {
                return i;
            }
        }
        return -1; // if index does not exist in letters
    }

    public int getRandomInteger(int min, int max) {
        return (int) Math.round((Math.random() * (max - min + 1)) + min);
    }
}
