package io.github.niknicius.lig4;

import io.github.niknicius.lig4.exceptions.ColumnFullException;
import io.github.niknicius.lig4.exceptions.InvalidMoveException;

import java.util.Scanner;

class Game {

    private int lines;
    private int columns;
    private Player player1;
    private Player player2;
    private Board board;
    int currentRound;
    private Scanner scan;

    private static int MAX_ROUNDS;

    Game(int lines, int columns){
        MAX_ROUNDS = lines*columns;
        this.lines = lines;
        this.columns = columns;
        this.board = new Board(lines,columns);
        this.player1 = new Human('H');
        this.player2 = new Computer('C');
        this.currentRound = 0;
        this.scan = new Scanner(System.in);
    }

    private void inputHumanPlay(){
        System.out.println("Choose a column (1-"+ this.columns + "):");
        String column = this.scan.nextLine();
        int columnNumber;
        while(true){
            try{
                columnNumber = Integer.parseInt(column);
                if(columnNumber > this.columns || columnNumber <= 0){
                    throw new InvalidMoveException("Column Invalid");
                }
                this.board.changeTile(columnNumber, this.player1.getCharacter());
                break;
            }
            catch (NumberFormatException | InvalidMoveException e){
                System.err.println("Column invalid, Choose a valid column (1-"+ this.columns + "):");
                column = this.scan.nextLine();
            }
            catch (ColumnFullException ex){
                System.err.println("Column is full, Choose a another column (1-"+ this.columns + "):");
                column = this.scan.nextLine();
            }
        }

    }

    public void play(){
        while(this.currentRound < MAX_ROUNDS){
            this.board.showBoard();
            this.inputHumanPlay();
            this.board.showBoard();
            this.currentRound++;
        }
    }
}
