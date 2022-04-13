package de.swm;

public class Board {
    private final char[][] board;


    public Board(char[][] board) {
        this.board = board;
    }


    public void initialize() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '~';

            }
        }
    }

    public void showBoard(){
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print( board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean setShips(int length, int positioning, int coordinatesStart, int orientation, int coordinatesEnd, char shipType) {
        if (checkValidPlacement(length, coordinatesStart, coordinatesEnd, orientation, positioning))
            if (positioning == 1) {
                for (int i = coordinatesStart; i < coordinatesEnd; i++) {
                    board[i][orientation] = shipType;
                }
                return true;
                } else {
                    for(int i = coordinatesStart; i < coordinatesEnd; i++) {
                        board[orientation][i] = shipType;
                    }
                    return true;
            }
        return false;
    }

    public boolean checkValidPlacement(int length, int coordinatesStart, int coordinatesEnd, int orientation, int positioning) {
        if (board[coordinatesStart][orientation] != '~' || board[coordinatesEnd][orientation] != '~') {
            return false;
        }
            if (positioning == 1) {
                if (coordinatesStart + length > board.length) {
                    return false;
                }
                for (int i = 0; i < length; i++) {
                    if (coordinatesStart < 10 && (board[coordinatesStart + i][coordinatesStart + 1] != '~' || board[coordinatesStart + i][coordinatesStart] != '~')) {
                        return false;
                    } else if (coordinatesStart > 0 && (board[coordinatesStart + i][coordinatesStart - 1] != '~' || board[coordinatesStart + i][coordinatesStart] != '~')) {
                        return false;
                    }
                }
                if()
                for (int i = coordinatesStart - 1; i <= coordinatesEnd + 1; i++) {
                    if (board[i][orientation] == '~') {
                        return false;
                    }
                }
            } else if (positioning == 0) {
                if (coordinatesStart + length > 10) {
                    return false;
                }
                if (coordinatesStart + length < 9 && board[coordinatesStart][coordinatesStart + length] == 1) {
                    return false;
                }
                for (int i = 0; i < length; i++) {
                    if (coordinatesStart < 10 && (board[coordinatesStart + 1][coordinatesStart + i] == 1 || board[coordinatesStart][coordinatesStart + i] == 1)) {
                        return false;
                    } else if (coordinatesStart > 0 && (board[coordinatesStart - 1][coordinatesStart + i] == 1 || board[coordinatesStart][coordinatesStart + i] == 1)) {
                        return false;
                    }
                }
            }
        return true;
    }
}




    //TODO Check if Ship is hit, Check if able to place ship on given coordinates
