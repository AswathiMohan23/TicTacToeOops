package com.java;

import java.util.Scanner;

public class PlayerMethods {
    Scanner sc = new Scanner(System.in);
    TicTacToeDetails details = new TicTacToeDetails();
    //public String[][] gameBoard = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    public String[][] gameBoard = details.getGameBoard();

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
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ HERE IS THE BOARD @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        details.setGameBoard();
    }

    public void board() {
        displayInitialBoard();
    }

    public void selectChoice(String player, String otherPlayer) {
        String win=null;
        System.out.println("################################## Hey " + player + " !!! choose a letter from the box [X or O]: ##############################################");
        String choice = sc.next();
        if ((player.equals("player1")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("\nplayer1 has chosen =====> " + details.getPLAYER1() + " ....so " + otherPlayer + " can take =====> O");
            String otherChoice = "o";
            game(choice, "player1", otherPlayer, otherChoice);

        } else if ((player.equals("player1")) && ((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("\nplayer1 has chosen =====>" + details.getPLAYER1() + " ....so " + otherPlayer + " can take =====> X");
            String otherChoice = "x";
            game(choice, "player1", otherPlayer, otherChoice);

        } else if ((player.equals("player2")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("\nplayer2 has chosen =====> " + details.getPLAYER2() + " ....so " + otherPlayer + " can take =====> O");
            String otherChoice = "o";
            game(choice, "player2", otherPlayer, otherChoice);

        } else if ((player.equals("player2")) && ((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("\nplayer2 has chosen =====> " + details.getPLAYER2() + " ....so " + otherPlayer + " can take =====> X");
            String otherChoice = "x";
            game(choice, "player2", otherPlayer, otherChoice);
        }
    }
    public void players(String choice, String player, String otherPlayer, String otherChoice){
        String condition=winningConditions();
        if ((condition.equals("XXX")) || (condition.equals("OOO"))) {
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CONGRATS "+otherPlayer+"!!! you won the game @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            playAgain();
        }else
            if(player.equals("player1")) {
                 System.out.println("\n====================================================  Hey player1 !!! its you turn ====================================================");
                 game(choice, player, otherPlayer, otherChoice);
            } else if (player.equals("player2")) {
                System.out.println("\n====================================================  Hey player1 !!! its you turn ====================================================");
                game(choice, player, otherPlayer, otherChoice);
        }
    }
    public void game(String choice, String player, String otherPlayer, String otherChoice) {
        String condition =winningConditions();
        while ((condition != "XXX") || (condition != "OOO")) {
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
            players(choice, player, otherPlayer, otherChoice);
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
        return "Nobody Won";
    }
    public void playAgain() {
        PlayerMethods methods=new PlayerMethods();
        System.out.println("choose the options : \n 1: play again\n 2:stop playing");
        int options=sc.nextInt();
        if(options==1){
            System.out.println("\n \t\t\t\t\t\t\tOKAY!!! LETS PLAY AGAIN!!!!!!");
            System.out.println("  \t\t\t\t\t\t\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= ");

            methods.board();
            methods.chooseLetter();
        }else{
            System.out.println("you have stopped playing the game... bye bye");
            while(true);}
    }
   }