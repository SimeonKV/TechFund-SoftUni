package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
*Write a program that determines if there exists an element in the array
* such that the sum of the elements on its left is equal to the sum of the elements on its right.
* If there are no elements to the left / right, their sum is considered to be 0.
* Print the index that satisfies the required condition or “no” if there is no such index.
* */
public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrOfInts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if(arrOfInts.length == 0){
            System.out.println(0);
            return;
        }

        Integer outputIndex = null;
        for (int i = 0; i <  arrOfInts.length; i++) {

            int leftSum = findLeftSumOfArray(arrOfInts,i);
            int rightSum = findRightSumOfArray(arrOfInts,i);

            if(leftSum == rightSum){
                outputIndex = i;
            }
        }

        if(outputIndex != null){
            System.out.println(outputIndex);
        }else{
            System.out.println("no");
        }
    }

    private static int findRightSumOfArray(int[] arrOfInts, int index) {
        int result = 0;
        if(index == arrOfInts.length - 1){
            return result;
        }

        for (int start = index + 1; start < arrOfInts.length ; start++) {
            result += arrOfInts[start];
        }

        return result;
    }

    private static int findLeftSumOfArray(int[] arrOfInts, int index) {
        int result = 0;
        if(index == 0){
            return result;
        }

        for (int start = index - 1 ; start >= 0 ; start--) {
            result += arrOfInts[start];
        }

        return result;
    }
}
