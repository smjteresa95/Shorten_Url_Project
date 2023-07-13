package kr.gamso.dto.urlDTO;

import kr.gamso.entity.Url;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class InsertShortenUrlDTO {
    private long memberNumber;
    private String originalUrl;
    private String shortenUrl;

    public InsertShortenUrlDTO(Url url){
        this.memberNumber = url.getMemberNumber();
        this.originalUrl = url.getOriginalUrl();
        this.shortenUrl = url.getShortenUrl();
    }
}
