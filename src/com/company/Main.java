package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static String playerNames(int player){
        System.out.print("Player " + player + " enter your name: ");
        return input.nextLine();
    }

    public static int playerWinnerCalc(String player1Name, String player2Name, String[] choice){
        int winner = 0;
        for (int i = 0; i < choice.length; i++) {
            if (choice.equals(player1Name)) {
                winner += 1;
            } else if (choice.equals(player2Name)) {
                winner -= 1;
            }
        }
        return winner;
    }

    public static void playerWins(int winner){
        if(winner > 0){
            System.out.println("Player 1 wins");
        }else if(winner < 0){
            System.out.println("Player 2 wins");
        }else{
            System.out.println("It is a draw");
        }
    }

    public static void main(String[] args) {
	    String[] choice = {"","","","","","","","","",""};
        int guess;

        String player1Name = playerNames(1);
        String player2Name = playerNames(2);

        for(int i = 0; i < (choice.length)/2; i++){
            System.out.println("Player 1 enter a number between 1 and 10: ");
            guess = input.nextInt() - 1;
            if(choice[guess].equals("")){
                choice[guess] = player1Name;
            }
            System.out.println("Player 2 enter a number between 1 and 10: ");
            guess = input.nextInt() - 1;
            if(choice[guess].equals("")){
                choice[guess] = player2Name;
            }
        }
        int winner = playerWinnerCalc(player1Name,player2Name,choice);
        playerWins(winner);
    }
}
