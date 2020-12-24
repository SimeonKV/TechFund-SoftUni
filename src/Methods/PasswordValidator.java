package Methods;
/*
*Write a program that checks if a given password is valid. Password rules are:
•	6 – 10 characters (inclusive)
•	Consists only of letters and digits
•	Have at least 2 digits
If a password is valid print “Password is valid”. If it is not valid, for every unfulfilled rule print a message:
•	"Password must be between 6 and 10 characters"
•	"Password must consist only of letters and digits"
•	"Password must have at least 2 digits"

* */

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        validPassword(password);


    }

    private static void validPassword(String password) {
        if(validatePassword(password)){
            System.out.println("Password is valid");
        }
    }

    private static boolean validatePassword(String password) {
        boolean validLength = validateLength(password);
        boolean validOnlyLettersAndDigits = validateOnlyLettersAndDigits(password);
        boolean validAtLeastDigits =  validateAtLeastTwoDigits(password);

        return validLength && validOnlyLettersAndDigits && validAtLeastDigits;
    }

    private static boolean validateAtLeastTwoDigits(String password) {

        int counter = 0;
        for (int i = 0; i < password.length() ; i++) {
            char symbol = password.charAt(i);
            if(Character.isDigit(symbol)){
                counter ++;
                if(counter == 2){
                    return true;
                }
            }
        }

        System.out.println("Password must have at least 2 digits");
        return false;
    }

    private static boolean validateOnlyLettersAndDigits(String password) {

        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);

            if(!Character.isDigit(symbol) && !Character.isLetter(symbol)){
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }

        return true;
    }

    private static boolean validateLength(String password) {
        if(password.length() >= 6 && password.length() <= 10){
            return true;
        }else{
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }
}
