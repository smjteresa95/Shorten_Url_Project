package kr.gamso.dto;

import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class FindUserDTO {
    private String id;
    private String email;
    private String pw;
}
