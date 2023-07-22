
/*
 * date     03/02/2023
 * lecturer     Mr Chibuluma
 * 
 * This is question 2 of lab 2 solution.
 * The program requests the user for a 5 integer 
 * key and provides an encrypted value of the key.
 */
import java.util.*;

/*
 * @author      Gilbert Ng'andu
 * @SIN         20153347
 * 
 * The class structures the encryption process as follows:
 * Replace each digit with the result of adding 7 to the digit
 * and getting the remainder after dividing the new value by 10.
 * Then swap the first digit with the third,
 * and swap the second digit with the fourth
 */
public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("\nWelcome to cryptography");

        try {
            System.out.print("\n1. Encrypt\n2. Decrypt\nchoice:");
            choice = input.nextInt();
            menu(choice);
        } catch (Exception e) {
            System.out.println("The input you entered is invalid");
            System.out.print("Your input was invalid again, try again later.");
        }

        input.close();
    }

    // Encrypt if user choice is to encrypt
    public static void encrypt() {
        Encrypt myKey = new Encrypt();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter key to encrypt - max 4 digits(e.g 1234): ");
        myKey.encrypt(input.nextLine());

        System.out.printf("%nEncrypted key: %s%n", myKey.getEncrypted());

        input.close();
    }

    // performs the decryption process
    public static void decrypt() {
        Decrypt retrieve = new Decrypt();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter key to decrypt - max 4 digits(e.g 1234): ");
        retrieve.decrypt(input.nextLine());

        System.out.printf("%nDecrypted key: %s%n", retrieve.getKey());

        input.close();
    }

    // menu selection
    public static void menu(int choice) {
        switch (choice) {
            case 1:
                // encrypt
                encrypt();
                break;
            case 2:
                // decrypt
                decrypt();
                break;
            case 3:
                System.out.print("Goodbye :(");
                break;
            default:
                System.out.println("Please select a valid input.");
                break;
        }
    }
}
