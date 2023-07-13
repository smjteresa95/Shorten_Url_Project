package kr.gamso.dto.userDTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuplicateCheckIdDTO {
    private long checkCnt;
}
