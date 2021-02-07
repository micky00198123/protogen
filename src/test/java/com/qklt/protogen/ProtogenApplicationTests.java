package com.qklt.protogen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProtogenApplicationTests {


    @Autowired

    @Test
    void contextLoads() {
        String mm = "170,85,170,85,170,85,170,85";
        System.out.println(mm.substring(0,3));
    }

    @Test
    void contextLoads2() {



    }

}
