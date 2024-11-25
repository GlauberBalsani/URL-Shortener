package com.balsani.urlShortener.services;

import com.balsani.urlShortener.dto.UrlRequest;
import com.balsani.urlShortener.dto.UrlResponse;
import com.balsani.urlShortener.entities.Url;
import com.balsani.urlShortener.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlServices {
    private final UrlRepository repository;
    private final ShortUrlGenerator generator;
    private final HttpServletRequest servletRequest;

    public UrlServices(UrlRepository repository, ShortUrlGenerator generator, HttpServletRequest servletRequest) {
        this.repository = repository;
        this.generator = generator;
        this.servletRequest = servletRequest;
    }

    public UrlResponse generateShortUrl(UrlRequest request) {
        String shortUrl = generator.generateShortUrl(5, 10); 
        Url url = new Url();
        url.setLongUrl(request.longUrl());
        url.setShortUrl(shortUrl);
        url.setCreatedAt(LocalDateTime.now());
        url.setExpiratedAt(LocalDateTime.now().plusMinutes(15));

        Url urlSave = repository.save(url);


        String baseUrl = servletRequest.getScheme() + "://" + servletRequest.getServerName() + ":" + servletRequest.getServerPort() + "/url/";

        return new UrlResponse(
                urlSave.getUrlId(),
                urlSave.getLongUrl(),
                baseUrl + urlSave.getShortUrl(),
                urlSave.getCreatedAt()
        );
    }

    public Optional<UrlResponse> findOriginalUrl(String shortUrl) {
        Optional<Url> urlOptional = repository.findByShortUrl(shortUrl);

        if (urlOptional.isPresent()) {
            Url url = urlOptional.get();
            if (url.getExpiratedAt().isAfter(LocalDateTime.now())) {
                return Optional.of(new UrlResponse(url));
            } else {
                repository.delete(url);
                throw new RuntimeException("URL expirada: " + url.getShortUrl());
            }
        }

        return Optional.empty();
    }


}
