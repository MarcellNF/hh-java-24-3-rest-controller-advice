package de.neuefische.hhjava243restcontrolleradvice;

import java.time.LocalDateTime;

public record CustomErrorMessage(
        String message,
        LocalDateTime timestamp,
        String urlToDocumentation,
        int statusCode
) {
}
