package com.base.warecenter.controller.forpublic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WareController {
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(){
        return "get something";
    }
}
