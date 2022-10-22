package com.java;

public class TicTacToeDetails {
    private char[]board=new char[10];
    private final String PLAYER1="X";
    private final String PLAYER2="O";

    public char[] getBoard() {
        return board;
    }

    public void setBoard(char[] board) {
        this.board = board;
    }

    public String getPLAYER1() {
        return PLAYER1;
    }

    public String getPLAYER2() {
        return PLAYER2;
    }
}
