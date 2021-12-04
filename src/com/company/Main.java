package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Force4 game = new Force4();
        int choice;
        int moveCounter = 0;

        System.out.println(game);
        for(int i = 1; i < 43; i++) {
            if(i % 2 != 0) {
                choice = insertInt(ANSI_RED + "Giocatore " + game.currentPlayer + ANSI_RESET+ " scegli la colonna:");
            } else {
                choice = insertInt(ANSI_YELLOW + "Giocatore " + game.currentPlayer + ANSI_RESET+ " scegli la colonna:");
            }
                game.play(choice);
                moveCounter ++;
                System.out.println(game);
                if (game.getGameStatus()) {
                    if (i%2 != 0) System.out.println("Il" +ANSI_RED + " giocatore " + game.currentPlayer + ANSI_RESET + " ha vinto alla " + i + " ° mossa");
                    if (i%2 == 0) System.out.println("Il" + ANSI_YELLOW + " giocatore " + game.currentPlayer + ANSI_RESET + " ha vinto alla " + i + " ° mossa");
                    game.setGrid();
                    break;
                }
        }
    }


    public static int insertInt (String mex){
        Scanner input = new Scanner(System.in);
        System.out.println(mex);
        return input.nextInt();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
}










