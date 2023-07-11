package kr.gamso.dto.urlDTO;

import kr.gamso.entity.Url;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class UpdateShortenUrlDTO {
    private long urlNumber;
    private String shortenUrl;

    public UpdateShortenUrlDTO(Url url){
        this.urlNumber = url.getUrlNumber();
        this.shortenUrl = url.getShortenUrl();
    }
}
