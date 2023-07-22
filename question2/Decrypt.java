
/*
 * date     03/02/2023
 * lecturer     Mr Chibuluma
 * 
 * This is question 2 of lab 2 solution.
 * The program requests the user for a 4 integer 
 * key and provides an decrypted value of the key.
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
 * 
 * This class decrypts the provides input
 */

public class Decrypt {
    private String decrypted;
    private ArrayList<Integer> bucket = new ArrayList<Integer>(); // Temporary storage values of the key to decrypt

    public Decrypt() {
        this("0000");
    }

    public Decrypt(String decrypted) {
        this.decrypted = decrypted;
    }

    // returns the decrypted key
    String getKey() {
        return this.decrypted;
    }

    // updates the encrypted value from the bucket by concatination
    private void setDecryption() {
        this.decrypted = "";// empty the decrypted string
        for (int index = 0; index < 4; index++) {
            this.decrypted += this.bucket.get(index);
        }
    }

    // decrypt user key provided
    public void decrypt(String userKey) {
        // validate the key to only have 4 values and must only have integers
        if (isValid(userKey)) {

            // swap the values to orignal positions
            // Reverse the numbers to get the actual key entered by the user
            for (int index = 0; index < userKey.length(); index++) {
                int number = Character.getNumericValue(userKey.charAt(index));

                // test 0 for the answer
                if (number >= 7) {
                    // then just subtract 7
                    number -= 7;
                    this.bucket.add(number);
                } else {
                    // add 10 then subtract 7
                    number += 10;
                    number -= 7;
                    this.bucket.add(number);
                }

            }
            swapBucket();
            setDecryption();

        } else
            return;

    }

    // validate user input/key
    private static boolean isValid(String userInput) {
        if (userInput.length() == 4) {
            // Ensure that only integer values are in the input
            if (userInput.matches("[0-9]+")) {
                return true;
            }
        }
        return false;
    }

    // swap the contents to there original positions
    private void swapBucket() {
        ArrayList<Integer> simpleBuffer = new ArrayList<Integer>();
        simpleBuffer = this.bucket;

        // perform a reverse swap from the encrytion algorithm
        for (int index = 0; index < 4; index++) {
            int num = 0;
            switch (index) {
                case 0:
                    num = simpleBuffer.get(0);
                    simpleBuffer.set(0, simpleBuffer.get(2));
                    simpleBuffer.set(2, num);
                    break;
                case 1:
                    num = simpleBuffer.get(1);
                    simpleBuffer.set(1, simpleBuffer.get(3));
                    simpleBuffer.set(3, num);
                    break;
                default:
                    return;
            }
        }
        this.bucket = simpleBuffer;
    }
}