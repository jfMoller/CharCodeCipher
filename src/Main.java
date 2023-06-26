import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Character> encryptedLetters = new ArrayList<>();
        List<Integer> encryptionKeys = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int menuChoice;

        do {
            clearScreen();
            System.out.println("╔════════════════════════╗");
            System.out.println("║      CharCodeCipher    ║");
            System.out.println("╠════════════════════════╣");
            System.out.println("║ 1. Encrypt text        ║");
            System.out.println("║ 2. Decrypt text        ║");
            System.out.println("║ 3. Exit                ║");
            System.out.println("╚════════════════════════╝");
            System.out.print("Enter your choice: ");
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    clearScreen();
                    System.out.println("You selected Option 1 - Encrypt text");
                    System.out.println("Enter the text to encrypt:");
                    String input = scanner.nextLine();
                    CipherText inputText = new CipherText(input);
                    clearScreen();
                    System.out.println("Encrypted text: " + inputText.encrypt(encryptedLetters, encryptionKeys));
                    System.out.println("Encryption key: " + encryptionKeys);
                    System.out.println("Save the encrypted text and the encryption key if you wish to decrypt the text");
                    break;
                case 2:
                    clearScreen();
                    System.out.println("You selected Option 2 - Decrypt text");
                    System.out.println("Enter the text to decrypt:");
                    String encryptedInput = scanner.nextLine();
                    CipherText encryptedText = new CipherText(encryptedInput);
                    System.out.println("Enter the encryption key:");
                    String encryptionKey = scanner.nextLine();

                    System.out.println("Decrypted text: " + encryptedText.decrypt(encryptedLetters, encryptionKeys));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println(); // Empty line for readability
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
            clearScreen();

        } while (menuChoice != 3);

        scanner.close();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J"); // ANSI escape code to clear the terminal screen
        System.out.flush();
    }
}