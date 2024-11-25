package com.balsani.urlShortener.dto;

import com.balsani.urlShortener.entities.Url;

public record UrlRequest(
        String longUrl
) {
    public static UrlRequest toModel(Url url) {
        return new UrlRequest(
                url.getLongUrl()
        );
    }
}
