package kr.gamso.service;

import kr.gamso.dto.urlDTO.*;
import kr.gamso.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
    public List<FindByMemberNumberDTO> findByMemberNumber(long memberNumber) {
        return urlRepository.findByMemberNumber(memberNumber);
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
        String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
        Random random = new Random();

        StringBuilder randomUrl = new StringBuilder();


        for (int count = 0; count < 8; count++) {
            int base56CharactersIndex = random.nextInt(0, base56Characters.length());
            char base56Character = base56Characters.charAt(base56CharactersIndex);
            randomUrl.append(base56Character);
        }
        return randomUrl.toString();
    }

    @Override
    public String generateCustomShortenUrl (String originalUrl, String shortenUrl){
            InsertShortenUrlDTO generateCustomShortenUrl = new InsertShortenUrlDTO();

            generateCustomShortenUrl.setOriginalUrl(originalUrl);
            generateCustomShortenUrl.setShortenUrl(shortenUrl);

            urlRepository.saveShortenUrl(generateCustomShortenUrl);

            return shortenUrl;
        }
}


