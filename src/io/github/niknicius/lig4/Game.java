package io.github.niknicius.lig4;

import io.github.niknicius.lig4.exceptions.ColumnFullException;
import io.github.niknicius.lig4.exceptions.InvalidMoveException;

import java.util.Random;
import java.util.Scanner;

class Game {

    private int columns;
    private Player player1;
    private Player player2;
    private Board board;
    private int currentRound;
    private Scanner scan;

    private static int MAX_ROUNDS;
    private static final boolean DEBUG_ON = true;

    Game(int lines, int columns){
        MAX_ROUNDS = lines*columns;
        this.columns = columns;
        this.board = new Board(lines,columns);
        this.player1 = new Human('®');
        this.player2 = new Computer('©');
        this.currentRound = 0;
        this.scan = new Scanner(System.in);
    }

    private int[] inputHumanPlay(){
        int[] coordinates = new int[2];
        System.out.println("Choose a column (1-"+ this.columns + "):");
        String column = this.scan.nextLine();
        int columnNumber;
        while(true){
            try{
                columnNumber = Integer.parseInt(column);
                if(columnNumber > this.columns || columnNumber <= 0){
                    throw new InvalidMoveException("Column Invalid");
                }
                int line = this.board.changeTile(columnNumber, this.player1.getCharacter());
                coordinates[0] = line;
                coordinates[1] = columnNumber;
                return coordinates;
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

    private void computerRandomPlay(){
        Random random = new Random();
        int pcColumn = random.nextInt(7) + 1;
        while(true){
            try{
                if(pcColumn > this.columns || pcColumn <= 0){
                    throw new InvalidMoveException("Column Invalid");
                }
                this.board.changeTile(pcColumn, this.player2.getCharacter());
                break;
            }
            catch (NumberFormatException | InvalidMoveException e){
                if(DEBUG_ON){
                    System.err.println(e.getMessage());
                }
            }
            catch (ColumnFullException ex){
                System.err.println("Column is full, Choose a another column (1-"+ this.columns + "):");
                pcColumn = random.nextInt(7) + 1;
            }
        }
    }

    private boolean verifyWin(int line, int column, char playerChar){
        boolean columnSizeIs4 = this.board.checkColumn(line,column, playerChar);
        if(columnSizeIs4){
            System.out.println("WIN");
            return true;
        }
        System.out.println("NOT WIN");
        return false;
    }

    void play(){
        while(this.currentRound < MAX_ROUNDS){
            this.board.showBoard();
            int[] humanCoordinates = this.inputHumanPlay();
            boolean win = verifyWin(humanCoordinates[0], humanCoordinates[1], this.player1.getCharacter());
            if(win){
                break;
            }
            this.currentRound++;
            System.out.println(" ");
            this.board.showBoard();
            this.computerRandomPlay();
            System.out.println(" ");
            this.currentRound++;
        }
    }
}
