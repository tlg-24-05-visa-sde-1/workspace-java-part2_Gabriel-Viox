package com.duckrace;

public class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer1 = new DuckRacer(1,"Amir");
        racer1.win(Reward.DEBIT_CARD);
        racer1.win(Reward.DEBIT_CARD);
        System.out.println(racer1);
    }
}