import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");

        System.out.print("Enter the base of your number (2, 8, 10, 16): ");


        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        String m = "";


        System.out.print("Enter your number: ");
        m = s.nextLine();

        NumberConverter nc = new NumberConverter(m, base);
        int[] digits = nc.getDigits();
        // When base is 2
        if(base == 2){
            boolean valid = true;
            //Make sure all values are either 0 or 1
            for (int digit : digits) {
                if (digit != 1 && digit != 0) {
                    valid = false;
                }
            }
           if(valid){
               //Goes through all arrays that are returned and prints a final value
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
               String hex = "";
               for(int j = 0; j<nc.convertToHexadecimal().length; j++){
                   hex = hex+nc.convertToHexadecimal()[j];
               }
               System.out.println("Hexadecimal Number: "+ hex);
           }
           else{
               System.out.println("this number is not valid");
           }
        }
        //when base is 10
        else if(base == 10){
            //Asks if the user wants to convert to a specific base
            //If yes, asks for a base to convert to and returns the value
            //If no, prints the original 3 base values
            System.out.println("Do you want to convert to a specific base: (y/n): ");
            Scanner specificBase = new Scanner(System.in);
            String b = specificBase.nextLine();
            if(b.equals("n")){
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
                String hex = "";
                for(int j = 0; j<nc.convertToHexadecimal().length; j++){
                    hex = hex+nc.convertToHexadecimal()[j];
                }
                System.out.println("Hexadecimal Number: "+ hex);

            }
            else if (b.equals("y")){
                System.out.println("What base do you want to convert to: ");
                Scanner nb = new Scanner(System.in);
                String input = nb.nextLine();
                int newBase = Integer.parseInt(input);
                System.out.println("Base " + newBase + ": " + nc.convertBase(newBase));
            }


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
            String hex = "";
            for(int j = 0; j<nc.convertToHexadecimal().length; j++){
                hex = hex+nc.convertToHexadecimal()[j];
            }
            System.out.println("Hexadecimal Number: "+ hex);
        }
        //when base is 16
        else if(base == 16){
            String decimal = "Decimal Value: ";
            for(int i = 0; i<nc.convertHexadecimalToDecimal().length; i++){
                decimal = decimal + nc.convertHexadecimalToDecimal()[i];
            }
            System.out.println(decimal);
            String binary = "Binary Value: ";
            for(int i = 0; i<nc.convertHexadecimalToBinary().length; i++){
                binary = binary + nc.convertHexadecimalToBinary()[i];
            }
            System.out.println(binary);
            String octal = "Octal Value: ";
            for(int i = 0; i<nc.convertHexadecimalToOctal().length; i++){
                octal = octal + nc.convertHexadecimalToOctal()[i];
            }
            System.out.println(octal);
        }
        else{
            System.out.println("not valid");
        }
    }
}

