package org.example.service;

import org.example.model.PlayableIcon;
import org.example.model.Player;

import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Scanner scanner;
    private Board board;

    public Game() {

        this.player1 = new Player("Avinash", PlayableIcon.CIRCLE);
        this.player2 = new Player("Shashank", PlayableIcon.CROSS);
        scanner = new Scanner(System.in);

    }

    public void start() {

        // Get board size
        System.out.println("Enter board size: ");
        int size = scanner.nextInt();

        if(isSizeValid(size))
            board = new Board(size, player1, player2);
        else
            System.out.println("Invalid size entered try again!");
    }

    private boolean isSizeValid(int size) {
        return size > 1;
    }

}
