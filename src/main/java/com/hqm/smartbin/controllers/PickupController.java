package com.hqm.smartbin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PickupController {

    @GetMapping(value = "pickup")
    public String index(){

        return "pickup";
    }
}
