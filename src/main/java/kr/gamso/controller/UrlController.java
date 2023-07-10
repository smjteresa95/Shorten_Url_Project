package kr.gamso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/url")
public class UrlController {

    @RequestMapping("/main")
    public String urlMain(){
        return "/urlMain";
    }
}
