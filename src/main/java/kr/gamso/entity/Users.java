package kr.gamso.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class Users {
    private long memberNumber;
    private String id;
    private String email;
    private String pw;
    private LocalDateTime signupDate;
}
