import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        // When base is 2
        if(base == 2){
            boolean valid = true;
            for (int digit : digits) {
                if (digit != 1 && digit != 0) {
                    valid = false;
                }
            }
           if(valid){
               int sum = 0;
               for(int i = 0; i<nc.convertBinaryToDecimal().length; i++){
                   sum+=nc.convertBinaryToDecimal()[i];
               }
               System.out.println("Decimal number: " + sum);
               String octal = "";
               for(int k = 0; k<nc.convertBinaryToOctal().length; k++){
                   octal = octal+nc.convertBinaryToOctal()[k];
               }
               System.out.println("Octal Number: " + octal);
           }
           else{
               System.out.println("this number is not valid");
           }
        }
        //when base is 10
        else if(base == 10){
            String binary = "";
            for(int i = 0; i<nc.convertDecimalToBinary().length; i++){
                binary = binary+nc.convertDecimalToBinary()[i];
            }
            System.out.println("Binary number: "+binary);
            String octal = "";
            for(int k = 0; k<nc.convertDecimalToOctal().length; k++){
                octal = octal+nc.convertDecimalToOctal()[k];
            }
            System.out.println("Octal Number: " +octal);
        }
        //when base is 8
        else if(base == 8){
            int sum = 0;
            for(int i = 0; i<nc.convertOctalToDecimal().length; i++){
                sum += nc.convertOctalToDecimal()[i];
            }
            System.out.println("Decimal Number: " + sum);
            String binary = "";
            for(int k = 0; k<nc.convertOctalToBinary().length; k++){
                binary = binary+nc.convertOctalToBinary()[k];
            }
            System.out.println("Binary Number: " + binary);

        }
    }
}

