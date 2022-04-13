package de.swm;

import java.util.Scanner;
import java.util.SortedMap;

public class Spiel {

    private Ship[] shipsP1;
    private Ship[] shipsP2;
    private int move = 0;
    User player1;
    User player2;


    public void initiliazeGame() {
        Ship battleShipP1 = new Battleship(1, 5, 'S');
        Ship cruiserP1 = new Cruiser(2, 4, 'K');
        Ship destroyerP1 = new Destroyer(3, 3, 'Z');
        Ship uboatP1 = new Uboat(1, 2,'U');
        Ship battleShipP2 = new Battleship(1, 5, 'S');
        Ship cruiserP2 = new Cruiser(2, 4,'K');
        Ship destroyerP2 = new Destroyer(3, 3, 'Z');
        Ship uboatP2 = new Uboat(1, 2, 'U');
        shipsP1 = new Ship[]{battleShipP1, cruiserP1, destroyerP1, uboatP1};
        shipsP2 = new Ship[]{battleShipP2, cruiserP2, destroyerP2, uboatP2};
        player1 = new User(1, 7, shipsP1);
        player2 = new User(2, 7, shipsP2);
        player1.ownBoard = new Board(new char[10][10]);
        player2.ownBoard = new Board(new char[10][10]);
        player1.enemyBoard = new Board(new char[10][10]);
        player2.enemyBoard = new Board(new char[10][10]);
    }

    public void runGame() {
        player1.getOwnBoard().initialize();
        System.out.println();
        player2.getOwnBoard().initialize();
        while (player1.getQuantityShips() != 0 && player2.getQuantityShips() != 0) {
            shipSelection();
            shipShoot();
        }
    }

    private void shipSelection() {
        Scanner scanner = new Scanner(System.in);
        while (move < 14) {
            if (move % 2 == 0) {
                System.out.println("Spieler 1 ist an der Reihe \nBitte geben Sie an welches Schiff Sie platzieren möchten\n" +
                        "1.Schlachtschiff (Anzahl: " + shipsP1[0].getQuantity() + ") | " +
                        "2.Kreuzer (Anzahl: " + shipsP1[1].getQuantity() + ") | " +
                        "3.Destroyers (Anzahl: " + shipsP1[2].getQuantity() + ") | " +
                        "4. U-Boot (Anzahl: " + shipsP1[3].getQuantity() + ")");
                int selection = scanner.nextInt();
                if(shipsP1[selection-1].getQuantity() > 0) {
                    System.out.println("1.Vertikal, 2.Horizontal");
                    int positioning = scanner.nextInt();
                    if (positioning == 1) {
                        player1.ownBoard.showBoard();
                        System.out.println("Bitte geben Sie zunächst die X-Koordinate ein");
                        int orientation = scanner.nextInt() - 1;
                        System.out.println("Start des Schiffs Y-Koordinate:");
                        int CoordinatesStart = scanner.nextInt() - 1;
                        System.out.println("Ende des Schiffs Y-Koordinate:");
                        int CoordinatesEnd = scanner.nextInt() - 1;
                        if (placeShip(shipsP1[selection - 1], positioning, player1.getId(), CoordinatesStart, orientation, CoordinatesEnd)) {
                            player1.ownBoard.showBoard();
                            int currentShips = player1.getQuantityShips();
                            player1.setQuantityShips(--currentShips);
                            move++;
                        }
                    } else if (positioning == 2) {
                        player1.ownBoard.showBoard();
                        System.out.println("Bitte geben Sie zunächst die Y-Koordinate ein");
                        int orientation = scanner.nextInt() - 1;
                        System.out.println("Start des Schiffs X-Koordinate:");
                        int CoordinatesStart = scanner.nextInt() - 1;
                        System.out.println("Ende des Schiffs X-Koordinate:");
                        int CoordinatesEnd = scanner.nextInt() - 1;
                        if (placeShip(shipsP1[selection - 1], positioning, player1.getId(), CoordinatesStart, orientation, CoordinatesEnd)) {
                            player1.ownBoard.showBoard();
                            int currentShips = player1.getQuantityShips();
                            player1.setQuantityShips(--currentShips);
                            move++;
                        }
                    }
                } else {
                    System.out.println("Keine Schiffe mehr diesen Typs verfügbar");
                }
            } else {
                System.out.println("Spieler 2 ist an der Reihe \nBitte geben Sie an welches Schiff Sie platzieren möchten\n" +
                        "1.Schlachtschiff (Anzahl: " + shipsP2[0].getQuantity() + ") | " +
                        "2.Kreuzer (Anzahl: " + shipsP2[1].getQuantity() + ") | " +
                        "3.Destroyers (Anzahl: " + shipsP2[2].getQuantity() + ") | " +
                        "4. U-Boot (Anzahl: " + shipsP2[3].getQuantity() + ")");
                int selection = scanner.nextInt();
                if(shipsP2[selection-1].getQuantity() > 0) {
                    System.out.println("1.Vertikal, 2.Horizontal");
                    int positioning = scanner.nextInt();
                    if (positioning == 1) {
                        player2.ownBoard.showBoard();
                        System.out.println("Bitte geben Sie zunächst die X-Koordinate ein");
                        int orientation = scanner.nextInt() - 1;
                        System.out.println("Start des Schiffs Y-Koordinate:");
                        int CoordinatesStart = scanner.nextInt() - 1;
                        System.out.println("Ende des Schiffs Y-Koordinate:");
                        int CoordinatesEnd = scanner.nextInt() - 1;
                        if (placeShip(shipsP2[selection - 1], positioning, player2.getId(), CoordinatesStart, orientation, CoordinatesEnd)) {
                            player2.ownBoard.showBoard();
                            move++;
                        }
                    } else if (positioning == 2) {
                        player2.ownBoard.showBoard();
                        System.out.println("Bitte geben Sie zunächst die Y-Koordinate ein");
                        int orientation = scanner.nextInt() - 1;
                        System.out.println("Start des Schiffs X-Koordinate:");
                        int CoordinatesStart = scanner.nextInt() - 1;
                        System.out.println("Ende des Schiffs X-Koordinate:");
                        int CoordinatesEnd = scanner.nextInt() - 1;
                        if (placeShip(shipsP2[selection - 1], positioning, player2.getId(), CoordinatesStart, orientation, CoordinatesEnd)) {
                            player2.ownBoard.showBoard();
                            move++;
                        }
                    }
                } else {
                    System.out.println("Keine Schiffe mehr diesen Typs verfügbar");
                }
            }
        }
    }

