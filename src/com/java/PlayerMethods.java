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
        win =winningConditions();
        System.out.println("win : "+win);
        if ((win.equals("XXX")) || (win.equals("OOO"))) {
            System.out.println("Congrats player2!!! you won the game");
        }
        while ((win != "XXX") || (win != "OOO")) {
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



    public void player2(String choice, String player, String otherPlayer, String otherChoice,String win){
            win = winningConditions();
            System.out.println("win : " + win);
        if ((win.equals("XXX")) || (win.equals("OOO"))) {
            System.out.println("Congrats player1!!! you won the game");
        }
            while ((win != "XXX") || (win != "OOO")) {
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
            }if ((win.equals("XXX")) || (win.equals("OOO"))) {
            System.out.println("Congrats player2oooooooooo!!! you won the game");
        }

    }


    public String winningConditions() {
        String row1 = (gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2]);
        String row2 = (gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2]);
        String row3 = (gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2]);
        if ((row1 != "XXX") || (row1 != "OOO")){
            System.out.println(row1);
            return row1;}
        else if ((row2 != "XXX") || (row2 != "OOO")){
            System.out.println(row2);
        return row2;}
        else if ((row3 != "XXX") || (row3 != "OOO")){
            System.out.println(row3);
            return row3;}
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