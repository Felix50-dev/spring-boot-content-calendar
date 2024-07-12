package com.root.content_calendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cc")
public record ContentCalendarProperties(
        String welcomeMessage,
        String about
) {
}
