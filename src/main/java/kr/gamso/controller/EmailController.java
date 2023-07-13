package kr.gamso.controller;

import kr.gamso.dto.emailDTO.EmailCheckNumberDTO;
import kr.gamso.dto.emailDTO.SendEmailDTO;
import kr.gamso.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {
    EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<EmailCheckNumberDTO> emailConfirm(@RequestBody SendEmailDTO sendEmailDTO) throws Exception {
        String email = sendEmailDTO.getEmail();
        System.out.println(email);

        String code = emailService.sendSimpleMessage(email);
        EmailCheckNumberDTO emailCheckNumberDTO = EmailCheckNumberDTO.builder()
                .code(code)
                .build();
        return ResponseEntity.ok(emailCheckNumberDTO);
    }
}