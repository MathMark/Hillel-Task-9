package com.hillel.mvc.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String getView() {
        return "index";
    }
}
