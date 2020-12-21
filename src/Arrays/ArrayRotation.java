package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
*
* */
public class ArrayRotation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrOfInts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int numberOfRotations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfRotations; i++) {
            
            rotateArray(arrOfInts);
        }

        Arrays.stream(arrOfInts).forEach(element -> System.out.print(element + " "));

    }

    private static void rotateArray(int[] arrOfInts) {

        int firstElement = arrOfInts[0];
        for (int i = 1; i < arrOfInts.length ; i++) {
            arrOfInts[i - 1] = arrOfInts[i];
        }
        arrOfInts[arrOfInts.length - 1] = firstElement;
    }
}
