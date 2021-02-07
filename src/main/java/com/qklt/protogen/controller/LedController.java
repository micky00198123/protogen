package com.qklt.protogen.controller;

import com.qklt.protogen.service.main.MaxLedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("")
public class LedController {

    private Map<String, String> currLed, prevLed, nextLed;
    private Integer faceNum=1, currNum, prevNum, nextNum;

    private MaxLedService maxLedService;

    @Autowired
    public LedController(MaxLedService maxLedService) {
        this.maxLedService = maxLedService;
    }

    private void setData(Integer num){
        if(currNum==null || prevNum==null || nextNum==null){
            faceNum = maxLedService.countFaceNum();
            currNum = num;
            prevNum = prevNum(currNum);
            nextNum = nextNum(currNum);
            currLed = maxLedService.getAllDataById(currNum);
            prevLed = maxLedService.getAllDataById(prevNum);
            nextLed = maxLedService.getAllDataById(nextNum);
        } else if(prevNum.equals(num)){
            currNum = num;
            prevNum = prevNum(currNum);
            nextNum = nextNum(currNum);
            nextLed = currLed;
            currLed = prevLed;
            prevLed = maxLedService.getAllDataById(prevNum);
        } else if(nextNum.equals(num)){
            currNum = num;
            prevNum = prevNum(currNum);
            nextNum = nextNum(currNum);
            prevLed = currLed;
            currLed = nextLed;
            nextLed = maxLedService.getAllDataById(nextNum);
        } else if(!currNum.equals(num)){
            currNum = num;
            prevNum = prevNum(currNum);
            nextNum = nextNum(currNum);
            currLed = maxLedService.getAllDataById(currNum);
            prevLed = maxLedService.getAllDataById(prevNum);
            nextLed = maxLedService.getAllDataById(nextNum);
        }
    }

    private Integer nextNum(Integer num){
        num ++;
        if(num > faceNum){
            num = 1;
        }
        return num;
    }

    private Integer prevNum(Integer num){
        num --;
        if(num < 1){
            num = faceNum;
        }
        return num;
    }


    @GetMapping("/led/{id}/{module1}@{module2}@{module3}@{module4}")
    @ResponseBody
    public String transportLedData(@PathVariable Integer id,
                                    @PathVariable String module1, @PathVariable String module2,
                                    @PathVariable String module3, @PathVariable String module4){
        if(null==id || 0>=id){
            return "";
        }

        String data;

        if(id.equals(currNum)){
            data = currLed.get(module1) + currLed.get(module2) +
                    currLed.get(module3) + currLed.get(module4);
        } else if(id.equals(prevNum)){
            data = prevLed.get(module1) + prevLed.get(module2) +
                    prevLed.get(module3) + prevLed.get(module4);
        } else if(id.equals(nextNum)){
            data = nextLed.get(module1) + nextLed.get(module2) +
                    nextLed.get(module3) + nextLed.get(module4);
        } else {
            data = maxLedService.getPacLedData(id, module1) +
                    maxLedService.getPacLedData(id, module2) +
                    maxLedService.getPacLedData(id, module3) +
                    maxLedService.getPacLedData(id, module4);
        }

        return data;
    }

    @GetMapping("/led/{id}")
    @ResponseBody
    public void okAnswer(@PathVariable Integer id){
        setData(id);
    }

    @GetMapping("/f_num")
    @ResponseBody
    public Integer transportFaceNum(){
        return maxLedService.countFaceNum();
    }



}
