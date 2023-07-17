package kr.gamso.controller;

import kr.gamso.dto.userDTO.DuplicateCheckIdDTO;
import kr.gamso.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restUsers")
public class UserRestController {
    UsersService usersService;

    @Autowired
    public UserRestController(UsersService usersService){
        this.usersService = usersService;
    }

//    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
//    public ResponseEntity<DuplicateCheckIdDTO> duplicateCheckId(@PathVariable String id){
//        int checkCnt = usersService.selectUserId(id);
//
//        DuplicateCheckIdDTO duplicateCheckIdDTO = DuplicateCheckIdDTO.builder()
//                .checkCnt(checkCnt)
//                .build();
//
//        return  ResponseEntity.ok(duplicateCheckIdDTO);
//    }
}
