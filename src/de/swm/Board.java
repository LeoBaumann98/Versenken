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
                for (int i = coordinatesStart; i <= coordinatesEnd; i++) {
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
        if (coordinatesEnd - coordinatesStart < length - 1) {
            return false;
        }else if (positioning == 1) {
                if (board[coordinatesStart][orientation] != '~' || board[coordinatesEnd][orientation] != '~') {
                    return false;
                }
                if (coordinatesStart + length > board.length) {
                    return false;
                }
            if (coordinatesStart == 0 || orientation == 0) {
                for (int i = coordinatesStart; i < length; i++) {
                    if ((board[i + 1][orientation] != '~' || board[i][orientation + 1] != '~')) {
                        return false;
                    }
                }
            }else {
                for (int i = coordinatesStart; i < length; i++) {
                    if ((board[i + 1][orientation] != '~' || board[i][orientation + 1] != '~')) {
                        return false;
                    } else if ((board[i - 1][orientation] != '~' || board[coordinatesStart][orientation - 1] != '~')) {
                        return false;
                    }
                }
            }
            } else if (positioning == 2) {
                if (board[orientation][coordinatesStart] != '~' || board[orientation][coordinatesEnd] != '~') {
                    return false;
                }
                if (coordinatesStart + length > board.length) {
                    return false;
                }
                if (coordinatesStart == 0 || orientation == 0) {
                    for (int i = coordinatesStart; i < length; i++) {
                        if ((board[orientation + 1][i] != '~' || board[orientation][coordinatesStart + i] != '~')) {
                            return false;
                        }
                    }
                }else {
                    for (int i = coordinatesStart; i < length; i++) {
                        if ((board[orientation + 1][i] != '~' || board[orientation][i + 1] != '~')) {
                            return false;
                        } else if ((board[orientation - 1][i] != '~' || board[orientation][i - 1] != '~')) {
                            return false;
                        }
                    }
                }
            }
        return true;
    }
}




    //TODO Check if Ship is hit, Check if able to place ship on given coordinates
