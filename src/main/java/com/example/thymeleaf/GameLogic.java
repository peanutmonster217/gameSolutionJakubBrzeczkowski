package com.example.thymeleaf;

public class GameLogic {

    public Person[] Persons = new Person[2];
    public Board board;
    public int lastColumn = -1;
    public int lastRow = -1;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    private int column;

    public GameLogic(){}

    public void addPersonOne(Person Person){
        Persons[0] = Person;
    }

    public void addPersonTwo(Person Person){
        Persons[1] = Person;
    }

    public void addPiece(Person person, int col){
        for (int i = board.getX() - 1; i >= 0; i--){
            if(board.getBoardArray()[i][column] == '.'){
                board.getBoardArray()[lastRow = i][lastColumn = col] = person.getToken();
                return;
            }
        }
    }

    public Board startGame(){
        board = new Board(6,9);
        board.setUpBoard();
        return board;
    }

    public String getVerticalLine(){
        StringBuilder verticalString = new StringBuilder(6);
        for(int i = 0; i < 6; i++){
            verticalString.append(board.getBoardArray()[i][lastColumn]);
        }
        return verticalString.toString();
    }

    public String getHorizontalLine(){
        return new String(board.getBoardArray()[lastRow]);
    }

    public String getRightDiagonalLine(){
        StringBuilder diagonalString = new StringBuilder(6);
        for(int i = 0; i < 6; i++){
            int horizontalPos = lastColumn + lastRow - i;

            if( 0 <= horizontalPos && horizontalPos < 9){
                diagonalString.append(board.getBoardArray()[i][horizontalPos]);
            }
        }
        return diagonalString.toString();
    }

    public String getLeftDiagonalLine(){
        StringBuilder diagonalString = new StringBuilder(6);
        for(int i = 0; i < 6; i++){
            int horizontalPos = lastColumn - lastRow + i;

            if( 0 <= horizontalPos && horizontalPos < 9){
                diagonalString.append(board.getBoardArray()[i][horizontalPos]);
            }
        }
        return diagonalString.toString();
    }

    public static boolean checkStringForWin(String fullLine, String checkLine){
        return fullLine.indexOf(checkLine) >= 0;
    }

    public boolean isWin() {
        if(lastColumn == -1){
            return false;
        }

        char token = board.getBoardArray()[lastRow][lastColumn];
        String checkLine = String.format("%c%c%c%c%c", token, token, token, token, token);
        return checkStringForWin(getHorizontalLine(), checkLine) ||
                checkStringForWin(getVerticalLine(), checkLine) ||
                checkStringForWin(getRightDiagonalLine(), checkLine) ||
                checkStringForWin(getLeftDiagonalLine(), checkLine);
    }

    private boolean checkValidColumn(int columnNo){
        if(0<= columnNo && columnNo < 8)
            return true;
        else
            return false;
    }

    private void addToken(char token, int columnNo){
        if(checkValidColumn(columnNo) == true) {
            for (int i = 5; i >= 0; i--) {
                if (board.getBoardArray()[i][columnNo] == '.') {
                    board.getBoardArray()[lastRow = i][lastColumn = columnNo] = token;
                    return;
                } else {
                    //please choose again message
                }
            }
        }
    }

}
