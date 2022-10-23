package com.java;

import java.util.Scanner;

public class PlayerMethods {
    //String[] gameBoard;
    Scanner sc = new Scanner(System.in);
    TicTacToeDetails details = new TicTacToeDetails();
    //int[][] gameBoard = {{1,2,3}, {4,5,6}, {7,8,9}};
    String[][] gameBoard=new String[][]{{"00","01","02"}, {"10","11","12"}, {"20","21","22"}};
    public void chooseLetter() {
        int randomCheck = (int) (Math.random() * (2 - 1 + 1) + 1);//Math.random()*(max-min+1)+1;
        switch (randomCheck) {
            case 1:
                String otherPlayer="player2";
                selectChoice("player1",otherPlayer);
                break;
            case 2:
                otherPlayer="player1";
                selectChoice("player2",otherPlayer);
                break;
            default:
                System.out.println("invalid entry ..... Try again!!!");
                break;
        }
    }
    public void displayInitialBoard(){
        System.out.println("\n===========Here is the board ============");
        details.setBoard();

    }
    public void board(){
        displayInitialBoard();
    }

    public void selectChoice(String player, String otherPlayer) {
        System.out.println("Hey "+player+" !!! choose a letter from the box [X or O]: ");
        String choice = sc.next();
        if ((player.equals("player1")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take O");
            game(choice,"player2",otherPlayer);

        }else if ((player.equals("player1"))&&((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take X");
            game(choice,"player2", otherPlayer);

        }
       else if ((player.equals("player2")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take O");
            game(choice,"player2", otherPlayer);

        } else if ((player.equals("player2"))&&((choice.equals("o")) || (choice.equals("O")))) {
                details.setPLAYER2(choice.toUpperCase());
                System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take X");
                game(choice,"player2", otherPlayer);
            }
        }

    public void game(String choice, String player, String otherPlayer){
        System.out.println(player+" !!! its you turn");
        System.out.println("enter the position");
        int position=sc.nextInt();
        String point= String.valueOf(position);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(gameBoard[i][j].equals(point)){
                    gameBoard[i][j]=choice.toUpperCase();
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
    }

    public void displayGameBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + "\t");


            }
        }
        System.out.println("\n");

    }

}
