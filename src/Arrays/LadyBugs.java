package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
You are given a field size and the indexes of ladybugs inside the field. After that on every new line until the "end" command is given, a ladybug changes its position either to its left or to its right by a given fly length.
A command to a ladybug looks like this: "0 right 1". This means that the little insect placed on index 0 should fly one index to its right. If the ladybug lands on a fellow ladybug, it continues to fly in the same direction by the same fly length. If the ladybug flies out of the field, it is gone.
For example, imagine you are given a field with size 3 and ladybugs on indexes 0 and 1. If the ladybug on index 0 needs to fly to its right by the length of 1 (0 right 1) it will attempt to land on index 1 but as there is another ladybug there it will continue further to the right by additional length of 1, landing on index 2. After that, if the same ladybug needs to fly to its right by the length of 1 (2 right 1), it will land somewhere outside of the field, so it flies away:
If you are given ladybug index that does not have ladybug there, nothing happens. If you are given ladybug index that is outside the field, nothing happens.
Your job is to create the program, simulating the ladybugs flying around doing nothing. At the end, print all cells in the field separated by blank spaces. For each cell that has a ladybug on it print '1' and for each empty cells print '0'. For the example above, the output should be '0 1 0'.
* */
public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] bugsIndexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] field = new int[fieldSize];

        for (int i = 0; i < bugsIndexes.length; i++) {
            int position = bugsIndexes[i];
            if(position >= 0 && position < field.length) {
                field[position] = 1;
            }
        }


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] params = input.split(" ");
            int bugIndex = Integer.parseInt(params[0]);
            String direction = params[1];
            int flyLength = Integer.parseInt(params[2]);

            if (bugIndex < 0 || flyLength == 0||bugIndex >= field.length || field[bugIndex] != 1) {
                continue;
            }

            if(direction.equals("right") && flyLength > 0){
                moveRight(bugIndex,flyLength,field);
            }else if(direction.equals("left") && flyLength < 0){
                moveRight(bugIndex,flyLength,field);
            }else if(direction.equals("left") && flyLength > 0){
                moveLeft(bugIndex,flyLength,field);
            }else if(direction.equals("right") && flyLength < 0){
                moveLeft(bugIndex,flyLength,field);
            }


        }

        for (int element : field){
            System.out.print(element + " ");
        }

    }

    private static void moveLeft(int bugIndex, int flyLength, int[] field) {
        if(flyLength < 0){
            flyLength = Math.abs(flyLength);
        }

        int move = bugIndex - flyLength;
        field[bugIndex] = 0;

        for (int i =  move; i >= 0 ; i--) {
            if(field[i] == 0){
                field[i] = 1;
                break;
            }
        }
    }

    private static void moveRight(int bugIndex, int flyLength, int[] field) {
        if(flyLength < 0){
            flyLength = Math.abs(flyLength);
        }

        int move = bugIndex + flyLength;
        field[bugIndex] = 0;
        for (int i = move; i < field.length; i++) {
            if(field[i] == 0){
                field[i] = 1;
                break;
            }
        }
    }
}
