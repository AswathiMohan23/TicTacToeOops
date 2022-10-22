package com.java;

public class PlayerMethods {
    TicTacToeDetails details=new TicTacToeDetails();
    public void Player1(){
        System.out.println("Player1 can take : "+details.getPLAYER1());
    }
    public void Player2(){
        System.out.println("Player2 can take : "+details.getPLAYER2());
    }
    public void board(){
        displayTheBoard();
    }
    public void displayTheBoard(){
        System.out.println("\n===========Here is the board ============");
        details.setBoard();

    }
}
