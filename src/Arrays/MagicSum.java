package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
* Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.
 * */
public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputArray.length -1; i++) {
            int firstNumber = inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                int secondNumber = inputArray[j];
                int result = firstNumber + secondNumber;

                if(result == number){
                    System.out.println(firstNumber + " " + secondNumber);
                }
            }
        }


    }
}
