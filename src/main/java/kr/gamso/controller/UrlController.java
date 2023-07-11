package kr.gamso.controller;

import kr.gamso.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {

    UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @RequestMapping("/main")
    public String urlMain(){
        return "/urlMain";
    }
}
