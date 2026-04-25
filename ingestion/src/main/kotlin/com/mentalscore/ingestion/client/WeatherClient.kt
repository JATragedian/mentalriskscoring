package com.mentalscore.ingestion.client

import com.mentalscore.ingestion.client.model.WeatherResponse
import com.mentalscore.ingestion.config.WeatherProperties
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class WeatherClient(
    private val webClient: WebClient,
    private val properties: WeatherProperties
) {

    fun getWeather(location: String): WeatherResponse {
        return webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/weather")
                    .queryParam("q", location)
                    .queryParam("appid", properties.apiKey)
                    .build()
            }
            .retrieve()
            .bodyToMono(WeatherResponse::class.java)
            .block()!!
    }
}