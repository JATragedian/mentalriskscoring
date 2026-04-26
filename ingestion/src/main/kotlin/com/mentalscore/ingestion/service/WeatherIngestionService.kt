package com.mentalscore.ingestion.service

import com.mentalscore.ingestion.client.WeatherClient
import com.mentalscore.ingestion.mapper.toEvent
import com.mentalscore.ingestion.producer.WeatherProducer
import org.springframework.stereotype.Service

@Service
class WeatherIngestionService(
    private val client: WeatherClient,
    private val producer: WeatherProducer
) {

    fun fetchAndSend(location: String) {
        val event = client.getWeather(location).toEvent(location)
        producer.send(event)
    }
}