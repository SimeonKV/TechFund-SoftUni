package BasicSyntaxConditionalStatementsLoops;
/*
*Write a program to check if a given number is a strong number or not.
* A number is strong if the sum of the Factorial of each digit is equal to the number.
* For example 145 is a strong number, because 1! + 4! + 5! = 145.
* Print "yes" if the number is strong and "no" if the number is not strong
* */

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNumberAsStr = scanner.nextLine();

        int sumOfAllFactorials = 0;
        for (int i = 0; i < inputNumberAsStr.length(); i++) {

          sumOfAllFactorials +=  findSumOfSingleDigitFactorial(inputNumberAsStr.charAt(i));
        }


        if(sumOfAllFactorials == Integer.parseInt(inputNumberAsStr)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }

    private static int findSumOfSingleDigitFactorial(char digit) {
        int intDigit = Integer.parseInt(digit + "");

        int result = 1;

        if(intDigit == 0 || intDigit == 1){
            return result;
        }

        for (int start = intDigit; start >= 1 ; start--) {
            result *= start;
        }

        return result;
    }
}
