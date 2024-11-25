package com.balsani.urlShortener.dto;

import com.balsani.urlShortener.entities.Url;

import java.time.LocalDateTime;
import java.util.UUID;

public record UrlResponse(UUID urlId, String longUrl, String shortUrl, LocalDateTime createdAt) {
    public  UrlResponse(Url url) {
        this(url.getUrlId(),url.getLongUrl(), url.getShortUrl(), url.getCreatedAt());
    }
}
