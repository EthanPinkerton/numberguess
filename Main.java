package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static String playerNames(int player){
        System.out.print("Player " + player + " enter your name: ");
        return input.nextLine();
    }

    public static int playerInput(String player){
        int guess = 0;
        while(guess < 1 || guess > 10){
            System.out.print(player + " enter a number between 1 and 10: ");
            try {
                guess = input.nextInt() - 1;
            }catch (InputMismatchException e){
                input.next();
                guess = 0;
            }
        }
        return guess;
    }

    public static void playerWins(int winner, String player1Name, String player2Name){
        if(winner > 0){
            System.out.println(player1Name + " wins!");
        }else if(winner < 0){
            System.out.println(player2Name + "wins!");
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

            guess = playerInput(player1Name);
            if(choice[guess].equals("")){
                choice[guess] = player1Name;
            }
            guess = playerInput(player2Name);
            if(choice[guess].equals("")){
                choice[guess] = player2Name;
            }
        }
        int winner = 0;
        for (String s : choice) {
            if (s.equals(player1Name)) {
                winner += 1;
            } else if (s.equals(player2Name)) {
                winner -= 1;
            }
        }
        playerWins(winner, player1Name, player2Name);
    }
}
