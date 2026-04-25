package com.mentalscore.ingestion.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "weather")
data class WeatherProperties(
    val apiKey: String
)
