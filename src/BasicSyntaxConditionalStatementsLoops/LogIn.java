package BasicSyntaxConditionalStatementsLoops;

/*
*You will be given a string representing a username. The password will be that username reversed.
* Until you receive the correct password print on the console "Incorrect password. Try again.".
* When you receive the correct password print "User {username} logged in.
* " However on the fourth try if the password is still not correct print "User {username} blocked!" and end the program
* */

import java.util.Scanner;

public class LogIn {
    static String CORRECT_LOGIN_MESSAGE = "User %s logged in.";
    static String INCORRECT_LOGIN_MESSAGE = "Incorrect password. Try again.";
    static String BLOCKED_USER_MESSAGE = "User %s blocked!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();


        int unsuccessfulLogIns = 0;
        while(true){
          String input = scanner.nextLine();
          StringBuilder reversedInput = new StringBuilder(input).reverse();

            if(unsuccessfulLogIns == 3){
                System.out.println(String.format(BLOCKED_USER_MESSAGE,username));
                return;
            }

          if(reversedInput.toString().equals(username)){

              System.out.println(String.format(CORRECT_LOGIN_MESSAGE,username));
              return;
          }else{
              System.out.println(INCORRECT_LOGIN_MESSAGE);
              unsuccessfulLogIns++;
          }

        }


    }
}
