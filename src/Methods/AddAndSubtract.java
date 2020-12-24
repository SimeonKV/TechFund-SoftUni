package Methods;
/*
*You will receive 3 integers. Write a method sum to get
* the sum of the first two integers and subtract method that subtracts
* the third integer from the result from the Sum method.
 * */

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());

        int additionOfTwoNumbers = add(numberOne,numberTwo);
        int subtractionOfTwoNumbers = subtract(additionOfTwoNumbers,numberThree);

        System.out.println(subtractionOfTwoNumbers);
    }

    private static int subtract(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    private static int add(int numberOne, int numberTwo) {
        return  numberOne + numberTwo;
    }
}
