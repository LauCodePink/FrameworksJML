package com.rollerspeed.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class Indexcontroll {

  @RequestMapping("/home")
    public String index() {
        return "home/index";
    }

    @RequestMapping("/servicios")
    public String servicios() {
        return "home/servicios";
    }
    @RequestMapping("/eventos")
    public String eventos() {
        return "home/eventos";
    }
}
