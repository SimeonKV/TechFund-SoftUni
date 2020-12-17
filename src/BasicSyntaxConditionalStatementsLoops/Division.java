package BasicSyntaxConditionalStatementsLoops;
/*
* You will be given an integer and you have to print on the console whether that number is divisible by the following numbers: 2, 3, 6, 7, 10.
* You should always take the bigger division.
* If the number is divisible by both 2 and 3 it is also divisible by 6 and you should print only the division by 6.
* If a number is divisible by 2 it is sometimes also divisible by 10 and you should print the division by 10.
*  If the number is not divisible by any of the given numbers print “Not divisible”.
*  Otherwise print "The number is divisible by {number}".
* */


import java.util.Scanner;

public class Division {
   static String OUTPUT_MESSAGE_SUCCESS = "The number is divisible by ";
   static String OUTPUT_MESSAGE_FAIL = "Not divisible";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());


        if(number % 10 == 0){
            System.out.println(OUTPUT_MESSAGE_SUCCESS + "10");
        }else if(number % 7 == 0){
            System.out.println(OUTPUT_MESSAGE_SUCCESS +  "7");
        }else if(number % 2 == 0 && number % 3 == 0){
            System.out.println(OUTPUT_MESSAGE_SUCCESS + "6");
        }else if(number % 3 == 0){
            System.out.println(OUTPUT_MESSAGE_SUCCESS + "3");
        }else if(number % 2 == 0){
            System.out.println(OUTPUT_MESSAGE_SUCCESS + "2");
        }else{
            System.out.println(OUTPUT_MESSAGE_FAIL);
        }


    }
}
