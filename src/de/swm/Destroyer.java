package de.swm;

public class Destroyer extends Ship {

    private int length;
    private int quantity;
    private char sign;
    private boolean isSunk;

    public Destroyer(int quantity, int length, char sign){
        this.length = length;
        this.quantity = quantity;
        this.sign = sign;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public char getSign() {
        return sign;
    }

    @Override
    public boolean isSunk() {
        isSunk = length == 0;
        return isSunk;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void setLengthToDefault() {
        length = 3;
    }
}
