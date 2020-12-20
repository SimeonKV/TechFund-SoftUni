package DataTypesAndVariables;
/*
* Write a program, which sums the ASCII codes of n characters.
Print the sum on the console.
* */

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfChars = Integer.parseInt(scanner.nextLine());

        int sumOfAllChars = 0;
        while(numberOfChars > 0){
            char character = scanner.nextLine().charAt(0);
            sumOfAllChars += character;

            numberOfChars--;
        }

        System.out.println("The sum equals: " + sumOfAllChars);

    }
}
