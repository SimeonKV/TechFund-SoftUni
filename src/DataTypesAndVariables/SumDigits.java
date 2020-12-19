package DataTypesAndVariables;

import java.util.Scanner;

/*
* You will be given a single integer.
* Your task is to find the sum of its digits.
* */
public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intNumber = Integer.parseInt(scanner.nextLine());

        int sumOfAllNumbersDigits = 0;
        while(intNumber != 0){
            int lastDigitOfIntNumber = intNumber % 10;
            sumOfAllNumbersDigits += lastDigitOfIntNumber;
            intNumber /= 10;
        }


        System.out.println(sumOfAllNumbersDigits);
    }
}
