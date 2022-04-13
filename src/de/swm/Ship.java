package de.swm;


public class Ship {

    private String type;
    private int xCoordinate;
    private int yCoordinate;
    private int quantity;
    private int length;

    private char sign;


    public Ship (int quantity, int length, String type, char sign) {
        this.quantity = quantity;
        this.length = length;
        this.type = type;
        this.sign = sign;
    }


    public char getSign() {
        return sign;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

