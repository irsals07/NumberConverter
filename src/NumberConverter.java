import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    int base;
    int number;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        this.number = number;
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

    public int[] convertBinaryToDecimal() {
        int[] values = new int[digits.length];
        int exponent = 0;
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i] == 1){
                values[i] = (int) Math.pow(2, exponent);
            }
            else{
                values[i] = 0;
            }
            exponent++;
        }
        return values;
    }
    public int[] convertOctalToDecimal(){
        int[] values = new int[digits.length];
        int exponent = digits.length-1;
        for(int i = 0; i< digits.length; i++){
            values[i] = (int) (digits[i]*Math.pow(8, exponent));
            exponent--;
        }
        return values;
    }


    public int[] convertDecimalToBinary() {
        int original = number;
        int counter = 0;
        for(int i = original; i>0; counter++){
            i = i/2;
        }
        int[] values = new int[counter];
        values[0] = 1;
        for(int i = values.length-1; i>0; i--){
            values[i] = original%2;
            original = original/2;
        }
        return values;

    }
    public int[] convertOctalToBinary(){
        int octal = 0;
        for (int digit : digits) {
            octal = octal * 8 + digit;
        }

        // Convert octal to binary
        int[] binary = new int[20]; // Assuming a maximum length for the binary representation
        int index = binary.length - 1;

        while (octal != 0 && index >= 0) {
            int remainder = octal % 2;
            binary[index] = remainder;
            octal /= 2;
            index--;
        }

        // Trim the array to remove leading zeros
        return Arrays.copyOfRange(binary, index + 1, binary.length);
    }

    public int[] convertDecimalToOctal() {
        int decimal = 0;
        for(int digit:digits){
            decimal = decimal*10+digit;
        }
        int[] octal = new int[10];
        int index = octal.length-1;

        while (decimal != 0 && index>=0){
            int remain = decimal%8;
            octal[index] = remain;
            decimal/=8;
            index--;
        }

        //copy of range removes the leading zeroes;
        return Arrays.copyOfRange(octal, index+1, octal.length);
    }
    public int[] convertBinaryToOctal(){
        //converts array of binary to a single binary number
        int binary = 0;
        for(int digit:digits){
            binary = binary*2+digit;
        }
        int[] octal = new int[10];
        int index = octal.length-1;

        while(binary!=0 && index>=0){
            int remainder = binary % 8;
            octal[index] = remainder;
            binary /= 8;
            index--;
        }
        return Arrays.copyOfRange(octal, index+1, octal.length);
    }
}

