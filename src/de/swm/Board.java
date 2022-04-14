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

    public void showBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Platziert Schiffe nach Koordinaten(End und Startpunkt und einem festen X-Achsen oder Y-Achsen Punkt) und platziert an die Stelle einen Buchstaben

    public boolean setShips(int length, int positioning, int coordinatesStart, int orientation, int coordinatesEnd, char shipType) {
        if (checkValidPlacement(length, coordinatesStart, coordinatesEnd, orientation, positioning))
            if (positioning == 1) {
                for (int i = coordinatesStart; i <= coordinatesEnd; i++) {
                    board[i][orientation] = shipType;
                }
                return true;
            } else {
                for (int i = coordinatesStart; i <= coordinatesEnd; i++) {
                    board[orientation][i] = shipType;
                }
                return true;
            }
        return false;
    }

    //checkt alle Fälle ob ein anderes Schiff angrenzt

    public boolean checkValidPlacement(int length, int coordinatesStart, int coordinatesEnd, int orientation, int positioning) {
        if (coordinatesEnd - coordinatesStart != length - 1) {
            return false;
        }
        if (coordinatesStart == 10 || coordinatesEnd < coordinatesStart) {
            return false;
        }
        if (positioning == 1) {
            for (int i = coordinatesStart; i <= (coordinatesStart + length) - 1; i++) {
                if (i == 0 && orientation == 0) {
                    if (board[i + 1][orientation] != '~' || board[i][orientation + 1] != '~') {
                        return false;
                    }
                } else if (i == 0 && orientation == 9) {
                    if (board[i + 1][orientation] != '~' || board[i][orientation - 1] != '~') {
                        return false;
                    }
                }else if (i == 9 && orientation == 0){
                    if (board[i-1][orientation] != '~' || board[i][orientation+1] != '~') {
                        return false;
                    }
                }else if(i == 9 && orientation == 9) {
                    if(board[i-1][orientation] != '~' || board[i][orientation-1] != '~'){
                        return false;
                    }
                }else if (i == 0) {
                    if (board[i + 1][orientation] != '~' || board[i][orientation + 1] != '~' || board[i][orientation - 1] != '~') {
                        return false;
                    }
                } else if (orientation == 0) {
                    if (board[i][orientation + 1] != '~' || board[i + 1][orientation] != '~' || board[i - 1][orientation] != '~') {
                        return false;
                    }
                } else if (orientation == 9) {
                    if (board[i + 1][orientation] != '~' || board[i - 1][orientation] != '~' || board[i][orientation - 1] != '~') {
                        return false;
                    }
                } else if(i == 9) {
                    if (board[i - 1][orientation] != '~' || board[i][orientation + 1] != '~' || board[i][orientation - 1] != '~') {
                        return false;
                    }
                }else {
                    if (board[i + 1][orientation] != '~' || board[i - 1][orientation] != '~' || board[i][orientation + 1] != '~' || board[i][orientation - 1] != '~') {
                        return false;
                    }
                }
            }
        } else if (positioning == 2) {
            for (int i = coordinatesStart; i <= (coordinatesStart + length) - 1 ; i++) {
                if (i == 0 && orientation == 0) {
                    if (board[orientation][i + 1] != '~' || board[orientation + 1][i] != '~') {
                        return false;
                    }
                } else if (i == 0 && orientation == 9) {
                    if (board[orientation][i + 1] != '~' || board[orientation - 1][i] != '~') {
                        return false;
                    }
                }else if (i == 9 && orientation == 9){
                    if(board[orientation-1][i] != '~' || board[orientation][i-1] != '~'){
                        return false;
                    }
                }else if(i == 9 && orientation == 0) {
                    if(board[orientation+1][i] != '~' || board[orientation][i-1] != '~') {
                        return false;
                    }
                }else if (i == 0) {
                    if (board[orientation + 1][i] != '~' || board[orientation - 1][i] != '~' || board[orientation][i + 1] != '~') {
                        return false;
                    }
                } else if (orientation == 0) {
                    if (board[orientation + 1][i] != '~' || board[orientation][i + 1] != '~' || board[orientation][i - 1] != '~') {
                        return false;
                    }
                } else if (orientation == 9) {
                    if (board[orientation - 1][i] != '~' || board[orientation][i + 1] != '~' || board[orientation][i - 1] != '~') {
                        return false;
                    }
                } else if(i == 9) {
                    if (board[orientation + 1][i] != '~' || board[orientation - 1][i] != '~' || board[orientation][i - 1] != '~') {
                        return false;
                    }
                }else {
                    if (board[orientation + 1][i] != '~' || board[orientation - 1][i] != '~' || board[orientation][i + 1] != '~' || board[orientation][i - 1] != '~') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // setzt auf das Spielbrett X für getroffen und O für Wasser

    private void setHitMiss(int xCoord, int yCoord, boolean hit) {
        if (hit) {
            board[yCoord][xCoord] = 'X';
        } else {
            board[yCoord][xCoord] = 'O';
        }
    }

    // checkt anhand des übergebenen Schiffs ob dieses gesunken ist

    private boolean checkIfShipIsSunk (Ship ship) {
        return ship.isSunk();
    }

    // holt das Schiff anhand des Buchstabens heraus und übergibt dieses

    private Ship getShipBySign(int xCoord, int yCoord,Ship[] ships) {
        char ship = board[yCoord][xCoord];
        for (Ship value : ships) {
            if (value.getSign() == ship) {
                return value;
            }
        }
        return null;
    }

    // verringert die Länge des Schiffs nach einem Treffer

    private void changeShipsLength(Ship ship) {
        ship.setLength(ship.getLength() - 1);
    }

    // setzt die Länge zurück sodass bei Schiffen welche mehr als einmal vorkommen noch die Möglichkeit besteht diese zu versenken

    private void setShipLengthToDefault(Ship ship) {
        ship.setLengthToDefault();
        ship.setQuantity(ship.getQuantity()-1);
    }

    // checkt ob getroffen wurde oder nicht

    public boolean checkCoordinates(int xshoot, int yshoot, Board enemyboard, Ship[] ships, User player) {
        if (board[yshoot][xshoot] != '~' && enemyboard.board[yshoot][xshoot] != 'O' && enemyboard.board[yshoot][xshoot] != 'X') {
            Ship ship = getShipBySign(xshoot, yshoot, ships);
            changeShipsLength(ship);
            if (checkIfShipIsSunk(ship)) {
                System.out.println("Treffer versenkt");
                enemyboard.setHitMiss(xshoot, yshoot, true);
                player.setQuantityShips(player.getQuantityShips()-1);
                setShipLengthToDefault(ship);
                return true;
            } else {
                System.out.println("Treffer");
                enemyboard.setHitMiss(xshoot, yshoot, true);
                return true;
            }
        } else if(enemyboard.board[yshoot][xshoot] == 'X' || enemyboard.board[yshoot][xshoot] == 'O') {
            System.out.println("Wurde bereits beschossen");
            return true;
        } else{
            System.out.println("Wasser");
            enemyboard.setHitMiss(xshoot, yshoot, false);
            return false;
        }
    }
}

