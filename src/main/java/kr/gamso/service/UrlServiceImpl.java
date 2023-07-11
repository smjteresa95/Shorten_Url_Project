package kr.gamso.service;

import kr.gamso.dto.urlDTO.*;
import kr.gamso.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public List<FindAllShortenUrlDTO> findAllShortenUrl() {
        return urlRepository.findAllShortenUrl();
    }

    @Override
    public FindByUrlNumberDTO findByUrlNumber(long urlNumber) {
        return urlRepository.findByUrlNumber(urlNumber);
    }

    @Override
    public void saveShortenUrl(InsertShortenUrlDTO insertShortenUrlDTO) {
            urlRepository.saveShortenUrl(insertShortenUrlDTO);
    }

    @Override
    public void deleteShortenUrl(String shortenUrl) {
        urlRepository.deleteShortenUrl(shortenUrl);
    }

    @Override
    public void updateShortenUrl(UpdateShortenUrlDTO updateShortenUrlDTO) {
        urlRepository.updateShortenUrl(updateShortenUrlDTO);
    }

    @Override
    public String generateRandomShortenUrl(String originalUrl) {
        return null;
    }

    @Override
    public String generateCustomShortenUrl(String originalUrl) {
        return null;
    }
}
