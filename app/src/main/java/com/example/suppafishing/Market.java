package com.example.suppafishing;

import androidx.annotation.NonNull;

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

    public Market(int net, int rod, int box, int guppy, int shrimp,
                  int trout, int lobster, int time){
        this.net = net;
        this.rod = rod;
        this.box = box;
        this.guppy = guppy;
        this.shrimp = shrimp;
        this.trout = trout;
        this.lobster = lobster;
        this.time = time;
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

    public void setGuppy(int guppy) {
        this.guppy = guppy;
    }

    public void setTrout(int trout) {
        this.trout = trout;
    }

    public void setLobster(int lobster) {
        this.lobster = lobster;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @NonNull
    @Override
    public String toString() {
        String info = "Guppy Price: " + getGuppy() + "\n" +
                "Shrimp Price: " + getShrimp() + "\n" +
                "Trout Price: " + getTrout() + "\n" +
                "Lobster Price: " + getLobster() + "\n" +
                "Net Price: " + getNet() + "\n" +
                "Rod Price: " + getRod() + "\n" +
                "Box Trap Price: " + getBox() + "\n" +
                "Time in Day Remaining: " + getTime() + "\n";
        return info;
    }
}
