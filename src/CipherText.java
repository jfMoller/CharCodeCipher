import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherText {
    private String text;

    public CipherText(String text) {
        this.text = text;
    }

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
        String formattedKeys = formatKeys(encryptionKeys.toString());
        encryptedResult.put("keys", formattedKeys);
        return encryptedResult;
    }

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

    public String formatKeys(String keysOutput) {
        return keysOutput.replace("[", "").replace("]", "").replace(", ", "");
    }

    public void parseKeys(String keysInput, List<Integer> encryptionKeys) {
        String formattedKeysInput = keysInput.replaceAll("[^\\d]", ""); // Remove any non-digit characters
        String[] keysArray = formattedKeysInput.split("(?<=\\G.{3})");
        for (String key : keysArray) {
            encryptionKeys.add(Integer.parseInt(key));
        }
    }
}