package com.java;

public class TicTacToeDetails {
    int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
    private final String PLAYER1="X";
    private final String PLAYER2="O";


    public int[][] getBoard() {
        return board;
    }

    public void setBoard() {
        for(int i=0;i<3;i++)
        {
            System.out.println();
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+"\t");
            }
        }
        System.out.println("\n");
    }



    public String getPLAYER1() {
        return PLAYER1;
    }

    public String getPLAYER2() {
        return PLAYER2;
    }

}
