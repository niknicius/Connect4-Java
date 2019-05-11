package io.github.niknicius.lig4;

public class Computer implements Player {

    private char character;
    private int score;
    private int plays;

    public Computer(char character) {
        this.character = character;
        this.score = 0;
        this.plays = 0;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }
}
