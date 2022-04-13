package de.swm;

public class User {

    private int id;
    private int quantityShips = 7;
    Board ownBoard;
    Board enemyBoard;
    Ship[] ships;


    public User(int id, int quantityShips, Ship[] ships) {
        this.id = id;
        this.quantityShips = quantityShips;
        this.ships = ships;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityShips() {
        return quantityShips;
    }

    public void setQuantityShips(int quantityShips) {
        this.quantityShips = quantityShips;
    }

    public Board getOwnBoard() {
        return ownBoard;
    }

    public void setOwnBoard(Board ownBoard) {
        this.ownBoard = ownBoard;
    }

    public Board getEnemyBoard() {
        return enemyBoard;
    }

    public void setEnemyBoard(Board enemyBoard) {
        this.enemyBoard = enemyBoard;
    }
}
