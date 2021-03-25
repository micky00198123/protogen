package com.qklt.protogen.utils;

public class DataSet {

    public static void main(String[] args) {
        String s = "B00000000,\n" +
                "  B00000000,\n" +
                "  B00000000,\n" +
                "  B00000000,\n" +
                "  B00000000,\n" +
                "  B00000000,\n" +
                "  B00000000,\n" +
                "  B00000000";
        // 正对 RM4-1
        System.out.println(Util.pacData(s));

        // 正对 LM4-1
        System.out.println(Util.pacDataN90(s));

        // 正对 LN1 LE1-2
        System.out.println(Util.pacData90(s));

        // 正对 RN1 RE1-2
        System.out.println(Util.pacData180(s));



    }


}
