package com.mentalscore.ingestion.service

import com.mentalscore.ingestion.client.WeatherClient
import com.mentalscore.ingestion.mapper.WeatherMapper
import com.mentalscore.ingestion.producer.WeatherProducer
import org.springframework.stereotype.Service

@Service
class WeatherIngestionService(
    private val client: WeatherClient,
    private val mapper: WeatherMapper,
    private val producer: WeatherProducer
) {

    fun fetchAndSend(location: String) {
        val response = client.getWeather(location)
        val event = mapper.toEvent(response, location)
        producer.send(event)
    }
}