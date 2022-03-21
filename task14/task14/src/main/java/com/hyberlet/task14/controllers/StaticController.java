package com.hyberlet.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String startPage() {
        return "home.html";
    }
}
