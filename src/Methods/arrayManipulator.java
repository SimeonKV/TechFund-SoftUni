package Methods;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
*Trifon has finally become a junior developer and has received his first task.
* It’s about manipulating an array of integers. He is not quite happy about it, since he hates manipulating arrays.
* They are going to pay him a lot of money, though, and he is willing to give somebody half of it if to help him do his job.
*  You, on the other hand, love arrays (and money) so you decide to try your luck.
The array may be manipulated by one of the following commands
•	exchange {index} – splits the array after the given index, and exchanges the places of the two resulting sub-arrays.
*  E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
o	If the index is outside the boundaries of the array, print “Invalid index”
•	max even/odd– returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
•	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
o	If there are two or more equal min/max elements, return the index of the rightmost one
o	If a min/max even/odd element cannot be found, print “No matches”
•	first {count} even/odd– returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
•	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
o	If the count is greater than the array length, print “Invalid count”
o	If there are not enough elements to satisfy the count, print as many as you can.
* If there are zero even/odd elements, print an empty array “[]”
•	end – stop taking input and print the final state of the array
* */
public class arrayManipulator {
    static Scanner SCANNER = new Scanner(System.in);
    static int[] ARRAY = new int[0];
    public static void main(String[] args) {
        ARRAY = readArray();

        String input = SCANNER.nextLine();
        while(true){

            if(input.equals("end")){
                printArray(ARRAY);
                break;
            }

            String[] tokens = input.split(" ");
            listOfCommandOperations(tokens);



            input = SCANNER.nextLine();
        }


    }

    private static void listOfCommandOperations(String[] tokens) {
        String cmd = tokens[0];

        if (cmd.equals("exchange")) {
            int index = Integer.parseInt(tokens[1]);
            exchange(index);
        } else if (cmd.equals("max")) {
            String cmdTwo = tokens[1];
            int index = 0;

            if (cmdTwo.equals("even")) {
                index = getMaxEvenNumberIndex();
                matchFoundMessage(index);
            } else {
                index = getMaxOddNumberIndex();
                matchFoundMessage(index);
            }
        } else if (cmd.equals("min")) {
            String cmdTwo = tokens[1];
            int index = 0;

            if (cmdTwo.equals("even")) {
                index = getMinEvenIndex();
                matchFoundMessage(index);
            } else {
                index = getMinOddIndex();
                matchFoundMessage(index);
            }

        } else if (cmd.equals("first")) {
            int count = Integer.parseInt(tokens[1]);
            String cmdTwo = tokens[2];
            int[] output = new int[0];

            if (cmdTwo.equals("even")) {
                output = returnFirstNEven(count);
                printMessageOutput(output);
            } else {
                output = returnFirstNOdd(count);
                printMessageOutput(output);
            }

        }else if(cmd.equals("last")){
            int count = Integer.parseInt(tokens[1]);
            String cmdTwo = tokens[2];
            int[] output = new int[0];

            if(cmdTwo.equals("even")){
                output = returnLastNEven(count);
                printMessageOutput(output);
            }else if(cmdTwo.equals("odd")){
                output = returnLastNOdd(count);
                printMessageOutput(output);
            }

        }


    }

    private static void printMessageOutput(int[] output) {
        if(output == null){
            System.out.println("Invalid count");
        }else{
            printArray(output);
        }
    }

    private static void printArray(int[] output) {
        if(output.length == 0){
            System.out.println("[]");
        }

        for (int i = 0; i < output.length ; i++) {
            if(i == 0){
                System.out.print("[");
            }

            if(i == output.length - 1){
                System.out.println(output[i] + "]");
            }else{
                System.out.print(output[i] + "," + " ");
            }

        }

    }

    private static int[] returnLastNOdd(int count) {
        int oddNumsCount = countNumbersInArray("odd");

        if(count > ARRAY.length || count <= 0){
            return null;
        }

        int[] output = null;
        int arrayLength = Math.min(count,oddNumsCount);
        output = new int[arrayLength];
        int outputIndex = 0;

        if(output.length == 0){
            return output;
        }


        for (int i = ARRAY.length - 1; i >= 0 ; i--) {

            if(output[output.length - 1] == 0){
                if(Math.abs(ARRAY[i] % 2) == 1){
                    output[outputIndex++] = ARRAY[i];
                }
            }else {
                return output;
            }
        }

        return output;
    }

    private static int[] returnLastNEven(int count) {
        int evenNumsCount = countNumbersInArray("even");

        if(count > ARRAY.length || count <= 0){
            return null;
        }

        int[] output = null;
        int arrayLength = Math.min(count,evenNumsCount);
        output = new int[arrayLength];
        int outputIndex = 0;

        if(output.length == 0){
            return output;
        }


        for (int i = ARRAY.length - 1; i >= 0 ; i--) {
            if(output[output.length - 1] == 0){
                if(Math.abs(ARRAY[i] % 2) == 0){
                    output[outputIndex++] = ARRAY[i];
                }
            }else {
                return output;
            }
        }

        return output;
    }

