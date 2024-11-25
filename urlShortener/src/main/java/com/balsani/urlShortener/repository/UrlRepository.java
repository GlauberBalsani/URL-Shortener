package com.balsani.urlShortener.repository;

import com.balsani.urlShortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UrlRepository extends JpaRepository<Url, UUID> {
    Optional<Url> findByShortUrl(String shortUrl);
}
