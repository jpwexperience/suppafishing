package com.example.suppafishing;

import java.io.Serializable;

public class Market implements Serializable {
    private int net;
    private int rod;
    private int box;
    private int guppy;
    private int shrimp;
    private int trout;
    private int lobster;
    private int time;

    public Market(){
        this.net = 10;
        this.rod = 20;
        this.box = 50;
        this.guppy = 1;
        this.shrimp = 2;
        this.trout = 4;
        this.lobster = 10;
        this.time = 24;
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

    public int getNet() {
        return net;
    }

    public int getRod() {
        return rod;
    }

    public int getBox() {
        return box;
    }

    public int getTime() {
        return time;
    }
}
