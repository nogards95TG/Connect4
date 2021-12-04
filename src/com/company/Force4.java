package com.company;
import java.util.Scanner;

public class Force4 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    enum PlayerXO {uno, due};
    PlayerXO[][] grid = new PlayerXO[6][7];
    PlayerXO currentPlayer = PlayerXO.uno;
    int moveCounter = 0;
    boolean gameIsOver = false;


    public String toString() {

        String output = "";
        System.out.println(columnNumber());
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                output += ANSI_BLUE+"|"+ANSI_RESET;
                output += this.grid[i][j] != null ? this.grid[i][j] == PlayerXO.uno ? ANSI_RED+ "0"+ANSI_RESET : ANSI_YELLOW+ "0"+ANSI_RESET : " "+ANSI_RESET;
                output += ANSI_BLUE+"|"+ANSI_RESET;
            }
            output += "\n";
        }
        return output;
    }

    public void play(int choice) {

        int row = -1;
        for (int i = 5; i >= 0; i--) {
            if (this.grid[i][choice-1] == null) {
                this.grid[i][choice - 1] = this.currentPlayer;
                    row = i;
                    break;
            }
        }
        moveCounter ++;
        if (moveCounter >= 7 && row != -1) {
            if (hasWin(row, choice-1)) gameIsOver = true;
        }
        if (!gameIsOver) {
            this.currentPlayer = this.currentPlayer == PlayerXO.uno ? PlayerXO.due : PlayerXO.uno;
        }
    }

    private boolean checkColumn(int column) {

        int count = 0;
        for (int row = 0; row < this.grid.length; row++) {
            if (this.grid[row][column] == this.currentPlayer) {
                count ++;
            }
            else count = 0;
            if (count == 4) return true;
        }
        return false;
    }

    private boolean checkRow(int row) {

        int count = 0;
        for (int column = 0; column < this.grid[row].length; column++) {
            if (this.grid[row][column] == this.currentPlayer) {
                count ++;
            }
            else count = 0;
            if (count == 4) return true;
        }
        return false;
    }

    private boolean roundBlock(int row, int column) {
        int count = 0;
        for (int y = column, x = row; y <= column + 3 && x <= row + 3;x++, y++) {
                if (this.grid[x][y] == this.currentPlayer) {
                    count++;
                }
                if (count == 4) return true;
            }

        count = 0;

        for (int y = column + 3, x = row; y >= column - 3 && x <= row + 3;x++, y--) {
            if (this.grid[x][y] == this.currentPlayer){
                count ++;
            }
            if (count == 4) return true;
        }
    return false;
    }

    private boolean checkDiagonal() {

        for (int column = 0; column <= 3; column++) {
            for (int row = 0; row <= 2; row++) {
                if (roundBlock(row, column)) return true;
            }
        }
        return false;
    }

    private boolean hasWin ( int row, int column){
        return checkRow(row) || checkColumn(column) || checkDiagonal();
    }

    public boolean getGameStatus () {
        return gameIsOver;
    }

    public void setGrid () {
        for (int row = 0; row < this.grid.length; row++) {
            for (int column = 0; column < this.grid[row].length; column++) {
                this.grid[row][column] = null;
            }
        }
    }

    private String columnNumber () {
        return " 1  2  3  4  5  6  7";
    }

}

