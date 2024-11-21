package com.hqm.smartbin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BinController {

    @GetMapping(value = "/bin")
    public String index(){

        return "bin";
    }
}
