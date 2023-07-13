package kr.gamso.dto.userDTO;

import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class SaveUserDTO {
    private String id;
    private String email;
    private String pw;
}
