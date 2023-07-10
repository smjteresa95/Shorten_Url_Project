package kr.gamso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @RequestMapping(value = {"", "/index"})
    public String goToIndex(){
        return "/index";
    }
}
