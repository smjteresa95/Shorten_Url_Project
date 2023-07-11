package kr.gamso.repository;

import kr.gamso.dto.urlDTO.FindAllShortenUrlDTO;
import kr.gamso.dto.urlDTO.FindByUrlNumberDTO;
import kr.gamso.dto.urlDTO.InsertShortenUrlDTO;
import kr.gamso.dto.urlDTO.UpdateShortenUrlDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UrlRepositoryTest {

    @Autowired
    UrlRepository urlRepository;


    @Test
    @Transactional
    @DisplayName("find all Shorten url test")
    public void findAllShortenUrlTest(){

        List<FindAllShortenUrlDTO> findAllShortenUrlDTOList = urlRepository.findAllShortenUrl();

        assertEquals(4, findAllShortenUrlDTOList.size());
    }

    @Test
    @Transactional
    @DisplayName("find url number test")
    public void findByUrlNumberTest(){
        long urlNumber = 2;
        String shortenUrl = "gamso.kr/32sad";
        String originalUrl = "www.google.com";

        FindByUrlNumberDTO findByUrlNumberDTO = urlRepository.findByUrlNumber(urlNumber);

        assertEquals(shortenUrl, findByUrlNumberDTO.getShortenUrl());
        assertEquals(originalUrl, findByUrlNumberDTO.getOriginalUrl());
    }

    @Test
    @Transactional
    @DisplayName("Save Shorten url test")
    public void saveShortenUrlTest(){
        long memberNumber = 3;
        String shortenUrl = "단축된 url";
        String originalUrl = "단축전 url";

        InsertShortenUrlDTO result = InsertShortenUrlDTO.builder()
                .memberNumber(memberNumber)
                .shortenUrl(shortenUrl)
                .originalUrl(originalUrl)
                .build();

        urlRepository.saveShortenUrl(result);

        List<FindAllShortenUrlDTO> resultList = urlRepository.findAllShortenUrl();
        FindAllShortenUrlDTO resultLength = resultList.get(resultList.size() - 1);

        assertEquals(5, urlRepository.findAllShortenUrl().size());
        assertEquals(memberNumber, resultLength.getMemberNumber());
        assertEquals(shortenUrl, resultLength.getShortenUrl());
        assertEquals(originalUrl, resultLength.getOriginalUrl());
    }

    @Test
    @Transactional
    @DisplayName("Delete Shorten url test")
    public void deleteShortenUrlTest(){
        String shortenUrl = "gamso.kr/11sxw2";

        urlRepository.deleteShortenUrl(shortenUrl);

        assertEquals(3, urlRepository.findAllShortenUrl().size());
    }

    @Test
    @Transactional
    @DisplayName("Update Shorten url test")
    public void updateShortenUrlTest(){
        long urlNumber = 4;
        String shortenUrl = "바뀐 단축Url";

        UpdateShortenUrlDTO updateShortenUrlDTO = UpdateShortenUrlDTO.builder()
                .urlNumber(urlNumber)
                .shortenUrl(shortenUrl)
                .build();

        urlRepository.updateShortenUrl(updateShortenUrlDTO);

        FindByUrlNumberDTO result = urlRepository.findByUrlNumber(urlNumber);

        assertEquals(shortenUrl, result.getShortenUrl());
    }

}
