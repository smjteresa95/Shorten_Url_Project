package kr.gamso.dto.urlDTO;

import kr.gamso.entity.Url;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class GenerateRandomShortenUrlDTO {
    private long urlNumber;
    private long memberNumber;
    private String originalUrl;
    private String ShortenUrl;

    public GenerateRandomShortenUrlDTO(Url url){
        this.memberNumber = url.getMemberNumber();
        this.originalUrl = url.getOriginalUrl();
        this.ShortenUrl = url.getShortenUrl();
    }
}
