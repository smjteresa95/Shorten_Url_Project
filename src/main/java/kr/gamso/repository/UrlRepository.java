package kr.gamso.repository;

import kr.gamso.dto.urlDTO.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlRepository {
    List<FindAllShortenUrlDTO> findAllShortenUrl();
    FindByUrlNumberDTO findByUrlNumber(long urlNumber);
    List<FindByMemberNumberDTO> findByMemberNumber(long memberNumber);
    void saveShortenUrl(InsertShortenUrlDTO insertShortenUrlDTO);
    void deleteShortenUrl(String shortenUrl);
    void updateShortenUrl(UpdateShortenUrlDTO updateShortenUrlDTO);
}
