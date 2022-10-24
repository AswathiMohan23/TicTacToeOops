package com.java;

import java.util.Scanner;

public class PlayerMethods {
    //String[] gameBoard;
    Scanner sc = new Scanner(System.in);
    TicTacToeDetails details = new TicTacToeDetails();
    //int[][] gameBoard = {{1,2,3}, {4,5,6}, {7,8,9}};
    String[][] gameBoard = new String[][]{{"00", "01", "02"}, {"10", "11", "12"}, {"20", "21", "22"}};

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
        System.out.println("Hey " + player + " !!! choose a letter from the box [X or O]: ");
        String choice = sc.next();
        if ((player.equals("player1")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take O");
            String otherChoice = "o";
            player1(choice, "player1", otherPlayer, otherChoice);

        } else if ((player.equals("player1")) && ((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take X");
            String otherChoice = "x";
            player1(choice, "player1", otherPlayer, otherChoice);

        } else if ((player.equals("player2")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take O");
            String otherChoice = "o";
            player2(choice, "player2", otherPlayer, otherChoice);

        } else if ((player.equals("player2")) && ((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take X");
            String otherChoice = "x";
            player2(choice, "player2", otherPlayer, otherChoice);
        }
    }

    public void player1(String choice, String player, String otherPlayer, String otherChoice) {
        System.out.println("Hey player1 !!! its you turn");
        System.out.println("enter the position");
        String position = sc.next();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j].equals(position)) {
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
        player2(choice, player, otherPlayer, otherChoice);

    }

    public void player2(String choice, String player, String otherPlayer, String otherChoice) {
        System.out.println("Hey player2 !!! its you turn");
        System.out.println("enter the position");
        String position = sc.next();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j].equals(position)) {
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
        player2(choice, player, otherPlayer, otherChoice);
    }


    public String winners(String choice, String player, String otherPlayer) {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2];
                    break;
                case 1:
                    line = gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2];
                    break;
                case 2:
                    line = gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2];
                    break;
                case 3:
                    line = gameBoard[0][0] + gameBoard[1][1] + gameBoard[1][2];
                    break;
                case 4:
                    line = gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1];
                    break;
                case 5:
                    line = gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2];
                    break;
                case 6:
                    line = gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0];
                    break;
                case 7:
                    line = gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][2];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        return choice;
    }
}
