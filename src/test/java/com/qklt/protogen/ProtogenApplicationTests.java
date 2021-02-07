package com.qklt.protogen;

import com.qklt.protogen.entity.Expression;
import com.qklt.protogen.entity.FaceMapping;
import com.qklt.protogen.service.main.MaxLedService;
import com.qklt.protogen.utils.Util;
import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ProtogenApplicationTests {

    String noseR = "B00000000, B00000000, B00000001, B00000011, B00000011, B00111111, B01111110, B00000000";

    @Autowired
    private MaxLedService maxLedService;

    @Test
    void contextLoads() {
        String mm = "170,85,170,85,170,85,170,85";
        System.out.println(mm.substring(0,3));
    }

    @Test
    void contextLoads2() {

        Map<String, String> map = maxLedService.getAllDataById(5);
        Expression e = new Expression();
        e.setExpressionName("502");
        e.setRn1(map.get("RN1"));
        e.setRe1(map.get("RE1"));
        e.setRe2(map.get("RE2"));
        e.setRm1(map.get("RM1"));
        e.setRm2(map.get("RM2"));
        e.setRm3(map.get("RM3"));
        e.setRm4(map.get("RM4"));
        e.setLn1(map.get("LN1"));
        e.setLe1(map.get("LE1"));
        e.setLe2(map.get("LE2"));
        e.setLm1(map.get("LM1"));
        e.setLm2(map.get("LM2"));
        e.setLm3(map.get("LM3"));
        e.setLm4(map.get("LM4"));
//        e.insert();


    }

}
