package DataTypesAndVariables;

import java.util.Scanner;

/*

* Read four integer numbers.
Add first to the second, divide (integer) the sum by the third number and multiply the result by the fourth number.
Print the result
* */
public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());
        int numberFour = Integer.parseInt(scanner.nextLine());

        int endResult = ((numberOne + numberTwo) / numberThree) * numberFour;
        System.out.println(endResult);


    }
}
