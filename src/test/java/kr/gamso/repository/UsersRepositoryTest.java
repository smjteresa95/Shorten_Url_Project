package kr.gamso.repository;

import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;
import kr.gamso.dto.FindUserByIdDTO;

import java.util.List;
import java.util.Optional;

import kr.gamso.entity.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @DisplayName("전체 회원 리스트")
    public void findAllTest(){
        List<Users> usersList = userRepository.findAll();

        assertEquals(3, usersList.size());
    }

    @Test
    @Transactional
    @DisplayName("user 회원가입 테스트")
    public void saveTest(){
        String id = "wsr";
        String email = "wqe@naver.com";
        String pw = "1231asd2";

        Users user = Users.builder()
                .id(id)
                .email(email)
                .pw(pw)
                .build();

        userRepository.save(user);
        List<Users> usersList = userRepository.findAll();
        assertEquals(4, usersList.size());
    }


    @Test
    public void findByIdTest(){
        String id = "asd";
        String email = "hjk@naver.com";
        String pw = "1234";

        Optional<Users> user = userRepository.findById(id);

        assertThat(user.get().getEmail()).isEqualTo(email);
        assertThat(user.get().getPw()).isEqualTo(pw);
    }

    @Test
    @DisplayName("findByEmail method test")
    public void findByEmailTest(){

        String id = "asd";
        String email = "hjk@naver.com";
        String pw = "1234";

        Optional<Users> user = userRepository.findByEmail(email);

        assertThat(user.get().getId()).isEqualTo(id);
        assertThat(user.get().getPassword()).isEqualTo(pw);
    }


}
