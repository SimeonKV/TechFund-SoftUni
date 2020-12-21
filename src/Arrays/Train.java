package Arrays;

import java.util.Scanner;

/*
*You will be given a count of wagons in a train n.
* On the next n lines you will receive how many people are going to get on that wagon.
*  At the end print the whole train and after that the sum of the people in the train.
* */
public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[numberOfWagons];

        for (int i = 0; i < wagons.length ; i++) {
            int numbersOfPassengers = Integer.parseInt(scanner.nextLine());
            wagons[i] = numbersOfPassengers;
        }

        int sumOfAllPassengers = 0;
        for(int wagon : wagons){
            System.out.print(wagon + " ");
            sumOfAllPassengers += wagon;
        }
        System.out.println();
        System.out.println(sumOfAllPassengers);

    }
}
