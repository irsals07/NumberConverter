import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while(!(choice.equals("2") || choice.equals("8") || choice.equals("10"))){
            System.out.println("Invalid choice");
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            s = new Scanner(System.in);
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);


        System.out.print("Enter your number: ");
        String number = s.nextLine();
        if(base == 2){
            for(int i = 0; i<number.length(); i++){
                if(number.charAt(i) != 1 || number.charAt(i) != 0){
                    System.out.println("Invalid number");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                }
            }
        }
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}

