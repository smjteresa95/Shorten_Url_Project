package kr.gamso.repository;

import kr.gamso.dto.FindUserByIdDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void findUserByIdTest(){
        String id = "asd";
        String email = "hjk@naver.com";
        String pw = "1234";

        FindUserByIdDTO user = userRepository.findUserById(id);

        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPw()).isEqualTo(pw);
    }
}
