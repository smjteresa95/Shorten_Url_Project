package kr.gamso.dto.urlDTO;

import kr.gamso.entity.Url;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class FindByUrlNumberDTO {
    private long urlNumber;
    private String shortenUrl;
    private String originalUrl;

    public FindByUrlNumberDTO(Url url){
        this.urlNumber = url.getUrlNumber();
        this.shortenUrl = url.getShortenUrl();
        this.originalUrl = url.getOriginalUrl();
    }

}
