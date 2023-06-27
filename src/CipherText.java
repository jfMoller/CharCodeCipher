import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherText {
    private String text;

    public CipherText(String text) {
        this.text = text;
    }

    /**
     * Encrypts the text by modifying the decimal Unicode value of each character.
     * Encryption is performed by adding a random encryption key to the original decimal Unicode value (DCV).
     * For example, the character 'A' has a DCV of 65.
     * If an encryption key with the value 589 is added, the result is 65 + 589 = 654.
     * The new value is then type-casted as char: (char) 654 -> 'ʎ'
     *
     * @return a map containing the encrypted text and the corresponding encryption keys
     */
    public Map<String, String> encrypt() {

        StringBuilder encryptedText = new StringBuilder();
        List<Integer> encryptionKeys = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {

            char letter = text.charAt(i);
            int encryptionKey = getRandomInteger(100, 999);
            encryptionKeys.add(encryptionKey);

            int encryptedIndex = letter + encryptionKey;
            char encryptedLetter = (char) encryptedIndex;
            encryptedText.append(encryptedLetter);
        }

        Map<String, String> encryptedResult = new HashMap<>();
        encryptedResult.put("text", encryptedText.toString());
        encryptedResult.put("keys", formatKeys(encryptionKeys.toString()));
        return encryptedResult;
    }

    /**
     * Decrypts the text using the provided encryption keys.
     *
     * @param keysInput the formatted string of the encryption keys
     * @return the decrypted text
     */
    public String decrypt(String keysInput) {
        if (text.isEmpty() || keysInput.isEmpty()) {
            return "Error: Empty text input";
        }

        List<Integer> encryptionKeys = new ArrayList<>();

        try {
            parseKeys(keysInput, encryptionKeys);
        } catch (NumberFormatException e) {
            return "Error: Incorrect key format";
        }

        if (encryptionKeys.size() != text.length()) {
            return "Error: Mismatched key length";
        }

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char encryptedLetter = text.charAt(i);
            int encryptionKey = encryptionKeys.get(i);

            char decryptedLetter = (char) (encryptedLetter - encryptionKey);
            decryptedText.append(decryptedLetter);
        }
        return decryptedText.toString();
    }

    public String toString() {
        return text;
    }

    public int getRandomInteger(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("Invalid range for getRandomInteger: max must be greater than min");
        }
        return (int) Math.round((Math.random() * (max - min + 1)) + min);
    }

    /**
     * Formats the encryption keys into a single string without brackets and commas.
     *
     * @param keysOutput the string representation of the encryption keys
     * @return the formatted encryption keys string
     */
    public String formatKeys(String keysOutput) {
        return keysOutput.replace("[", "").replace("]", "").replace(", ", "");
    }

    /**
     * Parses the encryption keys from the input string and adds them to the provided list.
     *
     * @param keysInput      the input string containing the encryption keys
     * @param encryptionKeys the list to store the parsed encryption keys
     */
    public void parseKeys(String keysInput, List<Integer> encryptionKeys) {
        String formattedKeysInput = keysInput.replaceAll("[^\\d]", ""); // Remove any non-digit characters
        String[] keysArray = formattedKeysInput.split("(?<=\\G.{3})"); // Creates one index for every three digits
        for (String key : keysArray) {
            encryptionKeys.add(Integer.parseInt(key));
        }
    }
}