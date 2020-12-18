package BasicSyntaxConditionalStatementsLoops;
/*
* As a MOBA challenger player, Pesho has the bad habit to trash his PC when he loses a game and rage quits.
* His gaming setup consists of headset, mouse, keyboard and display. You will receive Pesho`s lost games count.
Every second lost game, Pesho trashes his headset.
Every third lost game, Pesho trashes his mouse.
When Pesho trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
Every second time, when he trashes his keyboard, he also trashes his display.
You will receive the price of each item in his gaming setup. Calculate his rage expenses for renewing his gaming equipment

* */

import java.util.Scanner;

public class RageExpenses {
    static int HEADSET_TRASHES = 0;
    static int MOUSE_TRASHES = 0;
    static int KEYBOARD_TRASHES = 0;
    static int DISPLAY_TRASHES = 0;
    static boolean KEYBOARD_TRASHED = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());


        for (int i = 1; i <= lostGamesCount ; i++) {

            if(i % 2 == 0){
                HEADSET_TRASHES++;
            }

            if(i % 3 == 0){
                MOUSE_TRASHES++;
            }

            if(i % 2 == 0 && i % 3 == 0){
                KEYBOARD_TRASHES++;
                KEYBOARD_TRASHED = true;
            }else {
                KEYBOARD_TRASHED = false;
            }

            if(KEYBOARD_TRASHES % 2 == 0 && KEYBOARD_TRASHED && KEYBOARD_TRASHES != 0){
                DISPLAY_TRASHES++;
            }
        }

        double totalRageExpenses = (headsetPrice * HEADSET_TRASHES) + (mousePrice * MOUSE_TRASHES)
                + (keyboardPrice * KEYBOARD_TRASHES) + (displayPrice * DISPLAY_TRASHES);

        System.out.printf("Rage expenses: %.2f lv.",totalRageExpenses);

    }
}
