package com.hqm.smartbin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/bin")
public class BinController {

    @GetMapping(value = "")
    public String index(){

        return "bin";
    }

    @GetMapping(value = "/new")
    public String baru(){
        return "bin-new" ;
    }
}
