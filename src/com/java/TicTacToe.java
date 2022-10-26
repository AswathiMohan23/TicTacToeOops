package com.java;

public class TicTacToe {
    public static void main(String[] args){
        TicTacToeDetails details=new TicTacToeDetails();
        PlayerMethods playerMethods=new PlayerMethods();
        System.out.println(" Welcome to Tic-Tac-Toe\n=========================\n");
        playerMethods.board();
        playerMethods.chooseLetter();
    }
}
