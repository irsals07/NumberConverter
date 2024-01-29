import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Example: Hexadecimal number represented by an array of characters
        char[] hexadecimalArray = {'A', 'C', 'F'}; // Represents the hexadecimal number ACF

        // Call the method to convert hexadecimal to binary
        int[] binaryArray = convertHexadecimalToBinary(hexadecimalArray);

        // Display the result
        System.out.println("Binary representation: " + Arrays.toString(binaryArray));
    }

    // Method to convert hexadecimal to binary using an array of characters
    private static int[] convertHexadecimalToBinary(char[] hexadecimalArray) {
        // Convert the array of hexadecimal characters to a single hexadecimal number
        int hexadecimalNumber = 0;
        for (char digit : hexadecimalArray) {
            int digitValue = Character.isDigit(digit) ? (digit - '0') : (Character.toUpperCase(digit) - 'A' + 10);
            hexadecimalNumber = hexadecimalNumber * 16 + digitValue;
        }

        // Convert hexadecimal to binary
        int[] binaryArray = new int[20]; // Assuming a maximum length for the binary representation
        int index = binaryArray.length - 1;

        while (hexadecimalNumber != 0 && index >= 0) {
            int remainder = hexadecimalNumber % 2;
            binaryArray[index] = remainder;
            hexadecimalNumber /= 2;
            index--;
        }

        // Trim the array to remove leading zeros
        return Arrays.copyOfRange(binaryArray, index + 1, binaryArray.length);
    }
}
