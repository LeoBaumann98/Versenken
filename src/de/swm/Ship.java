package de.swm;


public abstract class Ship {

    private String type;
    private int xCoordinate;
    private int yCoordinate;
    private int length;
    private char sign;
    private int quantity;
    private boolean isSunk;

    public abstract int getQuantity();

    public abstract void setQuantity(int quantity);

    public abstract int getLength();

    public abstract char getSign();

    public abstract boolean isSunk();

    public abstract void setLength(int length);

    public abstract void setLengthToDefault();
}

