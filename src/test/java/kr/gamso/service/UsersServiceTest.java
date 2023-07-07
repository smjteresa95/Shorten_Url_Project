package kr.gamso.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsersServiceTest {
    @Autowired
    UsersService usersService;

    @Test
    @Transactional
    @DisplayName("중복 id 확인")
    public void selectUserIDTest(){
        String id = "asd";

        int check = usersService.selectUserId(id);

        assertEquals(1, check);
    }
}
