package kr.gamso.dto;

import kr.gamso.entity.Url;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class ShortenUrlDTO {
    private String originalUrl;
    private String ShortenUrl;

    public ShortenUrlDTO(Url url){
        this.originalUrl = url.getOriginalUrl();
        this.ShortenUrl = url.getShortenUrl();
    }
}
