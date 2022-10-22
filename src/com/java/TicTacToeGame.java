package com.java;

public class TicTacToeGame {
    public static void main(String[] args){
        TicTacToeDetails details=new TicTacToeDetails();
        PlayerMethods playerMethods=new PlayerMethods();
        System.out.println(" Welcome to Tic-Tac-Toe\n=========================\n"+details.toString());
        playerMethods.board();
        playerMethods.Player1();
        playerMethods.Player2();
        //System.out.println(details.getBoard());
    }
}
