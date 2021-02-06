package com.qklt.protogen.controller;

import com.qklt.protogen.service.main.MaxLedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("")
public class LedController {

    @Autowired
    private MaxLedService maxLedService;



    @GetMapping("/led/{id}/{module1}@{module2}@{module3}@{module4}")
    @ResponseBody
    public String transportLedData2(@PathVariable Integer id,
                                    @PathVariable String module1, @PathVariable String module2,
                                    @PathVariable String module3, @PathVariable String module4){
        if(null==id || 0>=id){
            return "";
        }

        String data = maxLedService.getPacLedData(id, module1) +
                maxLedService.getPacLedData(id, module2) +
                maxLedService.getPacLedData(id, module3) +
                maxLedService.getPacLedData(id, module4);
        return data;
    }

    @GetMapping("/f_num")
    @ResponseBody
    public Integer transportFaceNum(){
        return maxLedService.countFaceNum();
    }


}
