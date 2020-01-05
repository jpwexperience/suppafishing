package com.example.suppafishing.util;

import androidx.databinding.InverseMethod;

public class StringUtil {

    public static String nameString(String name){
        return name + " Information";
    }

    public static String moneyString(int value){
        return "Money: $" + String.valueOf(value);
    }

    public static String daysString(int value){
        return "Days Left: " + String.valueOf(value);
    }

    public static String guppyString(int value){
        return "Guppies: " + String.valueOf(value);
    }

    public static String shrimpString(int value){
        return "Shrimp: " + String.valueOf(value);
    }

    public static String troutString(int value){
        return "Trout: " + String.valueOf(value);
    }

    public static String lobsterString(int value){
        return "Lobster: " + String.valueOf(value);
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
}
