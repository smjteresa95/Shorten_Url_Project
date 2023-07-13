package kr.gamso.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    EmailService emailService;

    @Test
    @Transactional
    public void sendSimpleMessageTest() throws Exception {
        String key = emailService.sendSimpleMessage("jsap50@naver.com");

        System.out.println(key);
    }
}
