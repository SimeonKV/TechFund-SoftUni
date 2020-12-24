package Methods;

import java.util.Arrays;
import java.util.Scanner;

/*
*
* */
public class CharactersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char inputOne = scanner.nextLine().charAt(0);
        char inputTwo = scanner.nextLine().charAt(0);

        char start = (char)Math.min(inputOne, inputTwo);
        char end = (char)Math.max(inputOne, inputTwo);

        char[] output = getCharInRange(start, end);
        printOutput(output);

    }

    private static void printOutput(char[] output) {
       for(char letter : output){
           System.out.print((char) letter + " ");
       }
    }

    private static char[] getCharInRange(char start, char end) {
        int charArrLength = (end - start) - 1;
        char[] output = new char[charArrLength];
        int charIndex = 0;

        for (int i = start + 1; i < end; i++) {
            output[charIndex] = (char) i;

            charIndex++;
        }

        return output;
    }

}
