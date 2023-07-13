package kr.gamso.service;

import kr.gamso.dto.urlDTO.*;

import java.util.List;

public interface UrlService {
    List<FindAllShortenUrlDTO> findAllShortenUrl();
    FindByUrlNumberDTO findByUrlNumber(long urlNumber);
    List<FindByMemberNumberDTO> findByMemberNumber(long memberNumber);
    void saveShortenUrl(InsertShortenUrlDTO findAllShortenUrlDTO);
    void deleteShortenUrl(String shortenUrl);
    void updateShortenUrl(UpdateShortenUrlDTO updateShortenUrlDTO);
    String generateRandomShortenUrl(String originalUrl);
    String generateCustomShortenUrl(String originalUrl, String shortenUrl);
}
