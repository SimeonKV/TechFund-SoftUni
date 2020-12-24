package Methods;

import java.util.Scanner;

/*
* Write a method that receives a single string and prints the count of the vowels.
*  Use appropriate name for the method.
* */
public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        int count = countVowels(word);
        System.out.println(count);

    }

    private static int countVowels(String word) {
        char[] wordAsCharArr = word.toCharArray();

        int counter = 0;
        for(char letter : wordAsCharArr){
            if(Character.toLowerCase(letter) == 'a' || Character.toLowerCase(letter) == 'e'||
            Character.toLowerCase(letter) == 'o' || Character.toLowerCase(letter) == 'i'
            || Character.toLowerCase(letter) == 'u' || Character.toLowerCase(letter) == 'y'){
                counter ++;
            }
        }

        return counter;
    }
}
