package com.java;

import java.util.Scanner;

public class PlayerMethods {
    TicTacToeDetails details=new TicTacToeDetails();
    public void chooseLetter(){
        Scanner sc=new Scanner(System.in);
        int randomCheck= (int) (Math.random()*(2-1+1)+1);//Math.random()*(max-min+1)+1;
        switch (randomCheck) {
            case 1:
                System.out.println("Hey player1!!! choose a letter from the box [X or O]: ");
                String choice1 = sc.next();
                if ((choice1.equals("x")) || (choice1.equals("X"))){
                    details.setPLAYER1(choice1.toUpperCase());
                    System.out.println("Player1 has chosen " + details.getPLAYER1() + " so player2 can take O");
                }else if((choice1.equals("O"))||(choice1.equals("O"))) {
                    details.setPLAYER1(choice1.toUpperCase());
                    System.out.println("Player1 has chosen " + details.getPLAYER2() + " so player2 can take X");
                }
                break;
            case 2:
                System.out.println("Hey player2!!! choose a letter from the box [X or O]: ");
                String choice2=sc.next();
                if ((choice2.equals("x")) || (choice2.equals("X"))){
                    details.setPLAYER2(choice2.toUpperCase());
                    System.out.println("Player2 has chosen " + details.getPLAYER2() + " so player1 can take O");
                }else if((choice2.equals("o"))||(choice2.equals("O"))) {
                    details.setPLAYER2(choice2.toUpperCase());
                    System.out.println("Player2 has chosen " + details.getPLAYER2() + " so player1 can take X");
                }break;
            default:
                System.out.println("invalid entry ..... Try again!!!");
                break;


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
