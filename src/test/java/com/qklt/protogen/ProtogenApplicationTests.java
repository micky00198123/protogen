package com.qklt.protogen;

import com.qklt.protogen.entity.FaceMapping;
import com.qklt.protogen.utils.Util;
import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProtogenApplicationTests {

    String noseR = "B00000000, B00000000, B00000001, B00000011, B00000011, B00111111, B01111110, B00000000";


    @Test
    void contextLoads() {
        String mm = "170,85,170,85,170,85,170,85";
        System.out.println(mm.substring(0,3));
    }

    @Test
    void contextLoads2() {

        FaceMapping fm = new FaceMapping().selectById(4);
        System.out.println(fm);

    }

}
