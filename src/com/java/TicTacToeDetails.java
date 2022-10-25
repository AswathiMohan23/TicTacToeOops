package com.java;

public class TicTacToeDetails {
   // char [][] gameBoard = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    //String[][] gameBoard=new String[4][4];
    //private String[][] gameBoard=new String[][]{{"00","01","02"}, {"10","11","12"}, {"20","21","22"}};
   // private String[][] gameBoard = new String[3][3];
    //private String[][] gameBoard=new String[][]{{"a","b","c"}, {"d","e","f"}, {"g","h","i"}};
    private String[][] gameBoard=new String[][]{{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};


    private String PLAYER1;
    private String PLAYER2;


    /* public void setGameBoard(int[][] gameBoard,int position,String choice) {
         while(position!=0){
         for(int i=0;i<position;i++)
         {
             System.out.println();
             for(int j=0;j<position;j++)
             {
                 board[position][position]= Integer.parseInt(choice);
                 System.out.print(board[position][position]+"\t");


             }
         }
         System.out.println("\n");
     }
         }
 */


    public void setBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + "\t");


            }
        }
        System.out.println("\n");

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