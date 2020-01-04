package com.example.suppafishing;

import androidx.annotation.NonNull;

public class Player {
    private final int id;
    private String name;
    private int money;
    private int days;
    private int guppy;
    private int shrimp;
    private int trout;
    private int lobster;
    private int net;
    private int rod;
    private int box;

    public Player(int id, String name, int money, int days, int guppy, int shrimp,
                  int trout, int lobster, int net, int rod, int box){
        this.id = id;
        this.name = name;
        this.money = money;
        this.days = days;
        this.guppy = guppy;
        this.shrimp = shrimp;
        this.trout = trout;
        this.lobster = lobster;
        this.net = net;
        this.rod = rod;
        this.box = box;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getDays() {
        return days;
    }

    public int getGuppy() {
        return guppy;
    }

    public int getShrimp() {
        return shrimp;
    }

    public int getTrout() {
        return trout;
    }

    public int getLobster() {
        return lobster;
    }

    public int getBox() {
        return box;
    }

    public int getNet() {
        return net;
    }

    public int getRod() {
        return rod;
    }

    public int getId() {
        return id;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setGuppy(int guppy) {
        this.guppy = guppy;
    }

    public void setShrimp(int shrimp) {
        this.shrimp = shrimp;
    }

    public void setTrout(int trout) {
        this.trout = trout;
    }

    public void setLobster(int lobster) {
        this.lobster = lobster;
    }

    public void setRod(int rod) {
        this.rod = rod;
    }

    public void setNet(int net) {
        this.net = net;
    }

    @NonNull
    @Override
    public String toString() {
        String info = "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Money: " + getMoney() + "\n" +
                "Days: " + getDays() + "\n" +
                "Guppy: " + getGuppy() + "\n" +
                "Shrimp: " + getShrimp() + "\n" +
                "Trout: " + getTrout() + "\n" +
                "Lobster: " + getLobster() + "\n" +
                "Net: " + getNet() + "\n" +
                "Rod: " + getRod() + "\n" +
                "Box: " + getBox();
        return info;
    }
}
