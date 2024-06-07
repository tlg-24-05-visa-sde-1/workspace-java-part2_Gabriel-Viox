package com.duckrace;

public class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();
//        board.dumpStudentIdMap();
        board.update(2, Reward.DEBIT_CARD);
        board.update(5,Reward.DEBIT_CARD);
        board.update(5, Reward.PRIZES);
        board.dumpRacerMap();
    }
}
