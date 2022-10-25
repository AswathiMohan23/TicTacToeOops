package com.java;

import java.util.Scanner;

public class PlayerMethods {
    static int p = 0;
    Scanner sc = new Scanner(System.in);
    TicTacToeDetails details = new TicTacToeDetails();
    //int[][] gameBoard = {{1,2,3}, {4,5,6}, {7,8,9}};
    // String[][] gameBoard = new String[][]{{"00", "01", "02"}, {"10", "11", "12"}, {"20", "21", "22"}};
    //String[][] gameBoard = new String[3][3];
    String point[] = new String[9];
    public String[][] gameBoard = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    public void chooseLetter() {
        int randomCheck = (int) (Math.random() * (2 - 1 + 1) + 1);//Math.random()*(max-min+1)+1;
        switch (randomCheck) {
            case 1:
                String otherPlayer = "player2";
                selectChoice("player1", otherPlayer);
                break;
            case 2:
                otherPlayer = "player1";
                selectChoice("player2", otherPlayer);
                break;
            default:
                System.out.println("invalid entry ..... Try again!!!");
                break;
        }
    }

    public void displayInitialBoard() {
        System.out.println("\n===========Here is the board ============");
        details.setBoard();

    }

    public void board() {
        displayInitialBoard();
    }

    public void selectChoice(String player, String otherPlayer) {
        String win=null;
        System.out.println("Hey " + player + " !!! choose a letter from the box [X or O]: ");
        String choice = sc.next();
        if ((player.equals("player1")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take O");
            String otherChoice = "o";
            player1(choice, "player1", otherPlayer, otherChoice,win);

        } else if ((player.equals("player1")) && ((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take X");
            String otherChoice = "x";
            player1(choice, "player1", otherPlayer, otherChoice,win);

        } else if ((player.equals("player2")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take O");
            String otherChoice = "o";
            player2(choice, "player2", otherPlayer, otherChoice,win);

        } else if ((player.equals("player2")) && ((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take X");
            String otherChoice = "x";
            player2(choice, "player2", otherPlayer, otherChoice,win);
        }
    }

    public void player1(String choice, String player, String otherPlayer, String otherChoice,String win) {
        String condition=win;
        condition =winningConditions();
        System.out.println("win : " + win);

        if ((condition.equals("XXX")) || (condition.equals("OOO"))) {
            System.out.println("Congrats player2!!! you won the game");
            playAgain();
        }
        while ((condition != "XXX") || (condition != "OOO")) {
            System.out.println("Hey player1 !!! its you turn");
            System.out.println("enter the position");
            String position = sc.next();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((gameBoard[i][j].equals(position))) {
                        gameBoard[i][j] = choice.toUpperCase();
                        System.out.print(gameBoard[i][j] + "\t");
                    }
                }
            }
            System.out.println("board is : ");
            for (int i = 0; i < 3; i++) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    System.out.print(gameBoard[i][j] + "\t");
                }
            }
            String temp = choice;
            choice = otherChoice;
            otherChoice = temp;
            temp = otherPlayer;
            otherPlayer = player;
            player = temp;
            player2(choice, player, otherPlayer, otherChoice, win);
            }
        }

    public void playAgain() {
        PlayerMethods methods=new PlayerMethods();
        System.out.println("choose the options : \n 1: play again\n 2:stop playing");
        int options=sc.nextInt();
        if(options==1){
            methods.board();
            methods.chooseLetter();
        }
    }

    public void player2(String choice, String player, String otherPlayer, String otherChoice,String win){
        String condition=win;
        condition =winningConditions();
        System.out.println("win : " + win);

        if ((condition.equals("XXX")) || (condition.equals("OOO"))) {
            System.out.println("Congrats player1!!! you won the game");
            playAgain();
        }
        while ((condition != "XXX") || (condition != "OOO")) {
                System.out.println("Hey player2 !!! its you turn");
                System.out.println("enter the position");
                String position = sc.next();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if ((gameBoard[i][j].equals(position))) {
                            if ((gameBoard[i][j].equals(position))) {
                                gameBoard[i][j] = choice.toUpperCase();
                                System.out.print(gameBoard[i][j] + "\t");
                            }
                        }
                    }
                }
                System.out.println("board is : ");
                for (int i = 0; i < 3; i++) {
                    System.out.println();
                    for (int j = 0; j < 3; j++) {
                        System.out.print(gameBoard[i][j] + "\t");
                    }
                }
                String temp = choice;
                choice = otherChoice;
                otherChoice = temp;
                temp = otherPlayer;
                otherPlayer = player;
                player = temp;
                player1(choice, player, otherPlayer, otherChoice, win);
            }
    }


    public String winningConditions() {
        String row1 = (gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2]);
        String row2 = (gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2]);
        String row3 = (gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2]);
        String colum1 = (gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0]);
        String colum2 = (gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1]);
        String colum3 = (gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2]);
        String leftRightDiagonal=(gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]);
        String rightLeftDiagonal=(gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]);

        if ((row1.equals("XXX") || (row1.equals("OOO")))){
            System.out.println(row1);
            return row1;
        }
        else if ((row2.equals("XXX") || (row2.equals("OOO")))){
            System.out.println(row2);
            return row2;
        }
        else if ((row3.equals("XXX") || (row3.equals("OOO")))){
            System.out.println(row3);
            return row3;}
        else if ((colum1.equals("XXX") || (colum1.equals("OOO")))) {
            System.out.println(colum1);
            return colum1;
        }else if ((colum2.equals("XXX") || (colum2.equals("OOO")))){
            System.out.println(colum2);
            return colum2;
        }
        else if ((colum3.equals("XXX") || (colum3.equals("OOO")))){
            System.out.println(colum3);
            return colum3;
        }else if ((leftRightDiagonal.equals("XXX") || (leftRightDiagonal.equals("OOO")))){
            System.out.println(leftRightDiagonal);
            return leftRightDiagonal;
        }else if ((rightLeftDiagonal.equals("XXX") || (rightLeftDiagonal.equals("OOO")))){
            System.out.println(rightLeftDiagonal);
            return rightLeftDiagonal;
        }
        return "null";
    }
   /* public String winningConditions() {
        System.out.println("1");
        if ((((gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2])) == "XXX") || (((gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2])) == "XXX")
                || (((gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2])) == "XXX") || (((gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2])) == "XXX") ||
                (((gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0])) == "XXX") || (((gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0])) == "XXX")
                || (((gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1])) == "XXX") || (((gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2])) == "XXX")) {

            System.out.println("You won the game");

            System.out.println("2");
            return "won";
        } else if ((((gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2])) == "OOO") || (((gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2])) == "OOO")
                || (((gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2])) == "OOO") || (((gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2])) == "OOO") ||
                (((gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0])) == "OOO") || (((gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0])) == "OOO")
                || (((gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1])) == "OOO") || (((gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2])) == "OOO")) {
            System.out.println("You won the game");
            System.out.println("3");
            return "won";
        }

        return null;
    }*/

}