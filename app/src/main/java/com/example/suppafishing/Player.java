package com.example.suppafishing;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import java.io.Serializable;

//Implements Serializable for passing between activities
public class Player extends BaseObservable implements Serializable {
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
    private Market market;

    public Player(int id, String name, int money, int days, int guppy, int shrimp,
                  int trout, int lobster, int net, int rod, int box, Market market){
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
        this.market = market;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public int getMoney() {
        return money;
    }

    @Bindable
    public int getDays() {
        return days;
    }


    @Bindable
    public int getGuppy() {
        return guppy;
    }

    @Bindable
    public int getShrimp() {
        return shrimp;
    }

    @Bindable
    public int getTrout() {
        return trout;
    }

    @Bindable
    public int getLobster() {
        return lobster;
    }

    @Bindable
    public int getBox() {
        return box;
    }

    @Bindable
    public int getNet() {
        return net;
    }

    @Bindable
    public int getRod() {
        return rod;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.player);
    }

    public void setMoney(int money) {
        this.money = money;
        notifyPropertyChanged(BR.player);
    }

    public void setDays(int days) {
        this.days = days;
        notifyPropertyChanged(BR.player);
    }

    public void setGuppy(int guppy) {
        this.guppy = guppy;
        notifyPropertyChanged(BR.player);
    }

    public void setShrimp(int shrimp) {
        this.shrimp = shrimp;
        notifyPropertyChanged(BR.player);
    }

    public void setTrout(int trout) {
        this.trout = trout;
        notifyPropertyChanged(BR.player);
    }

    public void setLobster(int lobster) {
        this.lobster = lobster;
        notifyPropertyChanged(BR.player);
    }

    public void setRod(int rod) {
        this.rod = rod;
        notifyPropertyChanged(BR.player);
    }

    public void setNet(int net) {
        this.net = net;
        notifyPropertyChanged(BR.player);
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
