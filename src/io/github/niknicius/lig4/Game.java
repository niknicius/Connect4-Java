package io.github.niknicius.lig4;

public class Game {

    public static void main(String[] args){
        Board board = new Board(6,7);
        board.showBoard();

        try{
            board.changeTile(2, 'x');
            board.changeTile(2, 'x');
            board.changeTile(2, 'x');
            board.changeTile(2, 'x');
            board.changeTile(2, 'x');
            board.changeTile(6, 'x');
            board.changeTile(2, 'x');
            board.changeTile(2, 's');
            board.showBoard();
        }catch (Exception ex){
            board.showBoard();
            System.out.println(ex.getMessage());
        }
    }
}
