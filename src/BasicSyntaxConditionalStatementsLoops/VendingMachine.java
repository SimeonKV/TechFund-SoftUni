package BasicSyntaxConditionalStatementsLoops;

/*
*You task is to calculate the total price of a purchase from a vending machine.
* Until you receive "Start" you will be given different coins that are being inserted in the machine.
* You have to sum them in order to have the total money inserted. There is a problem though.
* Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins.
* If someone tries to insert some other coins you have to display "Cannot accept {money}",
* where the value is formated to the second digit after the decimal point and not add it to the total money.
* On the next few lines until you receive "End" you will be given products to purchase.
* Your machine has however only "Nuts", "Water", "Crisps", "Soda", "Coke".
*  The prices are: 2.0, 0.7, 1.5, 0.8, 1.0 respectively.
* If the person tries to purchase a not existing product print “Invalid product”.
*  Be careful that the person may try to purchase a product for which he doesn't have money.
*  In that case print "Sorry, not enough money".
* If the person purchases a product successfully print "Purchased {product name}".
*After the “End” command print the money
* that are left formatted to the second decimal point in the format "Change: {money left}".
* */

import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {
    static HashMap<String, Double> PRODUCTS_AND_PRICES = new HashMap<String, Double>() {{
        put("Nuts", 2.00);
        put("Water", 0.70);
        put("Crisps", 1.50);
        put("Soda", 0.80);
        put("Coke", 1.00);
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double totalCoinsInserted = 0;
        while (true) {

            if (input.equals("Start")) {
                break;
            } else {
                double coins = Double.parseDouble(input);

                if (coins == 0.10 || coins == 0.20 || coins == 0.50
                        || coins == 1 || coins == 2) {
                    totalCoinsInserted += coins;
                } else {
                    System.out.println(String.format("Cannot accept %.2f", coins));
                }
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (true) {

            if (input.equals("End")) {
                break;
            } else {

                if (PRODUCTS_AND_PRICES.containsKey(input)) {
                    double price = PRODUCTS_AND_PRICES.get(input);

                    if (totalCoinsInserted >= price) {

                        totalCoinsInserted -= price;
                        System.out.println("Purchased " + input);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else {
                    System.out.println("Invalid product");
                }

            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalCoinsInserted);
    }
}
