public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int decimalValue = 0;
        int arrayLength = digits.length;
        if(base == 2){
            for (int i = 0; i < arrayLength; i++) {
                // Calculate the power of 2 for the current position from the right
                int power = arrayLength - 1 - i;
                // Add the decimal value of the binary digit at the current position
                decimalValue += (int) (digits[i] * Math.pow(2, power));
            }

        }
        return new int[]{decimalValue};
    }

    public int[] convertToBinary() {
        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}

