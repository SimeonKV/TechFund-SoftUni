package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
* Write a program, which prints common elements in two arrays.
*  You have to compare the elements of the second array to the elements of the first.
* */
public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        String[] commonElements = new String[0];
        for (String element : secondArr){

            for (int i = 0; i < firstArr.length ; i++) {

                if(element.equals(firstArr[i])){

                 commonElements = addNewElementToArray(commonElements,element);
                }
            }
        }

        for(String element : commonElements){
            System.out.print(element + " ");
        }
        System.out.println();

    }

    private static String[] addNewElementToArray(String[] array, String stringElement) {
        int oldSizeOfArr = array.length;
        int newSizeOfArr = oldSizeOfArr + 1;

        String[] newArray = new String[newSizeOfArr];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[newArray.length - 1] = stringElement;
        return newArray;
    }
}
