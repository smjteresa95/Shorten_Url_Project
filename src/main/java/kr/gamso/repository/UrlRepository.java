package kr.gamso.repository;

import kr.gamso.dto.ShortenUrlDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlRepository {

    void saveShortenUrl(ShortenUrlDTO shortenUrlDTO);
    List<ShortenUrlDTO> findAllShortenUrl();

    ShortenUrlDTO findShortenUrl(String shortenUrl);

}
