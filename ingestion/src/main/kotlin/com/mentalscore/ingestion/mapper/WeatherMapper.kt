package com.mentalscore.ingestion.mapper

import com.mentalscore.ingestion.client.model.WeatherResponse
import com.mentalscore.ingestion.model.WeatherEvent
import org.springframework.stereotype.Component

@Component
class WeatherMapper {

    fun toEvent(response: WeatherResponse, location: String): WeatherEvent {
        return WeatherEvent(
            location = location,
            temperature = response.main.temp,
            humidity = response.main.humidity,
            pressure = response.main.pressure,
            timestamp = System.currentTimeMillis()
        )
    }
}