public class Main {
    public static void main(String[] args) {

        int[] array = {1, 1, 1, 1, 1};
        int decimalValue = 0;
        int[] digits = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            // Calculate the power of 2 for the current position from the right
            int power = array.length - 1 - i;
            // Add the decimal value of the binary digit at the current position
            decimalValue += (int) (digits[i] * Math.pow(2, power));
        }

        System.out.println(decimalValue);

    }
}