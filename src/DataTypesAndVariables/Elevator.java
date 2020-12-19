package DataTypesAndVariables;

import java.util.Scanner;

/*
* Calculate how many courses will be needed to elevate n persons by using an elevator with capacity of p persons.
The input holds two lines: the number of people n and the capacity p of the elevator.
* */
public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeopleToElevate = Integer.parseInt(scanner.nextLine());
        int capacityOfElevator = Integer.parseInt(scanner.nextLine());

        double times = Math.ceil(numberOfPeopleToElevate * 1.00 / capacityOfElevator);

        System.out.println((int)times);
    }
}
