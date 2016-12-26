package com.alexrazor.testapk;

public class Owner {

    private String name;
    private int carNumber;

    public Owner(String name, int carNumber) {
        this.name = name;
        this.carNumber = carNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "NAME: "+this.name+" NUMBER:"+this.carNumber;
    }
}
