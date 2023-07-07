package kr.gamso.repository;

import kr.gamso.dto.SaveUserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsersRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @DisplayName("user 회원가입 테스트")
    public void saveUserTest(){
        String id = "wsr";
        String email = "wqe@naver.com";
        String pw = "1231asd2";

        SaveUserDTO saveUserDTO = SaveUserDTO.builder()
                .id(id)
                .email(email)
                .pw(pw)
                .build();

//        assertEquals();
    }

    @Test
    @Transactional
    @DisplayName("중복 id 확인")
    public void selectUserIDTest(){
        String id = "asd";

       int cnt = userRepository.selectUserId(id);

       assertEquals(1, cnt);
    }
}
