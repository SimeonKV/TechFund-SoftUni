package DataTypesAndVariables;
/*
*You have a water tank with capacity of 255 liters.
On the next n lines, you will receive liters of water, which you have to pour in your tank.
If the capacity is not enough, print “Insufficient capacity!” and continue reading the next line.
*  On the last line, print the liters in the tank.
* */

import java.util.Scanner;

public class WaterOverflow {
    static int TANK_CAPACITY_IN_LITERS = 255;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int currentWaterInTheTank = 0;
        for (int i = 1; i <= n ; i++) {
            int waterInLiters = Integer.parseInt(scanner.nextLine());

            int estimatedWaterInTheTank = currentWaterInTheTank + waterInLiters;

            if(estimatedWaterInTheTank > TANK_CAPACITY_IN_LITERS){
                System.out.println("Insufficient capacity!");
            }else{
                currentWaterInTheTank = estimatedWaterInTheTank;
            }
        }

        System.out.println(currentWaterInTheTank);

    }
}
