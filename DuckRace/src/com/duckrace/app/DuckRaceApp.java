package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;
import static com.duckrace.Reward.*;

/*
 * Application controller. Directs overall flow of the application,
 * and prompts user for inputs, then passes those inputs into the system
 */
public class DuckRaceApp {
     private final Board board = Board.getInstance();
     private final Scanner scanner = new Scanner(System.in);

     //programming by intention
     // call private methods that do individual jobs
     public void execute(){
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
        board.save();
     }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
         Reward reward = null;

         boolean validInput = false;
         while (!validInput) {
             System.out.print("Please enter [D] for debit card or [P] for prizes: ");
             String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) { // Warning: dont say D | P for readability.
                validInput = true;
            } reward = (input.equals("D")) ? DEBIT_CARD : PRIZES; // ternary
//            if (input.equals("D")) {
//                reward = Reward.DEBIT_CARD;
//             }
//             else {
//                 reward = Reward.PRIZES;
//             }
         }
         return reward;
    }

    private int promptForId() {
       int id = 0;
       boolean validInput = false;
       while(!validInput) {
           System.out.print("Please enter ID of the winner [1-16]:"); // dont hardcode the 16
           String input = scanner.nextLine().trim(); //Blocks for input, i.e., the Enter key
           if(input.matches("\\d{1,2}" )){ // any digit, or two times
                id = Integer.parseInt(input); // this is safe to do at this point (no exception)
               if(id >= 1 && id <= 16) {
                    validInput = true;
               }
           }
       }
        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("- - - - - - -   - -   - - -   - - - -   - - - - - ");
        System.out.println("W E L C O M E   T O   T H E   D U C K   R A C E ! ");
        System.out.println("- - - - - - -   - -   - - -   - - - -   - - - - - ");
        System.out.println();
    }
}
