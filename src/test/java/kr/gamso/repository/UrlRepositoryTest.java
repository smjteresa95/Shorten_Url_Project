package kr.gamso.repository;

import kr.gamso.dto.ShortenUrlDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class UrlRepositoryTest {

    @Autowired
    UrlRepository urlRepository;

    @Test
    @Transactional
    @DisplayName("Shorten url test")
    public void saveShortenUrlTest(){
        String shortenUrl = "단축된 url";
        String originalUrl = "단축전 url";

        ShortenUrlDTO result = ShortenUrlDTO.builder()
                .ShortenUrl(shortenUrl)
                .originalUrl(originalUrl)
                .build();

        urlRepository.saveShortenUrl(result);
         //
    }
}
