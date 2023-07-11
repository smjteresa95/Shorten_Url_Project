package kr.gamso.repository;

import kr.gamso.dto.ShortenUrlDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlRepository {

    List<ShortenUrlDTO> findAllShortenUrl();
    void saveShortenUrl(ShortenUrlDTO shortenUrlDTO);


    // ShortenUrlDTO findShortenUrl(String shortenUrl);

}
