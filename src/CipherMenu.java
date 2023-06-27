import java.util.Map;
import java.util.Scanner;

public class CipherMenu {
    private static final int OPTION_ENCRYPT = 1;
    private static final int OPTION_DECRYPT = 2;
    private static final int OPTION_EXIT = 3;

    public void render(Scanner userInput) {

        int menuChoice;
        Map<String, String> encryptionResult = null;

        do {
            displayMenu();
            menuChoice = userInput.nextInt();
            userInput.nextLine();

            switch (menuChoice) {
                case OPTION_ENCRYPT:
                    System.out.println("You selected Option 1 - Encrypt text");
                    System.out.println("Enter the text that you want to encrypt:");
                    String input = userInput.nextLine();

                    while (input.isEmpty()) {
                        System.out.println("Invalid format. Enter at least one character:");
                        input = userInput.nextLine();
                    }

                    CipherText inputText = new CipherText(input);
                    encryptionResult = inputText.encrypt();

                    System.out.println("Encrypted text: " + encryptionResult.get("text"));
                    System.out.println("Encryption keys: " + encryptionResult.get("keys"));
                    System.out.println("Your results will be saved for decryption.");
                    break;
                case OPTION_DECRYPT:
                    System.out.println("You selected Option 2 - Decrypt text");
                    if (encryptionResult != null) {
                        System.out.println("Saved encrypted text: " + encryptionResult.get("text"));
                        System.out.println("Saved encryption keys: " + encryptionResult.get("keys"));
                    }
                    System.out.println("Paste the text to be decrypted:");
                    String encryptedInput = userInput.nextLine();

                    while (encryptedInput.isEmpty()) {
                        System.out.println("Enter at least one character:");
                        encryptedInput = userInput.nextLine();
                    }

                    CipherText encryptedText = new CipherText(encryptedInput);
                    System.out.println("Paste the encryption keys:");
                    String keys = userInput.nextLine();

                    while (keys.isEmpty()) {
                        System.out.println("Invalid format, try again:");
                        keys = userInput.nextLine();
                    }

                    System.out.println("Decrypted text: " + encryptedText.decrypt(keys));
                    break;
                case OPTION_EXIT:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
            System.out.print("Press Enter to continue...");
            userInput.nextLine();

        } while (menuChoice != OPTION_EXIT);

        userInput.close();
    }

    private void displayMenu() {
        System.out.println("╔════════════════════════╗");
        System.out.println("║      CharCodeCipher    ║");
        System.out.println("╠════════════════════════╣");
        System.out.println("║ 1. Encrypt text        ║");
        System.out.println("║ 2. Decrypt text        ║");
        System.out.println("║ 3. Exit                ║");
        System.out.println("╚════════════════════════╝");
        System.out.print("Enter your choice: ");
    }


}
