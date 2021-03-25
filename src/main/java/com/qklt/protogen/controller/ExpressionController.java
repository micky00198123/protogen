package com.qklt.protogen.controller;


import com.qklt.protogen.entity.Expression;
import com.qklt.protogen.service.main.ExpLedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author qklt
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/exp")
public class ExpressionController {

    private Expression currExp, prevExp, nextExp;
    private Integer faceNum=1;

    @Autowired
    private ExpLedService expLedService;

    @GetMapping("/led/{id}")
    @ResponseBody
    public String getExpData(@PathVariable Integer id){
        if(currExp==null || prevExp==null || nextExp==null){
            faceNum = expLedService.countExpNum();
            init(id);
        }
        if(currExp.getExpressionId().equals(id)){
            return currExp.getData();
        }
        if(prevExp.getExpressionId().equals(id)){
            return prevExp.getData();
        }
        if(nextExp.getExpressionId().equals(id)){
            return nextExp.getData();
        }
        return expLedService.getExp(id).getData();
    }

    @GetMapping("/ledr/{id}")
    @ResponseBody
    public String getExpRightData(@PathVariable Integer id){
        if(currExp==null || prevExp==null || nextExp==null){
            faceNum = expLedService.countExpNum();
            init(id);
        }
        if(currExp.getExpressionId().equals(id)){
            return currExp.getRData();
        }
        if(prevExp.getExpressionId().equals(id)){
            return prevExp.getRData();
        }
        if(nextExp.getExpressionId().equals(id)){
            return nextExp.getRData();
        }
        return expLedService.getExp(id).getRData();
    }

    @GetMapping("/ledl/{id}")
    @ResponseBody
    public String getExpLeftData(@PathVariable Integer id){
        if(currExp==null || prevExp==null || nextExp==null){
            faceNum = expLedService.countExpNum();
            init(id);
        }
        if(currExp.getExpressionId().equals(id)){
            return currExp.getLData();
        }
        if(prevExp.getExpressionId().equals(id)){
            return prevExp.getLData();
        }
        if(nextExp.getExpressionId().equals(id)){
            return nextExp.getLData();
        }
        return expLedService.getExp(id).getLData();
    }

    @GetMapping("/f_num")
    @ResponseBody
    public Integer getExpNum(){
        return expLedService.countExpNum();
    }

    @GetMapping("/ok/{id}")
    @ResponseBody
    public void updateExp(@PathVariable Integer id){
        if(currExp==null || prevExp==null || nextExp==null){
            faceNum = expLedService.countExpNum();
            init(id);
        }
        if(id==null || currExp.getExpressionId().equals(id)){
            return;
        }
        if(prevExp.getExpressionId().equals(id)){
            nextExp = currExp;
            currExp = prevExp;
            prevExp = expLedService.getExp(prevNum(id));
            return;
        }
        if(nextExp.getExpressionId().equals(id)){
            prevExp = currExp;
            currExp = nextExp;
            nextExp = expLedService.getExp(nextNum(id));
            return;
        }
        init(id);

    }

    private void init(Integer id){
        currExp = new Expression().selectById(id);
        prevExp = new Expression().selectById(prevNum(id));
        nextExp = new Expression().selectById(nextNum(id));
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


}

