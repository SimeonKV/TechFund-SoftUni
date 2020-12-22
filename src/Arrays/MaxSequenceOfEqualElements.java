package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
*
* */
public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrOfInts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int bestCounter = 0;
        Integer elementWithBestCounter = null;

        for (int i = 0; i < arrOfInts.length ; i++) {

          int counter = countNumberOfTimesElementRepatItselfInARow(arrOfInts,i);

          if(bestCounter < counter){
              bestCounter = counter;
              elementWithBestCounter = arrOfInts[i];
          }

        }

        for (int start = 1; start <= bestCounter ; start++) {
            System.out.print(elementWithBestCounter + " ");
        }

    }

    private static int countNumberOfTimesElementRepatItselfInARow(int[] arrOfInts, int index) {
        int counter = 1;
        for (int i = index; i < arrOfInts.length -1 ; i++) {
            if(arrOfInts[i] == arrOfInts[i + 1]){
                counter++;
            }else{
                return counter;
            }
        }

        return counter;
    }
}
