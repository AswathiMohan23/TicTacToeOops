package com.java;

import java.util.Scanner;

public class PlayerMethods {
    Scanner sc = new Scanner(System.in);
    TicTacToeDetails details = new TicTacToeDetails();

    public void chooseLetter() {
        int randomCheck = (int) (Math.random() * (2 - 1 + 1) + 1);//Math.random()*(max-min+1)+1;
        switch (randomCheck) {
            case 1:
                System.out.println("Hey player1!!! choose a letter from the box [X or O]: ");
                String choice1 = sc.next();
                String otherPlayer="player2";
                String player="player1";
                selectChoice(choice1, player,otherPlayer);
                break;
            case 2:
                System.out.println("Hey player2!!! choose a letter from the box [X or O]: ");
                String choice2 = sc.next();
                otherPlayer="player1";
                player="player2";
                selectChoice(choice2, player,otherPlayer);
                break;
            default:
                System.out.println("invalid entry ..... Try again!!!");
                break;
        }
    }

    public void selectChoice(String choice, String player, String otherPlayer) {
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
                System.out.println("player2 has chosen " + details.getPLAYER2() + " so " + otherPlayer + " can take O");
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
