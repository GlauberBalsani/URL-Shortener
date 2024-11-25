package com.balsani.urlShortener.contoller;

import com.balsani.urlShortener.dto.UrlRequest;
import com.balsani.urlShortener.dto.UrlResponse;
import com.balsani.urlShortener.entities.Url;
import com.balsani.urlShortener.services.UrlServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/url")
public class UrlController {
   private final UrlServices services;

    public UrlController(UrlServices services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<UrlResponse> shortenUrl(@RequestBody UrlRequest request   ) {
        UrlResponse urlResponse = services.generateShortUrl(request);
        return ResponseEntity.ok(urlResponse);
    }

    @GetMapping("/{shortUrl}")
    public void redirectToOriginalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        Optional<UrlResponse> urlResponseOptional = services.findOriginalUrl(shortUrl);

        if (urlResponseOptional.isPresent()) {

            response.sendRedirect(urlResponseOptional.get().longUrl());
        } else {

            response.sendError(HttpServletResponse.SC_NOT_FOUND, "URL não encontrada");
        }
    }



}
