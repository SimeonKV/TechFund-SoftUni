package BasicSyntaxConditionalStatementsLoops;

/*
* You are given a group of people, type of the group, on which day of the week they are going to stay.
* Based on that information calculate how much they have to pay and print that price on the console.
* Use the table below. In each cell is the price for a single person.
* The output should look like that: "Total price: {price}". The price should be formatted to the second decimal point.
	 Friday	       Saturday	    Sunday
Students	8.45	9.80	10.46
Business	10.90	15.60	16
Regular	 15	20	22.50
There are also discounts based on some conditions:
•	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
•	Business – if the group is bigger than or equal to  100 people 10 of them can stay for free.
•	Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5%
You should reduce the prices in that EXACT order
* */

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double total = 0d;
        switch (typeOfGroup){
            case"Students":
                switch (dayOfWeek){
                    case"Friday":
                        total = numberOfPeople * 8.45;
                        if(numberOfPeople >= 30){
                            total *= 0.85;
                        }
                        break;
                    case"Saturday":
                        total = numberOfPeople * 9.8;
                        if(numberOfPeople >= 30){
                            total *= 0.85;
                        }
                        break;
                    case"Sunday":
                        total = numberOfPeople * 10.46;
                        if(numberOfPeople >= 30){
                            total *= 0.85;
                        }
                        break;
                }
                break;
            case"Business":
                switch (dayOfWeek){
                    case"Friday":
                        if(numberOfPeople >= 100){
                            numberOfPeople -= 10;
                        }
                        total = numberOfPeople * 10.9;
                        break;
                    case"Saturday":
                        if(numberOfPeople >= 100){
                            numberOfPeople -= 10;
                        }
                        total = numberOfPeople * 15.6;
                        break;
                    case "Sunday":
                        if(numberOfPeople >= 100){
                            numberOfPeople -= 10;
                        }
                        total = numberOfPeople * 16;
                        break;
                }
                break;
            case"Regular":
                switch (dayOfWeek){
                    case"Friday":
                        total = 15 * numberOfPeople;
                        if(numberOfPeople >= 10 && numberOfPeople <= 20){
                            total *= 0.95;
                        }
                        break;
                    case"Saturday":
                        total = 20 * numberOfPeople;
                        if(numberOfPeople >= 10 && numberOfPeople <= 20){
                            total *= 0.95;
                        }
                        break;
                    case"Sunday":
                        total = 22.50 * numberOfPeople;
                        if(numberOfPeople >= 10 && numberOfPeople <= 20){
                            total *= 0.95;
                        }
                        break;
                }
                break;
        }

        System.out.println(String.format("Total price: %.2f",total));

    }
}
