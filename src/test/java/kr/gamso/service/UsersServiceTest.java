package kr.gamso.service;

import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UsersServiceTest {
    @Autowired
    UsersService usersService;

    @Test
    @Transactional
    @DisplayName("전체 회원 리스트")
    public void findAllUsersTest(){
        List<FindUserDTO> userDTOList = usersService.findAllUsers();

        assertEquals(3, userDTOList.size());
    }

    @Test
    @Transactional
    @DisplayName("새로운 회원 등록")
    public void insertUserTest(){
        SaveUserDTO saveUserDTO = SaveUserDTO.builder()
                .id("qwetr")
                .email("qweq@naver.com")
                .pw("2314trwrte")
                .build();

        usersService.insertUser(saveUserDTO);
        List<FindUserDTO> userDTOList = usersService.findAllUsers();

        assertEquals(4, userDTOList.size());
    }

    @Test
    @Transactional
    @DisplayName("중복 id 확인")
    public void selectUserIDTest(){
        String id = "asd";

        boolean check = usersService.selectUserId(id);

        assertFalse(check);
    }
}
