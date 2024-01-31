import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    int base;
    String number;
    char[] hexa;

    String baseTo64 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

    public NumberConverter(String number, int base) {
        String numberAsString = number;
        digits = new int[numberAsString.length()];
        hexa = new char[numberAsString.length()];
        if(base == 16){
            for(int i = 0; i<numberAsString.length(); i++){
                char single = numberAsString.charAt(i);
                hexa[i] = single;
            }
        }
        else{
            for (int i = 0; i < numberAsString.length(); i++) {
                String single = numberAsString.substring(i,i+1);
                int d = Integer.parseInt(single);
                digits[i] = d;
            }
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
    public char[] gethexa(){
        return hexa;
    }


    //converts binary to decimal
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
        int original = Integer.parseInt(number);
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

    //Convert to hexadecimal
    public char[] convertToHexadecimal(){
        int unit = 0;
        if(base == 2){
            for (int digit : digits) {
                unit = unit * 2 + digit;
            }
        }
        else if(base == 8){
            for (int digit : digits) {
                unit = unit * 8 + digit;
            }
        }
        else if(base == 10){
            for (int digit : digits) {
                unit = unit *10 + digit;
            }
        }
        char[] hexadecimal = new char[10];
        int index = hexadecimal.length-1;

        while(unit!=0 && index>=0){
            int remainder = unit%16;
            if(remainder<10){
                hexadecimal[index] = (char) (remainder + '0');
                unit/= 16;
                index--;
            }
            else{
                hexadecimal[index] = (char) (remainder-10 + 'A');
                unit /= 16;
                index--;
            }
        }
        return Arrays.copyOfRange(hexadecimal, index+1, hexadecimal.length);
    }

    //hex to decimal
    public int[] convertHexadecimalToDecimal(){
        int hexadecimalNumber = 0;
        int digitValue = 0;
        for (char digit : hexa) {
            if(Character.isDigit(digit)){
                digitValue = (digit - '0');
            }
            else{
                digitValue = (Character.toUpperCase(digit) - 'A' + 10);
            }
            hexadecimalNumber = hexadecimalNumber * 16 + digitValue;
        }

        int[] decimal = new int[10];
        int index = decimal.length-1;
        while(hexadecimalNumber!=0 && index>=0){
            int remainder = hexadecimalNumber%10;
            decimal[index]= remainder;
            hexadecimalNumber/=10;
            index --;
        }
        return Arrays.copyOfRange(decimal, index+1, decimal.length);

    }
    //hex to binary
    public int[] convertHexadecimalToBinary(){
        int hexadecimalNumber = 0;
        int digitValue = 0;
        for (char digit : hexa) {
            if(Character.isDigit(digit)){
                digitValue = (digit - '0');
            }
            else{
                digitValue = (Character.toUpperCase(digit) - 'A' + 10);
            }
            hexadecimalNumber = hexadecimalNumber * 16 + digitValue;
        }

        int[] binary = new int[10];
        int index = binary.length-1;
        while(hexadecimalNumber!=0 && index>=0){
            int remainder = hexadecimalNumber%2;
            binary[index]= remainder;
            hexadecimalNumber/=2;
            index --;
        }

        return Arrays.copyOfRange(binary, index+1, binary.length);

    }

    //hex to octal
    public int[] convertHexadecimalToOctal(){
        int hexadecimalNumber = 0;
        int digitValue = 0;
        for (char digit : hexa) {
            if(Character.isDigit(digit)){
                digitValue = (digit - '0');
            }
            else{
                digitValue = (Character.toUpperCase(digit) - 'A' + 10);
            }
            hexadecimalNumber = hexadecimalNumber * 16 + digitValue;
        }

        int[] octal = new int[10];
        int index = octal.length-1;
        while(hexadecimalNumber!=0 && index>=0){
            int remainder = hexadecimalNumber%8;
            octal[index]= remainder;
            hexadecimalNumber/=8;
            index --;
        }
        return Arrays.copyOfRange(octal, index+1, octal.length);

    }
    //converts base, takes in base num and follows the program to return the value from 10 to that base
    public String convertBase(int num){
        int total = Integer.parseInt(number);
        String value = "";
        while(total>0){
            int remainder = total%num;
            total/=num;
            for(int i = 0; i<baseTo64.length(); i++){
                if(i == remainder){
                    value = baseTo64.charAt(i) + value;
                }
            }
        }
        return value;
    }
}

