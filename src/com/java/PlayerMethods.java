package com.java;

import java.util.Scanner;

public class PlayerMethods {
    Scanner sc = new Scanner(System.in);
    TicTacToeDetails details = new TicTacToeDetails();

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

    public void selectChoice(String player, String otherPlayer) {
        System.out.println("Hey "+player+" !!! choose a letter from the box [X or O]: ");
        String choice = sc.next();
        if ((player.equals("player1")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take O");
        }else if ((player.equals("player1"))&&((choice.equals("o")) || (choice.equals("O")))) {
            details.setPLAYER1(choice.toUpperCase());
            System.out.println("player1 has chosen " + details.getPLAYER1() + " so " + otherPlayer + " can take X");
        }
       else if ((player.equals("player2")) && ((choice.equals("x")) || (choice.equals("X")))) {
            details.setPLAYER2(choice.toUpperCase());
            System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take O");
        } else if ((player.equals("player2"))&&((choice.equals("o")) || (choice.equals("O")))) {
                details.setPLAYER2(choice.toUpperCase());
                System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take X");
            }
        }



    public void Player1(){
        System.out.println("Player1 can take : "+details.getPLAYER1());
    }
    public void Player2(){
        System.out.println("Player2 can take : "+details.getPLAYER2());
    }
    public void board(){
        displayTheBoard();
    }
    public void displayTheBoard(){
        System.out.println("\n===========Here is the board ============");
        details.setBoard();

    }
}
