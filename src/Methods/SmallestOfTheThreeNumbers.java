package Methods;

import java.util.Scanner;

/*
* Write a method to print the smallest of three integer numbers.
*  Use appropriate name for the method.
* */
public class SmallestOfTheThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());

        int output = findSmallestNumber(numberOne,numberTwo,numberThree);


        System.out.println(output);

    }

    private static int findSmallestNumber(int numberOne, int numberTwo, int numberThree) {
        int resOne = returnSmallestOfTwoNumber(numberOne, numberTwo);

        return returnSmallestOfTwoNumber(resOne, numberThree);
    }

    private static int returnSmallestOfTwoNumber(int numberOne, int numberTwo) {
        if(numberOne < numberTwo){
            return numberOne;
        }else if(numberOne > numberTwo){
            return numberTwo;
        }else{
            return numberOne;
        }

    }

}
