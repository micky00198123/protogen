package com.qklt.protogen.utils;

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

    public static String doubleData(String s, int times){
        StringBuilder douData = new StringBuilder();
        for(int i = 0; i < times; i++){
            douData.append(s);
        }
        return douData.toString();
    }


}
