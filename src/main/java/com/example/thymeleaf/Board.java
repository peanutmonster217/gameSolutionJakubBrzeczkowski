package com.example.thymeleaf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
public class Board {

    private @Id
    @GeneratedValue
    Long id;

    private char[][] boardArray;
    private int x;
    private int y;
    private int lastRow = -1;
    private int lastColumn = -1;

    public Board() {}
    public Board(int x, int y){
        this.x = x;
        this.y = y;
        boardArray = new char[x][y];
    }

    public char[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(char[][] boardArray) {
        this.boardArray = boardArray;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(int lastColumn) {
        this.lastColumn = lastColumn;
    }

    public char[][] setUpBoard(){
        x = x;
        y = y;
        boardArray = new char[x][];
        for(int i = 0; i < x; i++){
            Arrays.fill(boardArray[i] = new char[y], '.');
        }
        return boardArray;
    }

}
