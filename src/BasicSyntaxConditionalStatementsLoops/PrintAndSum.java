package BasicSyntaxConditionalStatementsLoops;

/*
* Write a program to display numbers from given start to given end and their sum.
* All the numbers will be integers.
* On the first line you will receive the start number, on the second the end number.
* */

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int total = 0;

        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");
            total += i;

            if( i == end){
                System.out.println();
            }
        }

        System.out.println("Sum: " + total);

    }
}
