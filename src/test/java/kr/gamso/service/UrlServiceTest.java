package kr.gamso.service;

import kr.gamso.dto.urlDTO.FindAllShortenUrlDTO;
import kr.gamso.dto.urlDTO.FindByMemberNumberDTO;
import kr.gamso.dto.urlDTO.FindByUrlNumberDTO;
import kr.gamso.dto.urlDTO.InsertShortenUrlDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("find by url number test")
    public void findByUrlNumberTest(){
        long urlNumber = 2;
        String originalUrl = "www.google.com";
        String shortenUrl = "gamso.kr/32sad";

        FindByUrlNumberDTO findByUrlNumberDTO = urlService.findByUrlNumber(urlNumber);

        assertEquals(originalUrl, findByUrlNumberDTO.getOriginalUrl());
        assertEquals(shortenUrl, findByUrlNumberDTO.getShortenUrl());
    }

    @Test
    @Transactional
    @DisplayName("find by member number test")
    public void findByMemberNumberTest(){
        long memberNumber = 2;
        long urlNumber = 2;

        List<FindByMemberNumberDTO> resultList = urlService.findByMemberNumber(memberNumber);

        assertTrue(resultList.size() > 0);
        assertEquals(3, resultList.size());
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
    @DisplayName("generate Random Shorten url test ")
    // shortenUrl이 null이 아니고, 길이가 8, 허용된 문자를 사용하였는지 테스트
    public void generateRandomShortenUrlTest(){
        long memberNumber = 3;
        String originalUrl = "http://example.com";

        String randomUrl = urlService.generateRandomShortenUrl(originalUrl);

        InsertShortenUrlDTO result = InsertShortenUrlDTO.builder()
                .memberNumber(memberNumber)
                .shortenUrl(randomUrl)
                .originalUrl(originalUrl)
                .build();

        urlService.saveShortenUrl(result);

        List<FindAllShortenUrlDTO> resultList = urlService.findAllShortenUrl();
        FindAllShortenUrlDTO resultLength = resultList.get(resultList.size()-1);

        assertNotNull(randomUrl);
        assertEquals(8, resultLength.getShortenUrl().length());
        assertTrue(resultLength.getShortenUrl().matches("[23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz]+"));
        // 대괄호[]는 어떠한 문자 중 하나를 의미하고, 플러스 + 는 앞의 표현이 한 번 이상 반복되어야 함을 나타냄
    }

    @Test
    @Transactional
    @DisplayName("generate Custom Shorten url test")
    public void generateCustomShortenUrlTest(){
        long memberNumber = 3;
        String originalUrl = "http://example.com";
        String customUrl = "Shorten";

        InsertShortenUrlDTO result = InsertShortenUrlDTO.builder()
                .memberNumber(memberNumber)
                .originalUrl(originalUrl)
                .shortenUrl(customUrl)
                .build();

        urlService.saveShortenUrl(result);

        List<FindAllShortenUrlDTO> resultLocation = urlService.findAllShortenUrl();
        FindAllShortenUrlDTO resultList = resultLocation.get(resultLocation.size()-1);

        assertEquals(customUrl, resultList.getShortenUrl());
        assertEquals(memberNumber, resultList.getMemberNumber());
        assertEquals(originalUrl, resultList.getOriginalUrl());
        assertNotNull(resultList);
    }
}
