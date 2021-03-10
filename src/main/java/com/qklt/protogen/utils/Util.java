package com.qklt.protogen.utils;

import java.util.Arrays;

public class Util {

    public static String pacData(String s){
        String[] subStr = new String[8];
        int[] data = new int[8];
        StringBuilder pac = new StringBuilder();
        for(int i = 0; i < 7; i++){
            subStr[i] = s.substring(s.indexOf("B")+1, s.indexOf(","));
            data[i] = Integer.parseInt(subStr[i], 2);
            pac.append(String.format("%03d", data[i]));
            s = s.substring(s.indexOf(",")+1);
        }
        subStr[7] = s.substring(s.indexOf("B")+1);
        data[7] = Integer.parseInt(subStr[7], 2);
        pac.append(String.format("%03d", data[7]));
        return pac.toString();
    }

    public static String pacDataN90(String s){
        StringBuilder pac = new StringBuilder();
        String[] list = flipListN90(getList(s));
        for(int i = 0; i < 8; i++){
            pac.append(String.format("%03d", Integer.parseInt(list[i], 2)));
        }
        return pac.toString();
    }

    public static String pacData90(String s){
        StringBuilder pac = new StringBuilder();
        String[] list = flipList90(getList(s));
        for(int i = 0; i < 8; i++){
            pac.append(String.format("%03d", Integer.parseInt(list[i], 2)));
        }
        return pac.toString();
    }

    public static String pacData180(String s){
        StringBuilder pac = new StringBuilder();
        String[] list = flipList(getList(s));
        for(int i = 0; i < 8; i++){
            pac.append(String.format("%03d", Integer.parseInt(list[i], 2)));
        }
        return pac.toString();
    }

    private static String[] getList(String s){
        String[] list = new String[8];
        for(int i = 0; i < 7; i++){
            list[i] = s.substring(s.indexOf("B")+1, s.indexOf(","));
            s = s.substring(s.indexOf(",")+1);
        }
        list[7] = s.substring(s.indexOf("B")+1);
        return list;
    }

    private static String[] flipList90(String[] list){
        for(int i = 0; i < 4; i++){
            list[i] = new StringBuilder(list[i]).reverse().toString();
            list[7-i] = new StringBuilder(list[7-i]).reverse().toString();
        }
        return list;
    }

    private static String[] flipListN90(String[] list){
        String temp;
        for(int i = 0; i < 4; i++){
            temp = list[i];
            list[i] = list[7-i];
            list[7-i] = temp;
        }
        return list;
    }

    private static String[] flipList(String[] list){
        String temp;
        for(int i = 0; i < 4; i++){
            temp = list[i];
            list[i] = list[7-i];
            list[7-i] = temp;
            list[i] = new StringBuilder(list[i]).reverse().toString();
            list[7-i] = new StringBuilder(list[7-i]).reverse().toString();
        }
        return list;
    }

    public static String doubleData(String s, int times){
        StringBuilder douData = new StringBuilder();
        for(int i = 0; i < times; i++){
            douData.append(s);
        }
        return douData.toString();
    }


}
