package com.java;

public class TicTacToeDetails {
   private String[][] gameBoard=new String[][]{{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
    private String PLAYER1;
    private String PLAYER2;

    public void setGameBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();

            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + "\t");
            }
        }
        System.out.println("\n");
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public String getPLAYER1() {
        return PLAYER1;
    }

    public void setPLAYER1(String PLAYER1) {
        this.PLAYER1 = PLAYER1;
    }

    public String getPLAYER2() {
        return PLAYER2;
    }

    public void setPLAYER2(String PLAYER2) {
        this.PLAYER2 = PLAYER2;
    }





}