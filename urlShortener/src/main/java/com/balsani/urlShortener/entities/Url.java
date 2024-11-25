package com.balsani.urlShortener.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID urlId;
    private String longUrl;
    private String shortUrl;

    private LocalDateTime createdAt;
    private LocalDateTime expiratedAt;

    public UUID getUrlId() {
        return urlId;
    }

    public void setUrlId(UUID urlId) {
        this.urlId = urlId;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiratedAt() {
        return expiratedAt;
    }

    public void setExpiratedAt(LocalDateTime expiratedAt) {
        this.expiratedAt = expiratedAt;
    }
}