    private static int[] returnFirstNOdd(int count) {
        int oddNumsCount = countNumbersInArray("odd");

        if(count > ARRAY.length || count <= 0){
            return null;
        }

        int[] output = null;
        int arrayLength = Math.min(count,oddNumsCount);
        output = new int[arrayLength];
        int outputIndex = 0;

        if(output.length == 0){
            return output;
        }


        for (int i = 0; i < ARRAY.length ; i++) {
            if (output[output.length - 1] == 0) {
                if (Math.abs(ARRAY[i] % 2) == 1) {
                    output[outputIndex++] = ARRAY[i];
                }
            }else{
                return output;
            }
        }

        return output;
    }

    private static int[] returnFirstNEven(int count) {
        int evenNumsCount = countNumbersInArray("even");

        if(count > ARRAY.length || count <= 0){
            return null;
        }

        int[] output = null;
        int arrayLength = Math.min(evenNumsCount,count);
        output = new int[arrayLength];
        int outputIndex = 0;

        if(output.length == 0){
            return output;
        }


        for (int i = 0; i < ARRAY.length ; i++) {

            if(output[output.length - 1] == 0 ) {
                if (Math.abs(ARRAY[i] % 2) == 0 && ARRAY[i] != 0) {
                    output[outputIndex++] = ARRAY[i];
                }
            }else{
                return output;
            }
        }


        return output;
    }

    private static int countNumbersInArray(String parity) {
        if(parity == null || parity.equals("         ".trim())){
            return ARRAY.length;
        }

        int evenCounter = 0;
        int oddCounter = 0;

        for(int element : ARRAY){

            if(element % 2 == 0 && element != 0){
                evenCounter++;
            }else{
                if(element != 0) {
                    oddCounter++;
                }
            }

        }

        if(parity.equals("odd")){
            return oddCounter;
        }else if(parity.equals("even")){
            return evenCounter;
        }
        return 0;
    }

    private static int getMinOddIndex() {
        int minOddNumberIndex = -1;
        int minOddNumber = Integer.MAX_VALUE;

        for (int i = 0; i < ARRAY.length ; i++) {
            if(Math.abs(ARRAY[i] % 2) == 1){

                if(minOddNumber >= ARRAY[i]){
                    minOddNumber = ARRAY[i];
                    minOddNumberIndex = i;
                }

            }

        }

        return  minOddNumberIndex;
    }

    private static int getMinEvenIndex() {
        int minEvenNumberIndex = -1;
        int minEvenNumber = Integer.MAX_VALUE;

        for (int i = 0; i < ARRAY.length ; i++) {

            if(Math.abs(ARRAY[i] % 2) == 0 && ARRAY[i] != 0){
                if(minEvenNumber >= ARRAY[i]){
                    minEvenNumber = ARRAY[i];
                    minEvenNumberIndex = i;
                }

            }
        }

        return minEvenNumberIndex;
    }

    private static void matchFoundMessage(int index) {
        if(index == - 1){
            System.out.println("No matches");
        }else{
            System.out.println(index);
        }
    }

    private static int getMaxOddNumberIndex() {
        int maxOddNumberIndex = -1;
        int maxOddNumber = Integer.MIN_VALUE;

        for (int i = 0; i < ARRAY.length ; i++) {
            if(Math.abs(ARRAY[i] % 2) == 1){
                if(maxOddNumber <= ARRAY[i]){
                    maxOddNumber = ARRAY[i];
                    maxOddNumberIndex = i;
                }
            }

        }

        return  maxOddNumberIndex;
    }

    private static int getMaxEvenNumberIndex() {
        int maxEvenNumberIndex = -1;
        int maxEvenNumber = Integer.MIN_VALUE;

        for (int i = 0; i < ARRAY.length; i++) {
            if(Math.abs(ARRAY[i] % 2) == 0 && ARRAY[i] != 0){
                if(maxEvenNumber <= ARRAY[i]){
                    maxEvenNumber = ARRAY[i];
                    maxEvenNumberIndex = i;
                }
            }
        }

        return maxEvenNumberIndex;
    }

    private static void exchange(int index) {
        if(index < 0 || index >= ARRAY.length){
            System.out.println("Invalid index");
            return;
        }

        if(index == ARRAY.length - 1){
            return;
        }

        int[] firstSubArray = readArray(0,index + 1);
        int[] secondSubArray = readArray(index + 1,ARRAY.length);
        ARRAY = combineTwoArrays(firstSubArray,secondSubArray);

    }

    private static int[] combineTwoArrays(int[] firstSubArray, int[] secondSubArray) {
        int[] output = new int[ARRAY.length];
        int outputIndex = 0;

        for (int i = 0; i < secondSubArray.length ; i++) {
            output[i] = secondSubArray[i];
            outputIndex++;
        }

        for (int i = 0; i < firstSubArray.length;  i++) {
            output[outputIndex++] = firstSubArray[i];
        }

        return output;
    }

    private static int[] readArray(int fromIndex, int toIndex) {
        int index = 0;
        int[] output = new int[toIndex - fromIndex];

        for (int i = fromIndex; i < toIndex; i++) {
            output[index++] = ARRAY[i];
        }

        return output;
    }

    private static int[] readArray() {
        return Arrays.stream(SCANNER.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
