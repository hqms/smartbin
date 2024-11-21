package com.hqm.smartbin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

    @GetMapping(value = "/apis")
    public String index(){
        return "apis";
    }
}
