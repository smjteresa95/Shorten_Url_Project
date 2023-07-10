package kr.gamso.repository;

import kr.gamso.dto.SaveUserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.gamso.dto.FindUserDTO;
import kr.gamso.dto.SaveUserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @DisplayName("전체 회원 리스트")
    public void findAllUsersTest(){
        List<FindUserDTO> userDTOList = userRepository.findAllUsers();

        assertEquals(3, userDTOList.size());
    }

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

        // assertEquals();
        userRepository.saveUser(saveUserDTO);
        List<FindUserDTO> userDTOList = userRepository.findAllUsers();
        assertEquals(4, userDTOList.size());
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
