package com.example.suppafishing.util;

import androidx.databinding.InverseMethod;

public class StringUtil {

    public static String nameString(String name){
        return name + "'s Information";
    }

    public static String moneyString(int value){
        return "Money: $" + value;
    }

    public static String daysString(int value){
        return "Days Left: " + value;
    }

    public static String guppyString(int value){
        return "Guppies: " + value;
    }

    public static String shrimpString(int value){
        return "Shrimp: " + value;
    }

    public static String troutString(int value){
        return "Trout: " + value;
    }

    public static String lobsterString(int value){
        return "Lobster: " + value;
    }

    public static String netString(int value){
        if(value == 1){
            return "Have a Net";
        }
        else{
            return "No Net Available";
        }
    }

    public static String rodString(int value){
        if(value == 1){
            return "Have a Rod";
        }
        else{
            return "No Rod Available";
        }
    }

    public static String boxString(int value){
        if(value == 1){
            return "Have a Box Trap";
        }
        else{
            return "No Box Trap Available";
        }
    }

    public static String marketMoneyString(int value){
        return "$" + value;
    }
}
