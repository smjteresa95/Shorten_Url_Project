package kr.gamso.dto.urlDTO;

import kr.gamso.entity.Url;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class FindByMemberNumberDTO {
    private long memberNumber;
    private String originalUrl;
    private String shortenUrl;

    public void FindByMemberNumberDto(Url url){
        this.memberNumber = url.getMemberNumber();
        this.originalUrl = url.getOriginalUrl();
        this.shortenUrl = url.getShortenUrl();
    }
}
