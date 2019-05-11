package io.github.niknicius;

public class Board {

    // Line Size
    private int lines;
    // Line Numbers
    private int columns;
    private char[][] tiles;

    public Board(int lines, int columns){
        this.lines = lines;
        this.columns = columns;

        this.tiles = new char[lines][columns];

        for(int i = 0; i < lines; i++){
            char[] line = new char[columns];
            for(int k = 0; k < line.length; k++){
                line[k] = '0';
            }
            this.tiles[i] = line;
        }
    }

    public void showBoard(){
        for(int i = 0; i < this.lines; i++){
            String line = "";
            for(int k = 0; k < this.columns; k++){
                line = line + this.tiles[i][k] + " ";
            }
            System.out.println(line);
        }

        System.out.println("- - - - - - -");
        System.out.printf("1 2 3 4 5 6 7");
    }

}
