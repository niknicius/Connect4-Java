package io.github.niknicius.lig4;

public class Computer implements Player {

    private char character;
    private int score;

    public Computer(char character) {
        this.character = character;
        this.score = 0;
    }

    public char getCharacter() {
        return character;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
