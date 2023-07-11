package kr.gamso.service;

import kr.gamso.dto.urlDTO.FindAllShortenUrlDTO;
import kr.gamso.dto.urlDTO.FindByUrlNumberDTO;
import kr.gamso.dto.urlDTO.InsertShortenUrlDTO;
import kr.gamso.dto.urlDTO.UpdateShortenUrlDTO;

import java.util.List;

public interface UrlService {
    List<FindAllShortenUrlDTO> findAllShortenUrl();
    FindByUrlNumberDTO findByUrlNumber(long urlNumber);
    void saveShortenUrl(InsertShortenUrlDTO findAllShortenUrlDTO);
    void deleteShortenUrl(String shortenUrl);
    void updateShortenUrl(UpdateShortenUrlDTO updateShortenUrlDTO);
    String generateRandomShortenUrl(String originalUrl);
    String generateCustomShortenUrl(String originalUrl);
}
