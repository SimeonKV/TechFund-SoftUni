package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
* Write a program to find all the top integers in an array.
*  A top integer is an integer which is bigger than all the elements to its right.
 * */
public class TopIntegers {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrOfInts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] outputArray = new int[0];

        for (int i = 0; i < arrOfInts.length ; i++) {

            if(topInteger(i,arrOfInts)){
               outputArray = addNewElementToArray(arrOfInts[i],outputArray);
            }

        }

        Arrays.stream(outputArray).forEach(element -> System.out.print(element + " "));

    }

    private static int[] addNewElementToArray(int element, int[] outputArray) {
        int[] backupArray = outputArray;
        outputArray = resizeArray(outputArray);

        if(backupArray.length > 0) {
            moveOldElementsToNewArray(backupArray, outputArray);
        }

        outputArray[outputArray.length - 1] = element;
        return outputArray;
    }

    private static void moveOldElementsToNewArray(int[] backupArray, int[] outputArray) {
        for (int i = 0; i < backupArray.length; i++) {
            outputArray[i] = backupArray[i];
        }
    }

    private static int[] resizeArray(int[] outputArray) {
        int oldLength = outputArray.length;
        int newLength = oldLength + 1;
        outputArray = new int[newLength];
        return outputArray;
    }


    private static boolean topInteger(int elementIndex, int[] arrOfInts) {
        int element = arrOfInts[elementIndex];


        for (int i = elementIndex + 1 ; i < arrOfInts.length; i++) {

            if(element <= arrOfInts[i]){
                return false;
            }
        }

        return true;
    }
}
