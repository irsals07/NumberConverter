import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Example: Decimal number represented by an array of digits
        int[] decimalArray = {1, 4, 10, 14}; // Represents the decimal number 1410

        // Call the method to convert decimal to hexadecimal
        char[] hexadecimalArray = convertDecimalToHexadecimal(decimalArray);

        // Display the result
        System.out.println("Hexadecimal representation: " + Arrays.toString(hexadecimalArray));
    }

    // Method to convert decimal to hexadecimal using an array of digits
    private static char[] convertDecimalToHexadecimal(int[] decimalArray) {
        // Convert the array of decimal digits to a single decimal number
        int decimalNumber = 0;
        for (int digit : decimalArray) {
            decimalNumber = decimalNumber * 10 + digit;
        }

        // Convert decimal to hexadecimal
        char[] hexadecimalArray = new char[10]; // Assuming a maximum length for the hexadecimal representation
        int index = hexadecimalArray.length - 1;

        while (decimalNumber != 0 && index >= 0) {
            int remainder = decimalNumber % 16;
            hexadecimalArray[index] = (remainder < 10) ? (char) (remainder + '0') : (char) (remainder - 10 + 'A');
            decimalNumber /= 16;
            index--;
        }

        // Trim the array to remove leading zeros
        return Arrays.copyOfRange(hexadecimalArray, index + 1, hexadecimalArray.length);
    }
}
