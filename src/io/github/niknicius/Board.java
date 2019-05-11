package io.github.niknicius;

public class Board {

    private int width;
    private int height;
    private char[] tiles;

    public Board(int width, int height){
        this.tiles = new char[width * height];
        for (int i = 0; i < this.tiles.length; i++){
            this.tiles[i] = '0';
        }
    }

    public void showBoard(){
        for (int i = 0; i < this.tiles.length; i++){
            System.out.println(this.tiles[i]);
        }
    }

}