    private boolean placeShip(Ship ship, int positioning, int id, int CoordinatesStart, int orientation, int CoordinatesEnd) {
        if (id == 1) {
                if (player1.ownBoard.setShips(ship.getLength(), positioning, CoordinatesStart, orientation, CoordinatesEnd, ship.getSign())) {
                    ship.setQuantity(ship.getQuantity() - 1);
                    return true;
                } else {
                    System.out.println("Konnte nicht gesetzt werden");
                    return false;
                }
            } else {
                if (player2.ownBoard.setShips(ship.getLength(), positioning, CoordinatesStart, orientation, CoordinatesEnd, ship.getSign())) {
                    ship.setQuantity(ship.getQuantity() - 1);
                    return true;
                } else {
                    System.out.println("Konnte nicht gesetzt werden");
                    return false;
                }
        }
    }
    private void shipShoot() {
        System.out.println("Spieler 1 ist nun dran");
        Scanner scanner = new Scanner(System.in);
        while(player1.getQuantityShips() != 0 || player2.getQuantityShips() != 0) {
            if (move % 2 == 0) {
                System.out.println("Bitte geben Sie zunächst die X-Koordinate ein");
                int xShoot = scanner.nextInt() - 1;
                System.out.println("Bitte geben Sie die Y-Koordinate ein");
                int yShoot = scanner.nextInt() - 1;

                if(player2.getOwnBoard().checkCoordinates(xShoot,yShoot,player1.getEnemyBoard(), player2.ships,player2)) {
                    player1.enemyBoard.showBoard();
                    System.out.println("Sie dürfen nochmal");
                }else {
                    player1.enemyBoard.showBoard();
                    move++;
                    System.out.println("Spieler 2 ist nun dran");
                }
            } else {
                System.out.println("Bitte geben Sie zunächst die X-Koordinate ein");
                int xShoot = scanner.nextInt() - 1;
                System.out.println("Bitte geben Sie die Y-Koordinate ein");
                int yShoot = scanner.nextInt() - 1;
                if(player1.getOwnBoard().checkCoordinates(xShoot,yShoot,player2.getEnemyBoard(), player1.ships, player1)) {
                    player2.enemyBoard.showBoard();
                    System.out.println("Sie dürfen nochmal");
                }else {
                    player2.enemyBoard.showBoard();
                    move++;
                    System.out.println("Spieler 1 ist nun dran");
                }
            }
        }
        if(player1.getQuantityShips() == 0) {
            System.out.println("Spieler 1 hat gewonnen");
        } else {
            System.out.println("Spieler 2 hat gewonnen");
        }
    }
}

