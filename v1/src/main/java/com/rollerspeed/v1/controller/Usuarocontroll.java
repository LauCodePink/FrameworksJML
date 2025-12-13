 package com.rollerspeed.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class Usuarocontroll {
 
 @RequestMapping("/listadoestudiantes")
    public String  listadoestudiantes (){
        return "home/listadoestudiantes"; 
    }
    @RequestMapping("/listadoinstructores")
    public String  listadoinstrutores (){
        return "home/listadoinstructores"; 
    }

    
    
}