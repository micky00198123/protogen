package com.qklt.protogen.controller;

import com.qklt.protogen.service.main.MaxLedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/led")
public class LedController {

    @Autowired
    private MaxLedService maxLedService;

    @GetMapping("/{id}/{module}")
    @ResponseBody
    public String transportLedData(@PathVariable Integer id, @PathVariable String module){
        if(null==id || 0>=id || null==module || "".equals(module)){
            return "";
        }
        else{
            return maxLedService.getPacLedData(id, module);
        }
    }


}
