package kr.gamso.dto;

import kr.gamso.entity.Users;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class SaveUserDTO {
    private String id;
    private String email;
    private String pw;
}