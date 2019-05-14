package io.github.niknicius.lig4;

import io.github.niknicius.lig4.exceptions.ColumnFullException;

class Board {

    // Line Size
    private int lines;
    // Line Numbers
    private int columns;
    private char[][] tiles;


    /**
     * @param lines number of board lines
     * @param columns number of board columns
     */
    Board(int lines, int columns){
        this.lines = lines;
        this.columns = columns;

        this.tiles = new char[lines][columns];

        for(int i = 0; i < lines; i++){
            char[] line = new char[columns];
            for(int k = 0; k < line.length; k++){
                line[k] = 'O';
            }
            this.tiles[i] = line;
        }
    }

    /**
     * Shows the board
     */
     void showBoard(){
        for(int i = 0; i < this.lines; i++){
            StringBuilder line = new StringBuilder();
            for(int k = 0; k < this.columns; k++){
                line.append(this.tiles[i][k]).append(" ");
            }
            System.out.println(line);
        }

        System.out.println(this.createDashedLine());
        System.out.println(this.createNumberLine());
    }

    /**
     * creates a dashed row to separate board from numbers
     * @return row dashed
     */
    private String createDashedLine(){
        return "- ".repeat(Math.max(0, this.columns));
    }

    /** creates a number row to show columns' index
     * @return row numbered with number of columns
     */
    private String createNumberLine(){
        StringBuilder numberLine = new StringBuilder();
        for(int i = 0; i < this.columns; i++){
            numberLine.append(i + 1).append(" ");
        }
        return numberLine.toString();
    }

    /**
     * checks if a valid move, if true, changes the tile
     * @param column column to check
     * @param playerChar char representing the player
     * @throws ColumnFullException Invalid Move Exception
     */
    int changeTile(int column, char playerChar) throws ColumnFullException {
        int line;
        if(column == 0 || column > this.columns|| !this.columnIsFree(column)) throw new ColumnFullException("Column full");
        else{
            line = insertOnColumn(column,playerChar);
        }

        return line;
    }

    /**
     * goes through the column until it finds something other than 0 and then plays the part on top
     * @param column column to be played
     * @param playerChar char representing the player
     * @return line of last column free
     */
    private int insertOnColumn(int column, char playerChar){
        int lineOfLastColumnFree = 0;
        for(int i = 0; i < this.lines; i++){
            if(i + 1 < this.lines && this.tiles[i + 1][column - 1] == 'O' ){
                lineOfLastColumnFree++;
            }
            else{
                break;
            }
        }

        this.tiles[lineOfLastColumnFree][column - 1] = playerChar;
        return lineOfLastColumnFree;
    }


    /**
     * Check if the coordinate is free
     * @param column column
     * @return true if coordinate is playable, false if not
     */
    private boolean columnIsFree(int column){
        return this.tiles[0][column - 1] == 'O';
    }


    boolean checkColumn(int line, int column, char character){
        int size = 0;
        for(int i = line; i < this.lines; i++){
            System.out.println("line " + line);
            System.out.println("column " + (column - 1));
            System.out.println("char " + character);
            if(this.tiles[i][column - 1] == character){
                size++;
                System.out.println("aqui tb");
            }
        }

        if(size == 4){
            System.out.println("DEBUG: column size" + size);
            return true;
        }
        System.out.println("DEBUG: column " + column  + " size" + size);
        return false;
    }

}
