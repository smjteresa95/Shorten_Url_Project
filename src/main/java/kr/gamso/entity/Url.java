package kr.gamso.entity;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Url {
    private long urlNumber;
    private long memberNumber;
    private String originalUrl;
    private String ShortenUrl;
    private LocalDateTime shortenDate;
}
