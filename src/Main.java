import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Example: Octal number represented by an array of digits
        int[] octalArray = {3, 5, 2}; // Represents the octal number 352

        // Call the method to convert octal to binary
        int[] binaryArray = convertOctalToBinary(octalArray);

        // Display the result
        System.out.println("Binary representation: " + Arrays.toString(binaryArray));
    }

    // Method to convert octal to binary using an array of digits
    private static int[] convertOctalToBinary(int[] octalArray) {
        // Convert the array of octal digits to a single octal number
        int octalNumber = 0;
        for (int digit : octalArray) {
            octalNumber = octalNumber * 8 + digit;
        }

        // Convert octal to binary
        int[] binaryArray = new int[20]; // Assuming a maximum length for the binary representation
        int index = binaryArray.length - 1;

        while (octalNumber != 0 && index >= 0) {
            int remainder = octalNumber % 2;
            binaryArray[index] = remainder;
            octalNumber /= 2;
            index--;
        }

        // Trim the array to remove leading zeros
        return Arrays.copyOfRange(binaryArray, index + 1, binaryArray.length);
    }
}
