package org.example.service;

import org.example.model.PlayableIcon;
import org.example.model.Player;

import java.util.Scanner;

import static java.lang.System.exit;

public class Board {

    private final int size;
    private PlayableIcon[][] board;
    private Scanner scanner;
    private Player player1;
    private Player player2;

    public Board(int size, Player player1, Player player2) {
        this.size = size;
        this.player1 = player1;
        this.player2 = player2;

        scanner = new Scanner(System.in);

        System.out.println("Starting Game...");
        generateCleanBoard();
        printBoard();

        initialise();
    }

    public void initialise() {

        int i = 0;
        while(!isBoardFull()) {

            Player currentPlayer = printCurrentPlayerInfo(i);

            System.out.println("Enter the position of board to move your pawn: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(isValid(x, y) && movePlayer(x, y, currentPlayer)) {
                printBoard();

                // Check if player has won
                if(checkWins(currentPlayer)) {
                    System.out.println(currentPlayer.getName() + " Won!!!");

                    System.out.println("Want to restart? Default No [Y/N]: ");
                    scanner.nextLine();
                    String response = scanner.nextLine().toUpperCase();

                    if (response.equals("Y")) {
                        System.out.println("Starting new game!");
                        i = 0;
                        generateCleanBoard();
                    } else if (response.equals("N")) {
                        System.out.println("Thank you for playing, come back soon!");
                        exit(0);
                    }
                    else {
                        System.out.println("Invalid response, ending game...");
                        exit(0);
                    }
                }

                i++;
            }
            else {
                System.out.println("Can not place pawn to this location. Please try again!");
            }
        }

        System.out.println("It's a draw!");

    }

    private boolean isValid(int x, int y){

        return x >= 0 && x < size && y >= 0 && y < size;

    }

    private void generateCleanBoard() {
        board = new PlayableIcon[size][size];

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                board[i][j] = null;
    }

    private boolean isBoardFull() {

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if(board[i][j] == null)
                    return false;

        return true;

    }

    private void printBoard() {

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {

                String icon = "  ";
                if(board[i][j] != null)
                    icon = board[i][j].getValue();

                if(j == 0)
                    System.out.print("| " + icon + " |");
                else
                    System.out.print(" " + icon + " |");

            }

            System.out.println();
        }

    }

    private boolean movePlayer(int x, int y, Player player){

        if(board[x][y] != null)
            return false;

        board[x][y] = player.getPlayableIcon();
        return true;
    }

    private Player printCurrentPlayerInfo(int i) {
        if(i %2 == 0) {
            System.out.println(player1.getName() + "'s Turn!");
            return player1;
        }
        else {
            System.out.println(player2.getName() + "'s' Turn!");
            return player2;
        }
    }

    private boolean checkWins(Player player) {

        String currentIcon = player.getPlayableIcon().getValue();
        boolean isWin = false;
        int count = 0;

        // RIGHT -> LEFT
        for(int i=0; i<size; i++) {

            count = 0;
            for(int j=0; j<size; j++) {

                if(board[i][j]!= null && currentIcon == board[i][j].getValue())
                    count++;

            }

            if(count == size)
                isWin = true;
        }

        if(isWin) return true;

        // TOP -> BOTTOM
        for(int i=0; i<size; i++) {

            count = 0;
            for(int j=0; j<size; j++) {

                if(board[j][i] != null && currentIcon == board[j][i].getValue())
                    count++;

            }

            if(count == size)
                isWin = true;
        }

        if(isWin) return true;

        // Right Diagonal
        count = 0;
        for(int i=0; i<size; i++) {

            if (board[i][i]!= null && currentIcon == board[i][i].getValue()) {
                count ++;
            }

        }

        if(count == size) return true;

        // Left Diagonal
        count = 0;
        for(int i=0; i<size; i++) {

            if (board[i][(size-i-1)]!= null && currentIcon == board[i][(size-i-1)].getValue()) {
                count++;
            }
        }

        return count == size;

    }

}
