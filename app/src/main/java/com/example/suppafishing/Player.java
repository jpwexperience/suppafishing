package com.example.suppafishing;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Player extends BaseObservable implements Parcelable {
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

    protected Player(Parcel in) {
        id = in.readInt();
        name = in.readString();
        money = in.readInt();
        days = in.readInt();
        guppy = in.readInt();
        shrimp = in.readInt();
        trout = in.readInt();
        lobster = in.readInt();
        net = in.readInt();
        rod = in.readInt();
        box = in.readInt();
        market = in.readParcelable(Market.class.getClassLoader());
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

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

    public Market getMarket() {
        return market;
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

    public void setBox(int box) {
        this.box = box;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(money);
        dest.writeInt(days);
        dest.writeInt(guppy);
        dest.writeInt(shrimp);
        dest.writeInt(trout);
        dest.writeInt(lobster);
        dest.writeInt(net);
        dest.writeInt(rod);
        dest.writeInt(box);
        dest.writeParcelable(market, flags);
    }
}