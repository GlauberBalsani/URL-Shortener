package com.balsani.urlShortener.services;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class ShortUrlGenerator {
    public  String generateShortUrl(int minLength, int maxLength) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder();

        int size = random.nextInt(minLength, maxLength + 1 );

        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(chars.length());
            builder.append(chars.charAt(randomIndex));
        }
        return builder.toString();
    }
}
