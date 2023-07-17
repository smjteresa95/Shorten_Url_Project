package kr.gamso.dto.userDTO;

import kr.gamso.entity.Users;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class SaveUserDTO {
    private String id;
    private String email;
    private String pw;

    public Users toEntity(){
        return Users.builder()
                .id(this.id).email(this.email).pw(this.pw).build();
    }
}
