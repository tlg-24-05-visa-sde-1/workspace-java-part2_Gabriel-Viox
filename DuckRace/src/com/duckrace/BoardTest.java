package com.duckrace;

public class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();

        // this dumps all the Students in the txt file.
//          board.dumpStudentIdMap();
        board.update(2, Reward.DEBIT_CARD);
        board.update(5,Reward.DEBIT_CARD);
        board.update(5, Reward.PRIZES);
        board.update(8, Reward.DEBIT_CARD);
        board.update(7,Reward.DEBIT_CARD);
        board.update(11, Reward.DEBIT_CARD);

        // this will dump the map of winners
        board.show();

    }
}
