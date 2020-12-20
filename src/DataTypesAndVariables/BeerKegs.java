package DataTypesAndVariables;

import java.util.Scanner;

/*
* Write a program, which calculates the volume of n beer kegs.
You will receive in total 3 * n lines. Each three lines will hold information for a single keg.
First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.
Calculate the volume using the following formula: π * r^2 * h.
At the end, print the model of the biggest keg.

* */
public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfKegs = Integer.parseInt(scanner.nextLine());


        String bestKegName = "";
        double bestKegVolume = 0;

        for (int i = 1; i <= numberOfKegs ; i++) {
            String kegModel = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());

            double kegVolume = Math.PI * (radius * radius) * height;

            if(kegVolume > bestKegVolume){
                bestKegVolume = kegVolume;
                bestKegName = kegModel;
            }
        }

        System.out.println(bestKegName);

    }
}
