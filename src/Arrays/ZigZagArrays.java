package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
*Write a program which creates 2 arrays.
* You will be given an integer n. On the next n lines you get 2 integers.
*  Form 2 arrays as shown below.
* */
public class ZigZagArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArr = new int[n];
        int[] secArr = new int[n];

        int counter = 1;
        while(n > 0){
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

            if(checkIfOddPositiveNumberOrNot(counter)){
                firstArr[counter - 1] = numbers[0];
                secArr[counter - 1] = numbers[1];
            }else{
                firstArr[counter - 1] = numbers[1];
                secArr[counter - 1] = numbers[0];
            }

            n--;
            counter++;
        }

        Arrays.stream(firstArr).forEach(element -> System.out.print(element + " "));
        System.out.println();
        Arrays.stream(secArr).forEach(element -> System.out.print(element + " "));

    }

    private static boolean checkIfOddPositiveNumberOrNot(int number) {
        if(number % 2 != 0 && number >= 1){
            return true;
        }else{
            return false;
        }

    }
}
