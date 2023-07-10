package kr.gamso.controller;

import kr.gamso.service.UsersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/users")
public class UsersController {
    UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Boolean> duplicateCheckId(@PathVariable String id){
        boolean userIdCheck = usersService.selectUserId(id);

        return  ResponseEntity.ok(userIdCheck);
    }
}
