package com.qklt.protogen;

import com.qklt.protogen.entity.Expression;
import com.qklt.protogen.utils.Util;
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
    void nose() {
        Integer id = 0;
        String s = "";

        String[] list = Util.unPac(s);
        Expression exp = new Expression().selectById(id);
        exp.setRn1(Util.pacData180(list[0]));
        exp.setLn1(Util.pacData90(list[0]));
        exp.updateById();

    }

    @Test
    void eye() {
        Integer id = 0;
        String s = "";

        String[] list = Util.unPac(s);
        Expression exp = new Expression().selectById(id);
        exp.setRe1(Util.pacData180(list[0]));
        exp.setRe2(Util.pacData180(list[1]));
        exp.setLe1(Util.pacData90(list[0]));
        exp.setLe2(Util.pacData90(list[0]));
        exp.updateById();

    }

    @Test
    void mouth() {
        Integer id = 0;
        String s = "";

        String[] list = Util.unPac(s);
        Expression exp = new Expression().selectById(id);
        exp.setRm4(Util.pacData(list[0]));
        exp.setRm3(Util.pacData(list[1]));
        exp.setRm2(Util.pacData(list[2]));
        exp.setRm1(Util.pacData(list[3]));
        exp.setLm4(Util.pacDataN90(list[0]));
        exp.setLm3(Util.pacDataN90(list[1]));
        exp.setLm2(Util.pacDataN90(list[2]));
        exp.setLm1(Util.pacDataN90(list[3]));
        exp.updateById();

    }




}
