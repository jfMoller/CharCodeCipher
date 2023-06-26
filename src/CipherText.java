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
            int encryptionKey = getRandomInteger(2, 1000);
            encryptionKeys.add(encryptionKey);

            int encryptedIndex = letter + encryptionKey;
            char encryptedLetter = (char) encryptedIndex;
            encryptedText.append(encryptedLetter);
        }

        Map<String, String> result = new HashMap<>();
        result.put("text", encryptedText.toString());
        result.put("keys", encryptionKeys.toString());
        return result;
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

    public String getText() {
        return text;
    }

    public String toString() {
        return text;
    }

    public int getRandomInteger(int min, int max) {
        return (int) Math.round((Math.random() * (max - min + 1)) + min);
    }

    public void parseKeys(String keysInput, List<Integer> encryptionKeys) {
        String[] keysArray = keysInput.replace("[", "").replace("]", "").split(", ");
        for (String key : keysArray) {
            encryptionKeys.add(Integer.parseInt(key));
        }
    }
}