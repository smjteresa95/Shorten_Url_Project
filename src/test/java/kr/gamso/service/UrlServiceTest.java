package kr.gamso.service;

import kr.gamso.dto.urlDTO.FindAllShortenUrlDTO;
import kr.gamso.dto.urlDTO.InsertShortenUrlDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

@SpringBootTest
public class UrlServiceTest {

    @Autowired
    UrlService urlService;

    @Test
    @Transactional
    @DisplayName("find all shorten url test")
    public void findAllShortenUrlTest(){

        List<FindAllShortenUrlDTO> result = urlService.findAllShortenUrl();

        assertEquals(4, result.size());
    }

    @Test
    @Transactional
    @DisplayName("save shorten url test")
    public void saveShortenUrlTest(){
        long memberNumber = 3;
        String shortenUrl = "단축된 url";
        String originalUrl = "단축전 url";

        InsertShortenUrlDTO insertShortenUrlDTO = InsertShortenUrlDTO.builder()
                .memberNumber(memberNumber)
                .shortenUrl(shortenUrl)
                .originalUrl(originalUrl)
                .build();

        urlService.saveShortenUrl(insertShortenUrlDTO);

        List<FindAllShortenUrlDTO> resultList = urlService.findAllShortenUrl();
        FindAllShortenUrlDTO resultLength = resultList.get(resultList.size()-1);

        assertEquals(memberNumber, resultLength.getMemberNumber());
        assertEquals(shortenUrl, resultLength.getShortenUrl());
        assertEquals(originalUrl, resultLength.getOriginalUrl());
        assertEquals(5, resultList.size());

    }

    @Test
    @Transactional
    @DisplayName("delete shorten url test")
    public void deleteShortenUrlTest(){
        String shortenUrl = "gamso.kr/11sxw2";

        urlService.deleteShortenUrl(shortenUrl);

        List<FindAllShortenUrlDTO> result = urlService.findAllShortenUrl();

        assertEquals(3, urlService.findAllShortenUrl().size());
    }

    @Test
    @Transactional
    @DisplayName("generate Shorten url test ")
    public void generateShortenUrlTest(){

    }
}
