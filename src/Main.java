import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Handles terminal user menu
        Scanner userInput = new Scanner(System.in);
        new CipherMenu().render(userInput);
    }
}