package Methods;

import java.util.Scanner;

/*
*You will receive a single string. 
* Write a method that prints the middle character. 
* If the length of the string is even there are two middle characters.
* */
public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

      String middleChars = getMiddleCharacters(word);
        System.out.println(middleChars);

    }

    private static String getMiddleCharacters(String word) {
        String middleCharsStr = "";

        if(word.length() % 2 == 0){
            middleCharsStr = "" + word.charAt(word.length() / 2 - 1) + word.charAt(word.length() / 2);
        }else{
            middleCharsStr = word.charAt(word.length() / 2 ) + "";
        }

        return middleCharsStr;
    }
}
